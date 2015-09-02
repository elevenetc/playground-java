package su.levenetc.algorithms;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import su.levenetc.algorithms.rxjava.*;
import su.levenetc.algorithms.utils.ThreadsUtils;

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

	public static void println(Object s) {
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
		String[] array = new String[]{"0", "1", "2", "3", "7"};
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

	public static void map() {
		String[] array = new String[]{"0", "1", "2", "3", "4"};
		Observable.from(array)
				.map(s -> {
					SomeObject result = new SomeObject();
					result.data = s;
					return result;
				})
				.subscribe(RXJava::println);
	}

	public static void retrofitJustError() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		Observable<BaseResponse> observable400 = api.get400();
		observable400.subscribe(backendModel -> println(backendModel), RXJava::println);
	}

	public static void retrofitFailAndSuccess() {
		ClientForFailAndSuccess client = new ClientForFailAndSuccess();
		client.start();
	}

	public static void zip() {
		ZipClient zipClient = new ZipClient();
		zipClient.start();
	}

	public static void retrofitResponseMap() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		Observable<BaseResponse> observable200 = api.get200();
		observable200.subscribe(backendModel -> println(backendModel), RXJava::println);
	}

	public static void checkNetworkConnection() {
		CheckConntectionClient client = new CheckConntectionClient();
		client.start();
	}

	public static void noOnNext() {
		Observable.create(new Observable.OnSubscribe<Object>() {
			@Override
			public void call(Subscriber<? super Object> subscriber) {
				ThreadsUtils.sleep(200);
				subscriber.onCompleted();
			}
		}).subscribe(new Action1<Object>() {
			@Override
			public void call(Object o) {

			}
		}, new Action1<Throwable>() {
			@Override
			public void call(Throwable throwable) {

			}
		});
	}
}