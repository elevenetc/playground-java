package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 14/05/2016.
 */
public class RxBus {
	public static void run() {
		Subscription sub = Bus.getInstance().getObservable().subscribe(Out::pln);

		Bus.getInstance().publish("Hello A");
		Bus.getInstance().publish("Hello B");
		sub.unsubscribe();
		Bus.getInstance().publish("Hello C");
		Bus.getInstance().getObservable().subscribe(Out::pln);
		Bus.getInstance().publish("Hello D");
	}

	private static class Bus {

		private static Bus inst;
		PublishSubject<Object> publishSubject = PublishSubject.create();

		public Bus() {

		}

		public static Bus getInstance() {
			if (inst == null) inst = new Bus();
			return inst;
		}

		public void publish(Object object) {
			publishSubject.onNext(object);
		}

		public Observable<Object> getObservable() {
			return publishSubject;
		}
	}
}
