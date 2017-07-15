package su.levenetc.playground.java.core;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by levenetc on 12/01/16.
 */
public class FormatString {
	public static void run() {
		Out.pln(String.format("hello: %2$s, %1$d", 1, "F"));
	}
}
