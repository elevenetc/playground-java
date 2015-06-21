package su.levenetc.algorithms;

import com.google.gson.Gson;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.mime.TypedString;
import rx.Observable;
import su.levenetc.algorithms.rxjava.BaseResponse;

import java.util.ArrayList;

/**
 * Created by elevenetc on 21/06/15.
 */
public class RetrofitConfig {


	public static final String GET_A_200 = "/getA";
	public static final String GET_B_200 = "/getB";
	public static final String GET_200 = "/get200";
	public static final String GET_400 = "/get400";
	public static final String GET_500 = "/get500";
	public static String RESULT_OK = "ok";
	public static String RESULT_ERROR = "error";

	public static API initAPI() {
		final Gson gson = new Gson();
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setEndpoint("http://ya.ru")
				.setClient(request -> {

					String url = request.getUrl();

					System.out.println("request:" + url + " at " + Thread.currentThread());

					if (url.contains(GET_200)) {
						TypedString body = new TypedString(gson.toJson(new BaseResponse(RESULT_OK, "data")));
						return new Response("", 200, "", new ArrayList<>(), body);
					} else if (url.contains(GET_400)) {
						TypedString body = new TypedString(gson.toJson(new BaseResponse(RESULT_ERROR, null)));
						return new Response("", 400, "", new ArrayList<>(), body);
					} else if (url.contains(GET_A_200)) {
						TypedString body = new TypedString(gson.toJson(new BaseResponse(RESULT_OK, "A")));
						return new Response("", 200, "", new ArrayList<>(), body);
					} else if (url.contains(GET_B_200)) {
						TypedString body = new TypedString(gson.toJson(new BaseResponse(RESULT_OK, "B")));
						return new Response("", 200, "", new ArrayList<>(), body);
					} else {
						return new Response("", 500, "", new ArrayList<>(), null);
					}

				})
				.build();
		return restAdapter.create(API.class);
	}

	public interface API {
		@GET(GET_A_200) Observable<BaseResponse> getObjectA();

		@GET(GET_B_200) Observable<BaseResponse> getObjectB();

		@GET(GET_200) Observable<BaseResponse> get200();

		@GET(GET_400) Observable<BaseResponse> get400();

		@GET(GET_500) Observable<BaseResponse> get500();
	}

}