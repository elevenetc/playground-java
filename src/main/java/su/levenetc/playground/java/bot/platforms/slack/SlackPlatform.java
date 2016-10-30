package su.levenetc.playground.java.bot.platforms.slack;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import su.levenetc.playground.java.bot.models.Channel;
import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.models.User;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.wws.SocketClient;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.RuntimeUtils;

import java.util.ArrayList;
import java.util.List;

import static su.levenetc.playground.java.bot.platforms.slack.mappers.Mappers.toUsers;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class SlackPlatform extends Platform {

    private final MessageParser messageParser;
    private final String token;
    private SlackApi api;
    private SocketClient socketClient;

    public SlackPlatform(
            SocketClient socketClient,
            MessageParser messageParser,
            String token
    ) {
        RuntimeUtils.nullCheck(socketClient, messageParser, token);
        this.socketClient = socketClient;
        this.messageParser = messageParser;
        this.token = token;
    }

    @Override
    public Observable<Message> personalMessages() {
        return allMessages().filter(message -> {

            final List<Channel> channels = getInitData().getChannels();

            for (Channel channel : channels) {
                if (channel.isUserChannel() && message.getTarget().getId().equals(channel.getId())) {
                    return true;
                }
            }

            return false;
        });
    }

    @Override
    public Observable<Message> allMessages() {
        return super.allMessages().filter(message -> message.getMessageType() == SlackMessageTypes.MESSAGE);
    }

    @Override
    public Single<InitData> start() {
        initApi();
        return authAndOpenConnection();
    }

    @Override
    public Single<List<User>> getUsers() {
        return api.users(token).map(toUsers());
    }

    @Override
    public Single<Object> sendMessage(Message.Builder builder) {

        Message message = null;

        if (Message.Builder.Action.RESPOND_TO.equals(builder.getAction())) {
            final Message respondMessage = builder.getRespondMessage();
            final String text = builder.getText();

            message = new Message();
            message.setText(text);
            message.setChannelId(respondMessage.getChannelId());
        }

        return messageParser.toByte(message).flatMap(new Function<byte[], SingleSource<Object>>() {
            @Override
            public SingleSource<Object> apply(byte[] bytes) throws Exception {
                return socketClient.sendMessage(bytes);
            }
        });
    }

    private Single<InitData> authAndOpenConnection() {

        return api.authorize(token).flatMap(new Function<RtmStartResponse, SingleSource<InitData>>() {
            @Override
            public SingleSource<InitData> apply(RtmStartResponse rtmResponse) throws Exception {

                return openConnection(rtmResponse.url).flatMap(stringObservable -> {
                    stringObservable.subscribe(SlackPlatform.this::handleRawMessage, SlackPlatform.this::handleErrorMessage);
                    return Single.just(parseInitData(rtmResponse));
                });
            }
        });
    }

    @NotNull
    private InitData parseInitData(RtmStartResponse rtmResponse) {
        InitData initData = new InitData();
        initData.setCurrentUserId(rtmResponse.self.id);

        List<Channel> channels = new ArrayList<>();

        for (RtmStartResponse.Ims im : rtmResponse.ims) {
            Channel channel = new Channel();
            channel.setId(im.id);
            channel.setUserId(im.user);
            channel.setUserChannel(true);
            channels.add(channel);
        }

        for (RtmStartResponse.Channel c : rtmResponse.channels) {
            Channel channel = new Channel();
            channel.setId(c.id);
            channels.add(channel);
        }

        initData.setChannels(channels);
        return initData;
    }

    private void handleErrorMessage(Throwable throwable) {
        Out.pln("Error message:");
        throwable.printStackTrace();
    }

    private void handleRawMessage(String rawMessage) {
        Out.pln("New message: " + rawMessage);
        messageParser.parse(rawMessage).subscribe(this::handleParsedMessage);
    }

    private void initApi() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://slack.com/api/")
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(SlackApi.class);
    }

    private Single<Observable<String>> openConnection(String url) {
        return socketClient.connect(url);
    }

    private String getChannelIdByUserId(String userId) {
        final List<Channel> channels = getInitData().getChannels();
        for (Channel channel : channels) {
            if (userId.equals(channel.getUserId())) {
                return channel.getId();
            }
        }
        return null;
    }

    interface SlackApi {
        @GET("rtm.start")
        Single<RtmStartResponse> authorize(@Query("token") String token);

        @GET("bots.info")
        Single<BotInfoResponse> botInfo(@Query("token") String token);

        @GET("users.list")
        Single<UsersResponse> users(@Query("token") String token);
    }

    public static class RtmStartResponse {

        public String url;
        public Self self;
        public Ims[] ims;
        public Channel[] channels;

        public static class Self {
            String id;
        }

        public static class Ims {
            String id;
            String user;
            boolean is_im;
        }

        static class Channel {
            String id;
        }
    }

    public static class UsersResponse {
        public SlackUser[] members;
    }

    public static class BotInfoResponse {

        public Bot bot;

        private static class Bot {
            public String id;
        }
    }

    public interface MessageParser {
        Single<byte[]> toByte(Message message);

        Single<Message> parse(String rawMessage);

        interface Factory {
            MessageParser create();
        }
    }

    public static class SlackUser {
        public String id;
        public String name;
    }


}
