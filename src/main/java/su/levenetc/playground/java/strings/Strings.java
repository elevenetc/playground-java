package su.levenetc.playground.java.strings;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by levenetc on 06/07/15.
 */
public class Strings {

	public static void trims() {
		String aaa = "a b  ";
		String trimmed = aaa.trim();

		int length = aaa.length();
		int start = 0;
		int end = aaa.length();
		if (trimmed.length() != aaa.length()) {
			start = aaa.lastIndexOf(trimmed);
			end = start + trimmed.length();
		}

		Out.pln("start:" + start);
		Out.pln("end:" + end);
		Out.pln("num of spaces at start:" + start);
		Out.pln("num of spaces at end:" + (length - end));
	}

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
