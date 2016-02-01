package su.levenetc.playground.java.threads;

import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;


/**
 * Created by elevenetc on 04/07/15.
 */
public class Threads {
	public static void checkSyncMethod() {
		ObjSample objSample = new ObjSample();

		/**
		 * When one thread is executing a synchronized method for an object, all other threads that invoke
		 * synchronized methods for the same object block (suspend execution)
		 * until the first thread is done with the object.
		 */
		new Thread(objSample::sycnedMeth).start();
		new Thread(objSample::sycnedMeth).start();

//		new Thread(objSample::sycnedMeth).start();
//		new Thread(objSample::just).start();
	}

	public static void syncValue() {
		ObjSample objSample = new ObjSample();


	}

	private static class ObjSample {

		private Object lock = new Object();
		private float value;

		public void syncValue() {

		}

		public void just() {
			Out.meth("just - start");
			value += 1f;
			Out.pln(value);
			Out.meth("just - finish");
		}

		public synchronized void sycnedMeth() {
			Out.meth("sycnedMeth - start");
			value += 1f;
			Out.pln(value);
			ThreadsUtils.sleepB();
			Out.meth("sycnedMeth - finish");
		}

		public void sycnedBlock() {
			synchronized (lock) {
				Out.meth("sycnedBlock - start");
				ThreadsUtils.sleepB();
				value += 1f;
				Out.pln(value);
				Out.meth("sycnedBlock - finish");
			}
		}
	}
}
