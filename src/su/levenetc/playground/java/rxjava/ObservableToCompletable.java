package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Subscriber;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 23/07/2016.
 */
public class ObservableToCompletable {
	public static void run() {
		getO().toCompletable().subscribe(() -> {
			Out.pln("completed");
		});
	}

	private static Observable<String> getO() {
		return Observable.create(new Observable.OnSubscribe<String>() {
			@Override public void call(Subscriber<? super String> subscriber) {
				Out.pln("onNext");
				subscriber.onNext("result");
				subscriber.onCompleted();
			}
		});
	}
}
