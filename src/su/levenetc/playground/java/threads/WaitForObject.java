package su.levenetc.playground.java.threads;


import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadX;
import su.levenetc.playground.java.utils.ThreadsUtils;


/**
 * Created by levenetc on 21/01/16.
 */
public class WaitForObject {

	static volatile int data = 0;

	public static void run() {
//
		Object lock = new Object();

		ThreadX threadA = new ThreadX("A");
		ThreadX threadB = new ThreadX("B");

		threadA.setRunnable(new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						Out.pln(data);
					}
					Out.pln(data);
				}
			}
		});

		threadB.setRunnable(new Runnable() {
			@Override
			public void run() {
				ThreadsUtils.sleep(1000);
				data = 1;
				synchronized (lock){
					lock.notify();
				}
			}
		});

		threadA.start();
		threadB.start();


	}

}
