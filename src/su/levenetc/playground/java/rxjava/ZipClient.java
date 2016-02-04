package su.levenetc.playground.java.rxjava;

import su.levenetc.playground.java.RXJava;

/**
 * Created by elevenetc on 21/06/15.
 */
public class ZipClient {
	public void start() {
		ZipTask zipTask = new ZipTask();
		zipTask.execute().subscribe(this::success, this::fail);
	}

	private void fail(Throwable error) {
		RXJava.println(error);
	}

	private void success(ZipObject result) {
		RXJava.println(result);
	}
}
