package su.levenetc.playground.java.utils;

/**
 * Created by levenetc on 21/01/16.
 */
public class ThreadX extends Thread {

	private Runnable runnable;

	public ThreadX(String name) {
		super(name);
	}

	public void setRunnable(Runnable runnable) {
		this.runnable = runnable;
	}

	@Override
	public void run() {
		Out.pln("thread " + getName() + " stared");
		runnable.run();
		Out.pln("thread " + getName() + " finished");
	}
}
