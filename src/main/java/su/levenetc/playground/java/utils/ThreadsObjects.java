package su.levenetc.playground.java.utils;

/**
 * Created by eleven on 04/12/2015.
 */
public class ThreadsObjects {

	public static class A extends Base {

		public A() {
			super("A", 500);
		}
	}

	public static class B extends Base {

		public B() {
			super("B", 2000);
		}
	}

	public static class Base extends Thread {

		private final String id;
		private final long workTime;

		public Base(String id, long workTime) {
			this.id = id;
			this.workTime = workTime;
		}


		@Override public void run() {
			begin();
			work();
			end();
		}

		protected void work() {
			ThreadsUtils.sleep(workTime);
		}

		protected void end() {
			Out.pln(id + "-thread end at " + Time.getTime());
		}

		protected void begin() {
			Out.pln(id + "-thread start at " + Time.getTime());
		}


	}
}
