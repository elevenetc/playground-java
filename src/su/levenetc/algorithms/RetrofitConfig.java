package su.levenetc.algorithms;

import com.google.gson.Gson;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.mime.TypedString;
import rx.Observable;

import java.util.ArrayList;

/**
 * Created by elevenetc on 21/06/15.
 */
public class RetrofitConfig {


	public static final String GET_200 = "/get200";
	public static final String GET_400 = "/get400";
	public static String RESULT_OK = "ok";
	public static String RESULT_ERROR = "error";

	public static API initAPI() {
		final Gson gson = new Gson();
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint("http://ya.ru")
				.setClient(request -> {

					String url = request.getUrl();

					System.out.println("request:" + url);

					if (url.contains(GET_200)) {
						TypedString body = new TypedString(gson.toJson(new BackendModel(RESULT_OK)));
						return new Response("", 200, "", new ArrayList<>(), body);
					} else {
						TypedString body = new TypedString(gson.toJson(new BackendModel(RESULT_ERROR)));
						return new Response("", 400, "", new ArrayList<>(), body);
					}

				})
				.build();
		return restAdapter.create(API.class);
	}

	public interface API {
		@GET(GET_200) Observable<BackendModel> get200();

		@GET(GET_400) Observable<BackendModel> get400();
	}

	public static class BackendModel {
		public String result;

		public BackendModel(String result) {
			this.result = result;
		}

		@Override public String toString() {
			return "BackendModel{" +
					"result='" + result + '\'' +
					'}';
		}
	}
}