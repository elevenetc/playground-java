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
					result.from = s;
					return result;
				})
				.subscribe(RXJava::println);
	}

	public static void retrofitJustError() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		Observable<RetrofitConfig.BackendModel> observable400 = api.get400();
		observable400.subscribe(backendModel -> println(backendModel), RXJava::println);
	}

	public static void retrofitErrorToResult() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		api.get400()
				.retry(4)
				.onErrorResumeNext(throwable -> {
					println("log backend error:" + throwable);
					return Observable.just(new RetrofitConfig.BackendModel(RetrofitConfig.RESULT_ERROR));
				})
				.flatMap((RetrofitConfig.BackendModel backendModel) -> {
					if (backendModel == null || RetrofitConfig.RESULT_ERROR.equals(backendModel.result)) {
						println("flatMap backendModel == null || result == error");
						println("query db and return empty");
						return Observable.from(new SomeObject[]{new SomeObject("empty")});
					} else {
						return Observable.from(new SomeObject[]{new SomeObject(backendModel.result)});
					}
				}).subscribe(result -> println("result ok:" + result), throwable -> println("error: " + throwable), () -> println("complete"));
	}

	public static void retrofitResponseMap() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		Observable<RetrofitConfig.BackendModel> observable200 = api.get200();
		observable200.subscribe(backendModel -> println(backendModel), RXJava::println);
	}

	private static class SomeObject {
		private String from;

		public SomeObject(String from) {
			this.from = from;
		}

		public SomeObject() {

		}

		@Override public String toString() {
			return "SomeObject{" +
					"from='" + from + '\'' +
					'}';
		}
	}
}