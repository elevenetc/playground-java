package su.levenetc.playground.java.rxjava;

import rx.Completable;
import rx.Subscriber;
import su.levenetc.playground.java.utils.Out;

import java.util.concurrent.Callable;

/**
 * Created by levenetc on 16/02/16.
 */
public class CompletableSample {

	public static void run() {
		Completable.fromAction(() -> {
			Out.plnCurrentThread();
			throw new RuntimeException("!");
		}).subscribe(CompletableSample::zzz, () -> Out.pln("onComplete"));
	}

	private static void zzz(Throwable t) {
		Out.pln("error:" + t);
	}
}