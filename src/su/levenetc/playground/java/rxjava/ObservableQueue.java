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

		Observable<Objects.A> obsA = RX.getObs(new Objects.A("A"), "task A running", 200, false, null);
		Observable<Objects.A> obsB = RX.getObs(new Objects.A("B"), "task B running", 100, false, null);
		Observable<Objects.A> obsC = RX.getObs(new Objects.A("C"), "task C running", 350, false, null);
		Observable<Objects.A> obsD = RX.getObs(new Objects.A("D"), "task D running", 150, false, null);

		queue.add(obsA)
				.observeOn(RX.getMain())
				.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);

		queue.add(obsB)
				.observeOn(RX.getMain())
				.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);

		obsC = queue.add(obsC)
				.observeOn(RX.getMain());

		ThreadsUtils.sleep(5500);

		queue.add(obsD)
				.observeOn(RX.getMain())
				.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);

		obsC.subscribe(RX::onCompleteWithThread, RX::onErrorWithThread);
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
			if (!isResAvailable()) loadRes();
		}

		private void handleTermination() {
			int i = atomicInt.decrementAndGet();
			if (i == 0 && isResAvailable()) destroyRes();
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