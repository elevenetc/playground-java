package su.levenetc.algorithms.core;

import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 12/01/16.
 */
public class FormatString {
	public static void run() {
		Out.pln(String.format("Hello: %2$s, %1$d", 1, "F"));
	}
}
