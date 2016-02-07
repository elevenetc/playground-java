package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 06/02/2016.
 */
public class BalancingBrackets {
	public static void run() {
		String sample = "()(d)(f)f";
		Out.p("Is balance:" + sample + ": " + isBalanced(sample, 0, 0, 0) + " ");
	}

	private static boolean isBalanced(String s, int index, int l, int r) {
		if (index == s.length()) return l == r;
		char c = s.charAt(index);
		if (c == '(') l++;
		if (c == ')') r++;
		return isBalanced(s, ++index, l, r);
	}
}
