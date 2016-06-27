package su.levenetc.playground.java.rxjava;

/**
 * Created by eleven on 27/06/2016.
 */
public class PostponedQueue {
	public static void run() {

		Session session = new Session();
		Queue<Session> queue = new Queue<>();

		queue.setResource(session);
		queue.addOperation(resource -> resource.value += "a");
		queue.addOperation(resource -> resource.value += "b");

		queue.run();
	}

	private static class Session {
		private String value;
	}

	private static class Queue<R> {

		private R resource;

		void setResource(R resource) {
			this.resource = resource;
		}

		void run() {

		}

		void addOperation(Operation<R> operation) {

		}

		private interface Operation<R> {
			void run(R resource);
		}
	}


}
