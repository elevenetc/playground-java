package su.levenetc.algorithms.rxjava;

import su.levenetc.algorithms.RXJava;
import su.levenetc.algorithms.RetrofitConfig;

/**
 * Created by elevenetc on 21/06/15.
 */
public class ClientForFailAndSuccess {
	public void start() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();
		FailTask taskA = new FailTask(api);
		SuccessTask taskB = new SuccessTask(api);
		taskA.execute().subscribe(this::handleSuccessTaskA, this::handleErrorTaskA);
		taskB.execute().subscribe(this::handleSuccessTaskB, this::handleErrorTaskB);
	}

	private void handleSuccessTaskA(SomeObject result) {
		RXJava.println("result ok task a:" + result);
	}

	private void handleErrorTaskA(Throwable error) {
		RXJava.println("error task a: " + error);
	}

	private void handleSuccessTaskB(SomeObject result) {
		RXJava.println("result ok task b:" + result);
	}

	private void handleErrorTaskB(Throwable error) {
		RXJava.println("error task b: " + error);
	}
}
