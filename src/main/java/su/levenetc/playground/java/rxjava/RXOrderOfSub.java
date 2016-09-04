package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

/**
 * Created by eleven on 16/11/2015.
 */
public class RXOrderOfSub {
	public static void run() {

		Out.pln();
		ThreadsUtils.sleep(200);

		Out.pln("ST:" + Thread.currentThread());

		Observable.just("FZ")
//				.observeOn(Schedulers.computation())
				.map(new Func1<String, String>() {
					@Override public String call(String s) {
						Out.pln("M0:" + Thread.currentThread());
						return s + "X";
					}
				})
				.observeOn(Schedulers.computation())
				.map(s -> {
					Out.pln("M1:" + Thread.currentThread());
					return s.length();
				})
//				.observeOn(Schedulers.immediate())
				.subscribe(RXOrderOfSub::handleEnd);

		ThreadsUtils.sleep(2000);
		Out.pln();
	}

	private static void handleEnd(int result) {
		Out.pln("EN:" + Thread.currentThread());
	}
}
