package su.levenetc.algorithms.rxjava;

import rx.Observable;
import su.levenetc.algorithms.RXJava;
import su.levenetc.algorithms.RetrofitConfig;

/**
 * Created by elevenetc on 21/06/15.
 */
public class FailTask {
	private RetrofitConfig.API api;

	public FailTask(RetrofitConfig.API api) {
		this.api = api;
	}

	public Observable<SomeObject> execute() {
		return api.get500()
				.retry(4)
				.onErrorResumeNext(throwable -> {
					RXJava.println("log backend error:" + throwable);
					return Observable.just(new BaseResponse(RetrofitConfig.RESULT_ERROR, null, throwable));
				})
				.flatMap((BaseResponse baseResponse) -> {
					if (baseResponse == null || RetrofitConfig.RESULT_ERROR.equals(baseResponse.result)) {
						RXJava.println("flatMap baseResponse == null || result == error");
						RXJava.println("query db and return empty");

						//TODO: check if baseResponse.error is instance of absence of internet error

						return Observable.from(new SomeObject[]{new SomeObject("empty")});
					} else {
						return Observable.from(new SomeObject[]{new SomeObject(baseResponse.data)});
					}
				});
	}

}
