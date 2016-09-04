package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 06/02/2016.
 */
public class SmartSubstring {
	public static void run() {
		String sample = "abc abc abc";
		Out.pln(smartSub(sample, 8));
	}

	private static String smartSub(String s, int size) {
		String substring = s.substring(0, size);
		if (s.charAt(size) - 1 == ' ') return substring;

		String[] split = substring.split("[ ]");
		if (split.length > 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < split.length - 1; i++) {
				sb.append(split[i]);
				sb.append(' ');
			}
			return sb.toString();
		} else {
			return split[0];
		}
	}
}
