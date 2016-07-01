package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import su.levenetc.playground.java.utils.Objects;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by eugene.levenetc on 01/07/16.
 */
public class ObservableQueue {
	public static void run() {
		ObsQueue queue = new ObsQueue();
		queue.add(RXUtils.getObs(new Objects.A(), "working - a", 200))
				.observeOn(RXUtils.getMain())
				.subscribe(RXUtils::onCompleteWithThread, RXUtils::onError);

		queue.add(RXUtils.getObs(new Objects.A(), "working - b", 100))
				.observeOn(RXUtils.getMain())
				.subscribe(RXUtils::onCompleteWithThread, RXUtils::onError);
	}

	private static class ObsQueue {

		private AtomicInteger counter = new AtomicInteger();
		private Object res;
		private Scheduler internalScheduler = RXUtils.getSingleThreadScheduler("Internal");

		public <T> Observable<T> add(Observable<T> obs) {
			return obs
					.doOnSubscribe(this::increment)
					.doOnTerminate(this::decrement)
					.subscribeOn(internalScheduler);
		}

		private void increment() {
			Out.plnCurrentThread("increment");
			counter.incrementAndGet();
			if (!isResAvailable()) loadRes();
		}

		private void decrement() {
			Out.plnCurrentThread("decrement");
			if (counter.decrementAndGet() == 0) {
				destroyRes();
			}
		}

		private boolean isResAvailable() {
			return res != null;
		}

		private void destroyRes() {
			Out.plnCurrentThread("res destroy");
			res = null;
		}

		private Object loadRes() {
			Out.plnCurrentThread("res loading");
			ThreadsUtils.sleep(200);
			return new Object();
		}

	}
}