package su.levenetc.playground.java.bot.platforms.slack;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
    public Observable<Message> getPersonalMessagesObservable() {
        return getAllMessagesObservable().filter(message -> {

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
    public Observable<Message> getAllMessagesObservable() {
        return super.getAllMessagesObservable().filter(message -> message.getMessageType() == SlackMessageTypes.MESSAGE);
    }

    @Override
    public Single<InitData> start() {
        initApi();
        return authAndOpenConnection();
    }

    @Override
    public Observable<User> loadUsers() {
        return null;
    }

    @Override
    public Single<Object> sendMessage(Message message) {
        return messageParser.toByte(message).flatMap(new Function<byte[], SingleSource<Object>>() {
            @Override
            public SingleSource<Object> apply(byte[] bytes) throws Exception {
                return socketClient.sendMessage(bytes);
            }
        });
    }

    @Override
    public Message.Builder respondTo(Message message) {
        final Message.Builder builder = new Message.Builder();
        builder.respondTo(message);
        return builder;
    }

    private Single<InitData> authAndOpenConnection() {

        return api.authorize(token).flatMap(new Function<RtmStartResponse, SingleSource<InitData>>() {
            @Override
            public SingleSource<InitData> apply(RtmStartResponse rtmResponse) throws Exception {

                return openConnection(rtmResponse.url).flatMap(stringObservable -> {
                    stringObservable.subscribe(SlackPlatform.this::handleRawMessage, SlackPlatform.this::handleErrorMessage);

                    InitData initData = new InitData();
                    initData.setCurrentUserId(rtmResponse.self.id);

                    List<Channel> channels = new ArrayList<Channel>();

                    for (RtmStartResponse.Ims im : rtmResponse.ims) {
                        Channel channel = new Channel();
                        channel.setId(im.id);
                        channel.setUserChannel(true);
                        channels.add(channel);
                    }

                    for (RtmStartResponse.Channel c : rtmResponse.channels) {
                        Channel channel = new Channel();
                        channel.setId(c.id);
                        channels.add(channel);
                    }

                    initData.setChannels(channels);

                    return Single.just(initData);
                });
            }
        });
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

    interface SlackApi {
        @GET("rtm.start")
        Single<RtmStartResponse> authorize(@Query("token") String token);

        @GET("bots.info")
        Single<BotInfoResponse> botInfo(@Query("token") String token);
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
            boolean is_im;

        }

        static class Channel {
            String id;
        }
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


}
