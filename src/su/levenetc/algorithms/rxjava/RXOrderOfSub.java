package su.levenetc.algorithms.rxjava;

import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import su.levenetc.algorithms.utils.Out;
import su.levenetc.algorithms.utils.ThreadsUtils;

/**
 * Created by eleven on 16/11/2015.
 */
public class RXOrderOfSub {
	public static void run() {

		Out.pln();
		ThreadsUtils.sleep(200);

		Out.pln("Start:" + Thread.currentThread());

		Observable.just("FZ")
//				.observeOn(Schedulers.computation())
				.map(new Func1<String, String>() {
					@Override public String call(String s) {
						Out.pln("First map:" + Thread.currentThread());
						return s + "X";
					}
				})
//				.observeOn(Schedulers.computation())
				.map(s -> {
					Out.pln("Second map:" + Thread.currentThread());
					return s.length();
				})
				.observeOn(Schedulers.computation())
				.subscribe();

		Out.pln();
		ThreadsUtils.sleep(200);
	}
}
