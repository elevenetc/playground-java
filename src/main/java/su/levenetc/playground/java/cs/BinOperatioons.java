package su.levenetc.playground.java.cs;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 29/02/2016.
 */
public class BinOperatioons {
	public static void run() {
		int a = 1;
		Out.bin(a);
		a = a >> 1;
		Out.bin(a);

		Observable.create(new Observable.OnSubscribe<A>() {
			@Override public void call(Subscriber<? super A> subscriber) {

			}
		}).map(new Func1<A, B>() {
			@Override public B call(A a) {
				return new B(a);
			}
		});
	}

	private static class A{

	}

	private static class B{

		public B(A a) {

		}
	}
}
