package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 27/06/2016.
 */
public class PostponedQueue {
	public static void run() {

		Session session = new Session();
		Queue<Session> queue = new Queue<>();

		queue.setResource(session);
		queue.addOperation(new Queue.Operation<Session>() {
			@Override public void run(Session resource) {
				Out.pln("Op:A");
				resource.value += "a";
				//throw new RuntimeException("Error A");
			}
		});
		queue.addOperation(new Queue.Operation<Session>() {
			@Override public void run(Session resource) {
				Out.pln("Op:B");
				resource.value += "b";
			}
		});

		queue.addOperation(new Queue.Operation<Session>() {
			@Override public void run(Session resource) {
				Out.pln("Op:C");
				resource.value += "c";
			}
		});

		queue.getObservable().subscribe(new Action1<Object>() {
			@Override public void call(Object o) {
				Out.pln("Finish: " + session.value);
			}

		}, new Action1<Throwable>() {
			@Override public void call(Throwable throwable) {
				Out.pln("OnError: " + session.value);
			}
		});
	}

	private static class Session {
		private String value = "empty";
	}

	private static class Queue<R> {

		private R resource;
		private Observable<Object> observable = null;

		void setResource(R resource) {
			this.resource = resource;
		}

		Observable<Object> getObservable() {
			return observable.doOnCompleted(this::handleComplete);
		}

		void addOperation(Operation<R> operation) {

			Observable<Object> obs = Observable.create(subscriber -> {

				try {
					operation.run(resource);
					subscriber.onNext(null);
				} catch (Throwable t) {
					subscriber.onError(t);
				}

				subscriber.onCompleted();
			}).doOnError(this::handleError);


			if (observable == null) {
				observable = obs;
			} else {
				observable = observable.flatMap(new Sss(obs));
			}
		}

		private void handleComplete() {
			Out.pln("Internal complete");
			clean();
		}

		private void handleError(Throwable t) {
			Out.pln("Internal error handler");
			clean();
		}

		private void clean() {
			Out.pln("Clean");
		}

		private class Sss implements Func1<Object, Observable<Object>> {

			private Observable<Object> obs;

			public Sss(Observable<Object> obs) {
				this.obs = obs;
			}

			@Override public Observable<Object> call(Object o) {
				return obs;
			}
		}

		private interface Operation<R> {
			void run(R resource);
		}
	}


}
