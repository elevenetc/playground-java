package su.levenetc.algorithms.rxjava;

import rx.Observable;
import rx.Subscriber;
import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 29/10/15.
 */
public class RXConcat {
	public static void run() {
		Observable<Object> obsC = Observable.concat(getB(), getA());
		obsC.subscribe(o -> Out.pln("ok:" + o), e -> Out.pln("error:" + e));
	}

	private static Observable<Results.A> getA() {
		return Observable.create(new Observable.OnSubscribe<Results.A>() {
			@Override
			public void call(Subscriber<? super Results.A> subscriber) {
//				Out.pln("call " + Results.A.class);
//				subscriber.onNext(new Results.A());
				subscriber.onError(new Exception("no " + Results.A.class));
				subscriber.onCompleted();
			}
		});
	}

	private static Observable<Results.B> getB() {
		return Observable.create(new Observable.OnSubscribe<Results.B>() {
			@Override
			public void call(Subscriber<? super Results.B> subscriber) {
				Out.pln("call " + Results.B.class);
				subscriber.onNext(new Results.B());
				subscriber.onCompleted();
			}
		});
	}


}
