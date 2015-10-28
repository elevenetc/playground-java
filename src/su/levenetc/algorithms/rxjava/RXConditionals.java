package su.levenetc.algorithms.rxjava;

import rx.Observable;
import rx.Subscriber;
import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 28/10/15.
 */
public class RXConditionals {

	public static void run() {
		Observable<ResultFinal> observable = getNullable().flatMap(resultA -> {
			if (resultA == null) {
				return Observable.error(new RuntimeException("no A"));
			} else {
				return getDependsOnNullable(resultA).map(resultB -> new ResultFinal(resultA.price, resultB));
			}
		});

		observable.subscribe(Out::pln, Out::pln);
	}

	private static Observable<ResultA> getNullable() {
		return Observable.create(new Observable.OnSubscribe<ResultA>() {
			@Override
			public void call(Subscriber<? super ResultA> subscriber) {
//				subscriber.onNext(null);
				subscriber.onNext(new ResultA(10));
				subscriber.onCompleted();
			}
		});
	}

	private static Observable<ResultB> getDependsOnNullable(ResultA resultA) {
		return Observable.create(new Observable.OnSubscribe<ResultB>() {
			@Override
			public void call(Subscriber<? super ResultB> subscriber) {
				subscriber.onNext(new ResultB(resultA));
				subscriber.onCompleted();
			}
		});
	}


	private static class ResultA {

		public final int price;

		public ResultA(int price) {
			this.price = price;
		}
	}

	private static class ResultB {
		public ResultB(ResultA a) {

		}
	}

	private static class ResultFinal {
		private int price;
		private ResultB resultB;

		public ResultFinal(int price, ResultB resultB) {
			this.price = price;
			this.resultB = resultB;
		}

		@Override
		public String toString() {
			return "ResultFinal{" +
					"price=" + price +
					", resultB=" + resultB +
					'}';
		}
	}
}
