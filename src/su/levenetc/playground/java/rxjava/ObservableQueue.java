package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
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

		Action0 checkRes = () -> Out.pln("isResAvailable: " + queue.isResAvailable());

		Observable<Objects.A> obsA = RX.getObs(new Objects.A("A"), "task A running", 200, false, checkRes);
		Observable<Objects.A> obsB = RX.getObs(new Objects.A("B"), "task B running", 100, false, checkRes);
		Observable<Objects.A> obsC = RX.getObs(new Objects.A("C"), "task C running", 350, false, checkRes);

		queue.add(obsA)
				.observeOn(RX.getMain())
				.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);

		queue.add(obsB)
				.observeOn(RX.getMain())
				.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);

		queue.add(obsC)
				.observeOn(RX.getMain())
				.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);
	}

	private static class ObsQueue {

		private Object res;
		private Scheduler internalScheduler = RX.getSingleThreadScheduler("Internal");
		private AtomicInteger atomicInt = new AtomicInteger();

		public <T> Observable<T> add(Observable<T> obs) {
			atomicInt.incrementAndGet();
			return obs
					.doOnSubscribe(this::handleSubscription)
					.doOnTerminate(this::handleTermination)
					.subscribeOn(internalScheduler);
		}

		private boolean isResAvailable() {
			return res != null;
		}

		private void handleSubscription() {
			if (!isResAvailable())
				loadRes();
		}

		private void handleTermination() {
			if (atomicInt.decrementAndGet() == 0 && isResAvailable()) {
				destroyRes();
			}
		}

		private void loadRes() {
			Out.plnCurrentThread("res loading");
			ThreadsUtils.sleep(200);
			res = new Object();
		}

		private void destroyRes() {
			Out.plnCurrentThread("res destroy");
			res = null;
		}

	}
}