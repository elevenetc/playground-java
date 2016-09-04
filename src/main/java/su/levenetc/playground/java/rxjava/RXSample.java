package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import su.levenetc.playground.java.utils.Out;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by eleven on 06/02/2016.
 */
public class RXSample {
	public static void run() {

		createThread();
//		rxxx();
//		sleep();

Scheduler scheduler = Schedulers.from(Executors.newCachedThreadPool(new ThreadFactory() {
	@Override public Thread newThread(Runnable r) {
		Thread result = new Thread(r);
		//result.setDaemon(true);
		return result;
	}
}));

Observable.just(1, 2, 3)
		.subscribeOn(scheduler)
		.subscribe(v -> print(v));
	}

	private static void createThread() {
		//new DaemonThread().start();
	}

	private static void rxxx() {

	}

	private static void sleep() {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void print(Integer v) {
		printThread(Thread.currentThread());
		System.out.println(v);
	}

	private static void printThread(Thread t) {
		Out.pln(t + " isDeamon:" + t.isDaemon() + " isAlive:" + t.isAlive());
	}

	private static class DaemonThread extends Thread {

		public DaemonThread(Runnable target) {
			super(target);
			setDaemon(true);
		}
	}
}
