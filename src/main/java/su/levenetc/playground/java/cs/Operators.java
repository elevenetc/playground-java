package su.levenetc.playground.java.cs;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by elevenetc on 17/09/15.
 */
public class Operators {
	public static void run() {
		int a = 8;
		int b = 2;
		int c = 4;
		int or = c | a;
		int and = a & b & c;
		Out.pln("a: " + Integer.toBinaryString(a));
		Out.pln("b: " + Integer.toBinaryString(b));
		Out.pln("c: " + Integer.toBinaryString(c));
		Out.pln("a|b|c: " + Integer.toBinaryString(or));
		Out.pln("a&b&c: " + Integer.toBinaryString(and));

		Out.pln("containes a: " + ((or & a) == a));
		Out.pln("containes b: " + ((or & b) == b));
		Out.pln("containes c: " + ((or & c) == c));
	}
}
