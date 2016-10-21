package su.levenetc.playground.java.bot;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.glassfish.tyrus.client.ClientManager;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Action1;

import javax.websocket.*;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by eugene.levenetc on 21/10/2016.
 */
public class HelloBot {

    public static HelloBot create() {
        return new HelloBot();
    }

    private HelloBot() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://slack.com/api/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        final String botToken = System.getenv("BOT_TOKEN");
        api.authorize(botToken).subscribe(new Action1<RtmStartResponse>() {
            @Override
            public void call(RtmStartResponse response) {
                new WWSClient(response.url);
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }

    interface Api {
        @GET("rtm.start")
        Observable<RtmStartResponse> authorize(
                @Query("token") String token
        );
    }

    public static class RtmStartResponse {
        public String url;
    }

    @ClientEndpoint
    public static class WWSClient {
        public WWSClient(String url) {
            final URI uri = URI.create(url);

//            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            ClientManager client = ClientManager.createClient();

            try {
                client.setAsyncSendTimeout(1000);
                final Future<Session> future = client.asyncConnectToServer(this, uri);
                final Session session = future.get();
                if (session == null) {

                }
            } catch (DeploymentException | ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @OnOpen
        public void onOpen(Session userSession) {
            if (userSession == null) {

            }
        }

        @OnClose
        public void onClose(Session userSession, CloseReason reason) {
            if (userSession == null) {

            }
        }

        @OnError
        public void onError(Throwable throwable) {
            if (throwable == null) {

            }
        }

        @OnMessage
        public void onMessage(String message) {
            if (message == null) {

            }
        }
    }

}
