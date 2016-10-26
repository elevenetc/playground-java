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
import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.models.User;
import su.levenetc.playground.java.bot.platforms.Platform;
import su.levenetc.playground.java.bot.wws.SocketClient;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.RuntimeUtils;

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
    public Single<Object> start() {
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

    private Single<Object> authAndOpenConnection() {
        return api.authorize(token).flatMap(new Function<RtmStartResponse, SingleSource<Object>>() {
            @Override
            public SingleSource<Object> apply(RtmStartResponse response) throws Exception {
                return openConnection(response.url).flatMap(new Function<Observable<String>, SingleSource<Object>>() {
                    @Override
                    public SingleSource<Object> apply(Observable<String> stringObservable) throws Exception {
                        stringObservable.subscribe(SlackPlatform.this::handleRawMessage, SlackPlatform.this::handleErrorMessage);
                        return Single.just(new Object());
                    }
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
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
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
    }

    public static class RtmStartResponse {
        public String url;
    }

    public interface MessageParser {
        Single<byte[]> toByte(Message message);

        Single<Message> parse(String rawMessage);

        interface Factory {
            MessageParser create();
        }
    }


}
