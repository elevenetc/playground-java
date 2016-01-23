package su.levenetc.algorithms.utils;

/**
 * Created by eleven on 04/12/2015.
 */
public class Time {

	private static volatile long time;

	public static void start() {
		time = System.currentTimeMillis();
	}

	public static long getTime() {
		return System.currentTimeMillis() - time;
	}
}
