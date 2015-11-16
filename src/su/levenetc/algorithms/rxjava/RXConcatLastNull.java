package su.levenetc.algorithms.rxjava;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import su.levenetc.algorithms.utils.Objects;
import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 16/11/15.
 */
public class RXConcatLastNull {
	public static void run() {
		Observable.concat(getANull(), getANotNull()).first().subscribe(new Action1<Objects.A>() {
			@Override
			public void call(Objects.A result) {
				Out.pln("Result:" + result);
			}
		});
	}

	private static Observable<Objects.A> getANull() {
		return Observable.create(new Observable.OnSubscribe<Objects.A>() {
			@Override
			public void call(Subscriber<? super Objects.A> subscriber) {
				Objects.A result = null;
				if(result != null) subscriber.onNext(result);
				subscriber.onCompleted();
			}
		});
	}

	private static Observable<Objects.A> getANotNull() {
		return Observable.create(new Observable.OnSubscribe<Objects.A>() {
			@Override
			public void call(Subscriber<? super Objects.A> subscriber) {
				subscriber.onNext(new Objects.A("NotNull"));
				subscriber.onCompleted();
			}
		});
	}

}
