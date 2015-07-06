package su.levenetc.algorithms.strings;

import su.levenetc.algorithms.utils.Out;

/**
 * Created by levenetc on 06/07/15.
 */
public class Strings {
	public static void cutSymbols() {
		String src = "0\n1\n2\n3\n4";
		char ch = '\n';
		Out.pln(cutSymbols(src, ch, 2));
	}

	private static String cutSymbols(String src, char ch, int maxFirst) {
		char[] chars = src.toCharArray();
		int first = 0;
		for (int i = 0; i < chars.length; i++) {
			boolean skip = first < maxFirst;
			if (chars[i] == ch) {

				if (skip) {
					first++;
				} else {
					chars[i] = '\u0000';
				}

			}
		}

		return new String(chars);
	}
}
