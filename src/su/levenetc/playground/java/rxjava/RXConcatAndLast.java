package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by levenetc on 29/10/15.
 */
public class RXConcatAndLast {

	private static final boolean checkErrorA = true;
	private static final boolean checkErrorB = false;

	public static void run() {
		Action1<Throwable> onError = new Action1<Throwable>() {
			@Override
			public void call(Throwable throwable) {
				Out.pln("error handler");
			}
		};

		Action1<Object> onNext = new Action1<Object>() {
			@Override
			public void call(Object o) {
				Out.pln("on next:" + o);
			}
		};

		Observable.concat(getA(), getB()).last().subscribe(onNext, onError);
	}

	private static Observable<Results.A> getA() {
		return Observable.create(new Observable.OnSubscribe<Results.A>() {
			@Override
			public void call(Subscriber<? super Results.A> subscriber) {
				if (checkErrorA) {
					subscriber.onError(new Exception("no " + Results.A.class));
				} else {
					subscriber.onNext(new Results.A());
					subscriber.onCompleted();
				}
			}
		});
	}

	private static Observable<Results.B> getB() {
		return Observable.create(new Observable.OnSubscribe<Results.B>() {
			@Override
			public void call(Subscriber<? super Results.B> subscriber) {
				if (checkErrorB) {
					subscriber.onError(new Exception("no " + Results.B.class));
				} else {
					subscriber.onNext(new Results.B());
					subscriber.onCompleted();
				}
			}
		});
	}
}
