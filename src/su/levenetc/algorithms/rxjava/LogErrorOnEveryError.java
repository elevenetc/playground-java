package su.levenetc.algorithms.rxjava;

import su.levenetc.algorithms.RetrofitConfig;
import su.levenetc.algorithms.utils.Out;


/**
 * Created by elevenetc on 16/07/15.
 */
public class LogErrorOnEveryError {
	public static void run() {
		RetrofitConfig.API api = RetrofitConfig.initAPI();

		Passed passed = new Passed();

		api.get200("zzz")
				.doOnError(throwable -> Out.pln("error 00"))
				.flatMap(response -> api.get200().doOnError(throwable -> Out.pln("error 01")))
				.flatMap(response -> api.get400().doOnError(throwable -> Out.pln("error 02")))
				.subscribe(LogErrorOnEveryError::handleOk, LogErrorOnEveryError::handleError);
	}

	private static void onFinish() {
		Out.pln("finish");
	}

	private static void handleError(Throwable throwable) {

		if (throwable instanceof ChainInterruptedException) {
			Out.pln("error:" + ((ChainInterruptedException) throwable).step);
		} else {
			Out.pln("error:" + throwable);
		}


	}

	private static void handleOk(Object o) {
		Out.pln(o);
	}

	private static class ChainInterruptedException extends Throwable {
		private int step;

		public ChainInterruptedException(int step) {
			this.step = step;
		}
	}

	private static class Passed {
		boolean stage0;
		boolean stage1;
	}
}
