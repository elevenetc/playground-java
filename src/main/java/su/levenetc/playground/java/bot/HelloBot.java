package su.levenetc.playground.java.bot;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import su.levenetc.playground.java.bot.wws.TyrusWWSClient;

/**
 * Created by eugene.levenetc on 21/10/2016.
 */
public class HelloBot {

    private final String BOT_TOKEN = System.getenv("BOT_TOKEN");
    private Api api;

    public static HelloBot create() {
        return new HelloBot();
    }

    private HelloBot() {

    }

    public void init() {
        initApi();
        authAndOpenConnection();
    }

    private void authAndOpenConnection() {
        api.authorize(BOT_TOKEN).subscribe(
                response -> openConnection(response.url),
                Throwable::printStackTrace
        );
    }

    private void initApi() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://slack.com/api/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    private void openConnection(String url) {
        new TyrusWWSClient(url).connect();

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

}
