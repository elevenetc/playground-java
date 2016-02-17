package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by levenetc on 16/02/16.
 */
public class IfOnCompleteCalled {
	public static void run() {
		Observable.create(new Observable.OnSubscribe<Object>() {
			@Override
			public void call(Subscriber<? super Object> subscriber) {
//				subscriber.onNext(null);
				subscriber.onError(null);
//				subscriber.onCompleted();
			}
		}).finallyDo(new Action0() {
			@Override
			public void call() {
				Out.pln("finally");
			}
		})
				.subscribe(IfOnCompleteCalled::handleOk, IfOnCompleteCalled::handleError, IfOnCompleteCalled::handleComplete);
	}

	private static void handleOk(Object result) {
		Out.pln("ok");
	}

	private static void handleError(Throwable result) {
		Out.pln("error");
	}

	private static void handleComplete() {
		Out.pln("complete");
	}
}
