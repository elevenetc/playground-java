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

	public static void isNumberFloatOrInteger() {
		int i = 10;
		float f = 10.1f;
		Number ni = i;
		Number nf = f;

		Out.pln(nf.floatValue() == (int) ni);

//		Out.pln(ni.floatValue() == ni.intValue());
	}

	private static void set(Number n) {
		Out.pln(n.toString());
	}
}
