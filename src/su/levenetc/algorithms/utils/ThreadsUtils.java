package su.levenetc.algorithms.utils;

/**
 * Created by elevenetc on 04/07/15.
 */
public class ThreadsUtils {

	public static void sleepA() {
		sleep(1000);
	}

	public static void sleepB() {
		sleep(2000);
	}

	public static void sleepC() {
		sleep(3000);
	}


	public static void sleep(long ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
