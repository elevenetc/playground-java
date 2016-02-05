package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eleven on 01/02/2016.
 */
public class Strings {

	public static void isPalindrom() {
		String check = "aa";
//		String check = "rotoa";
//		String check = "rotor";
		Out.pln(check + " is " + (checkPalindrom(check, 0) ? " paldindrome" : "not palindrome"));
	}

	private static boolean checkPalindrom(String check, int index) {

		int left = index;
		int right = check.length() - index - 1;

		if (check.length() <= 1 || left >= right) {
			return true;
		} else {
			if (check.charAt(left) == check.charAt(right)) {
				return checkPalindrom(check, ++index);
			} else {
				return false;
			}
		}
	}

	public static void findCommonSubstring() {
		String b = "AB0C";
		String a = "AAAB0CD";

		int[][] matrix = new int[a.length()][];
		int maxVal = 0;
		int maxIter = 0;

		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new int[b.length()];

			for (int j = 0; j < matrix[i].length; j++) {
				if (a.charAt(i) == b.charAt(j)) {

					if (i != 0 && j != 0) {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					} else {
						matrix[i][j] = 1;
					}

					if (matrix[i][j] > maxVal) {
						maxVal = matrix[i][j];
						maxIter = i;
					}

				}
			}
		}

		Out.pln("maxVal:" + maxVal + " maxIter:" + maxIter);
		Out.pln("Result:" + a.substring(maxIter - maxVal + 1, maxIter + 1));
	}
}