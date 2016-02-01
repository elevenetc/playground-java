package su.levenetc.playground.java.rxjava;

import rx.Observable;
import su.levenetc.playground.java.RetrofitConfig;

/**
 * Created by elevenetc on 21/06/15.
 */
public class SuccessTask {
	private RetrofitConfig.API api;

	public SuccessTask(RetrofitConfig.API api) {
		this.api = api;
	}

	public Observable<SomeObject> execute() {
		Observable<BaseResponse> observable200 = api.get200();
		return observable200.map(backendModel -> new SomeObject("ok"));
	}
}
