package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.schedulers.Schedulers;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

/**
 * Created by eugene.levenetc on 28/07/16.
 */
public class ImmediateSchedulerBehavior {
	public static void run() {
		runImmediate();
		runDefault();
	}

	private static void runImmediate() {
		Observable.create(subscriber -> {
			Out.plnCurrentThread("immediate");
			ThreadsUtils.sleep(10000);
			subscriber.onNext(new Object());
		}).subscribeOn(Schedulers.immediate()).subscribe(ImmediateSchedulerBehavior::result);
	}

	private static void runDefault() {
		Observable.create(subscriber -> {
			Out.plnCurrentThread("default");
			ThreadsUtils.sleep(10000);
			subscriber.onNext(new Object());
		}).subscribe(ImmediateSchedulerBehavior::result);
	}

	private static void result(Object result) {

	}
}
