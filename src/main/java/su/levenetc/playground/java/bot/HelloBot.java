package su.levenetc.playground.java.bot;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Action1;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;

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
        api.authorize("").subscribe(new Action1<RtmStartResponse>() {
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

    private static class WWSClient {
        public WWSClient(String url) {
            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
            try {
                final Session session = container.connectToServer(this, URI.create(url));
                session.addMessageHandler(new MessageHandler.Whole<String>() {

                    @Override
                    public void onMessage(String message) {
                        if (message == null) {

                        }
                    }
                });
            } catch (DeploymentException | IOException e) {
                e.printStackTrace();
            }
        }
    }

}
