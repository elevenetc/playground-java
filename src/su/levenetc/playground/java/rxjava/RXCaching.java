package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Subscriber;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by levenetc on 12/10/15.
 */
public class RXCaching {
	public static void run() {
		Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
			@Override
			public void call(Subscriber<? super String> subscriber) {
				Out.pln("called");
				subscriber.onStart();
				subscriber.onError(new Exception("error"));
				//subscriber.onNext(">");
				subscriber.onCompleted();
			}
		}).cache();


		observable.subscribe(RXCaching::handleResult, RXCaching::onError);
		observable.subscribe(RXCaching::handleResult, RXCaching::onError);
		observable.subscribe(new Subscriber<String>() {
			@Override
			public void onCompleted() {

			}

			@Override
			public void onError(Throwable throwable) {
				Out.pln("B:error:" + throwable.toString());
			}

			@Override
			public void onNext(String result) {
				Out.pln("B" + result);
			}
		});
	}

	private static void onError(Throwable throwable) {
		Out.pln("A:error:" + throwable.toString());
	}

	private static void handleResult(String result) {
		Out.pln("A" + result);
	}
}