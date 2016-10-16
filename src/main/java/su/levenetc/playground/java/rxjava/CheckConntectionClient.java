package su.levenetc.playground.java.rxjava;


import rx.Observable;
import su.levenetc.playground.java.RXJava;
import su.levenetc.playground.java.RetrofitConfig;

/**
 * Created by elevenetc on 21/06/15.
 */
public class CheckConntectionClient {

	private Observable<BaseResponse> observable;

	public void start() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		observable = api.get200();
		observable.doOnSubscribe(() -> {
			//throw new NoConnectionException();
		}).subscribe(this::success, this::error);
	}

	private void success(BaseResponse response) {
		RXJava.println("success:" + response);
	}

	private void error(Throwable throwable) {
		RXJava.println("error:" + throwable);
	}
}
