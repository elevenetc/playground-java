package su.levenetc.algorithms.threads;

import su.levenetc.algorithms.utils.ThreadsObjects;

/**
 * Created by eleven on 04/12/2015.
 * The thread which calls join will wait until thread will finish its work
 */
public class JoinSample {

	private static final boolean USE_JOIN = true;

	public static void run() throws InterruptedException {
		new MasterThread().start();
	}

	private static class MasterThread extends ThreadsObjects.Base {


		public MasterThread() {
			super("master", 500);

		}

		@Override protected void work() {

			SlaveThread slaveThread = new SlaveThread(1000);
			slaveThread.start();

			if (USE_JOIN) joinSlave(slaveThread);

			super.work();
		}

		private void joinSlave(SlaveThread slaveThread) {
			try {
				slaveThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private static class SlaveThread extends ThreadsObjects.Base {

		public SlaveThread(long workTime) {
			super("slave", workTime);
		}

	}
}
