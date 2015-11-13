package su.levenetc.algorithms.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import su.levenetc.algorithms.utils.Objects;
import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 13/11/15.
 */
public class RXCast {

	public static void run() {
		Observable<Object> casted = getA().cast(Object.class);
		casted.subscribe(new Action1<Object>() {
			@Override
			public void call(Object o) {
				Out.pln("Result:" + o);
			}
		});
	}

	private static Observable<Objects.A> getA() {
		return Observable.create(new Observable.OnSubscribe<Objects.A>() {
			@Override
			public void call(Subscriber<? super Objects.A> subscriber) {
				subscriber.onNext(new Objects.A());
				subscriber.onCompleted();
			}
		});
	}

}