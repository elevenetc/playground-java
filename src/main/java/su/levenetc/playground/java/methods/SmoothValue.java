package su.levenetc.playground.java.methods;

import java.util.Random;

import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadUtils;

/**
 * Created by levenetc on 02/09/15.
 */
public class SmoothValue {
	
	public static void run() {
		new Smoother();
	}

	private static class Smoother {

		private float val;
		private Random rnd = new Random();

		public Smoother() {
			new Thread(() -> {

				boolean threw = false;

				while (true) {
					ThreadUtils.sleep(200);
					val += 0.1;
					if (!threw && val > 0.5f && rnd.nextBoolean()) {
						threw = true;
						val += 0.5;
						Out.pln("!");
					}
					handle(val);
				}

			}).run();
		}

		float workingAverage;

		private void handle(float newValue) {
			float smoothingFactor = 0.5f;
			workingAverage = (newValue * smoothingFactor) + (workingAverage * (1.0f - smoothingFactor));
			Out.pln(newValue + ">" + workingAverage);
		}
	}

}
