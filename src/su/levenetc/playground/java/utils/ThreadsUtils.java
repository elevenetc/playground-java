package su.levenetc.playground.java.utils;

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
		sleep(ms, null);
	}

	public static void sleep(long ms, DoOnWakeup handler) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {

		}

		if (handler != null) handler.wakeupHandler();
	}


}
