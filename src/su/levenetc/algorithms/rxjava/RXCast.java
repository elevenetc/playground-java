package su.levenetc.algorithms.rxjava;

import rx.Observable;
import rx.Subscriber;
import su.levenetc.algorithms.utils.Objects;
import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 13/11/15.
 */
public class RXCast {

	public static void run() {
		Observable<Void> casted = getA().map(a -> null);
		casted.subscribe(RXCast::handleEnd, RXCast::handleError);
	}

	private static void handleError(Throwable throwable) {
		Out.pln("Error:" + throwable.toString());
	}

	private static void handleEnd(Void aVoid) {
		Out.pln("End.");
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