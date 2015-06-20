package su.levenetc.algorithms;

import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

/**
 * Created by elevenetc on 20/06/15.
 */
public class RXJava {

	static boolean allow = true;

	public static void filter() {
		String[] array = new String[]{"0", "1", "21", "3", "4"};
		Observable.from(array)
				.filter(s -> s.contains("1"))
				.filter(s -> s.contains("2"))
				.subscribe(System.out::println);

		System.out.println("allow check");

		Observable.from(array)
				.filter(s -> allow)
				.subscribe(s -> {
					if ("21".equals(s)) allow = false;
					System.out.println("allowed:" + s);
				});
	}

	public static void debounce() {
		String[] array = new String[]{"0", "1", "2", "3", "4"};
		Observable.from(array)
				.debounce(1000, TimeUnit.SECONDS)
				.subscribe(s -> {
					println(s);
					sleep(1500);
				});
	}

	private static void println(Object s) {
		System.out.println(s);
	}

	private static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void treads() {
		String[] array = new String[]{"0", "1", "2", "3", "6"};
		Observable.from(array)
				.subscribe(s -> {
					println(s);
					println(Thread.currentThread());
				});

		Observable.from(array)
				.subscribeOn(Schedulers.io())
				.subscribe(s -> {
					println(s);
					println(Thread.currentThread());
				});
	}
}