package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by eugene.levenetc on 01/07/16.
 */
public class RX {

	private static Scheduler main;
	private static Scheduler back;

	public static <T> Observable<T> getObs(T result, String tag, long duration, boolean throwExc, Action0 checkBeforeComplete) {
		return Observable.create(new Observable.OnSubscribe<T>() {
			@Override
			public void call(Subscriber<? super T> subscriber) {
				if (throwExc) {
					subscriber.onError(new RuntimeException(tag));
				} else {
					Out.plnCurrentThread(tag);
					ThreadsUtils.sleep(duration);
					checkBeforeComplete.call();
					subscriber.onNext(result);
					subscriber.onCompleted();
				}

			}
		});
	}

	public static Scheduler getMain() {
		if (main == null) main = getSingleThreadScheduler("Main");
		return main;
	}

	public static Scheduler getBackground() {
		if (back == null) back = getSingleThreadScheduler("Back");
		return back;
	}

	public static Scheduler getMultiThreadScheduler(String name) {
		ExecutorService executor = Executors.newFixedThreadPool(10, runnable -> {
			Thread result = getThread(runnable, name);
			return result;
		});
		return Schedulers.from(executor);
	}

	public static Scheduler getSingleThreadScheduler(String name) {
		ExecutorService executor = Executors.newSingleThreadExecutor(runnable -> {
			Thread result = getThread(runnable, name);
			return result;
		});
		return Schedulers.from(executor);
	}

	private static Thread getThread(Runnable runnable, String name) {
		Thread result = new Thread(runnable);
		if (name.length() > 4) name = name.substring(0, 4);
		result.setName("T: " + name);
		return result;
	}

	public static <T> void onCompleteWithThread(T result) {
		Out.pln(Out.currentThread() + " : onComplete: " + result);
	}

	public static <T> void onComplete(T result) {
		Out.pln("onComplete: " + result);
	}

	public static void onError(Throwable t) {
		Out.pln("onError: " + t);
	}

	public static void onErrorWithThread(Throwable t) {
		Out.pln(Out.currentThread() + " : onError: " + t);
	}
}
