package su.levenetc.playground.java;

import su.levenetc.playground.java.rxjava.ImmediateSchedulerBehavior;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadsUtils.sleep(50);
		Out.pln();
		ThreadsUtils.sleep(50);

		run();

		ThreadsUtils.sleep(50);
		Out.pln();
		ThreadsUtils.sleep(50);
	}

	private static void run() {
		ImmediateSchedulerBehavior.run();
	}
}