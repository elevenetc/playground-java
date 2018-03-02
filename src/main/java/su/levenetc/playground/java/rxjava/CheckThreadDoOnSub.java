package su.levenetc.playground.java.rxjava;

import java.util.concurrent.Executors;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;
import su.levenetc.playground.java.utils.ThreadUtils;

/**
 * Created by eugene.levenetc on 30/06/16.
 */
public class CheckThreadDoOnSub {
	public static void run() {

		Scheduler singleThreadScheduler = Schedulers.from(Executors.newSingleThreadExecutor());

		Observable<Object> obs = Observable.create(subscriber -> {

			System.out.println("onNext at: " + Thread.currentThread());

			subscriber.onNext(new Object());
			subscriber.onCompleted();

		}).subscribeOn(singleThreadScheduler).observeOn(Schedulers.newThread());

		obs = obs.doOnSubscribe(() -> System.out.println("doOnSubscribe at: " + Thread.currentThread())).subscribeOn(singleThreadScheduler);

		obs.subscribe(o -> {
			System.out.println("result at: " + Thread.currentThread());
		});

		ThreadUtils.sleep(200);
	}
}
