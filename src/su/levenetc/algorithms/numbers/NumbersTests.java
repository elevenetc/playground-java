package su.levenetc.algorithms.numbers;

import su.levenetc.algorithms.utils.Out;

/**
 * Created by elevenetc on 05/07/15.
 */
public class NumbersTests {
	public static void run() {

		int i = 10;
		float f = 10f;
		long l = 10;
		double d = 11;


		set(10);
		set(10f);
		set(i);
		set(f);
		set(l);
		set(d);
	}

	private static void set(Number n) {
		Out.pln(n.toString());
	}
}
