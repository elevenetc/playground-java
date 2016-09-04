package su.levenetc.playground.java.problems;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eleven on 23/07/2016.
 */
public class SplitString {
	public static void run() {
		test("hellobob", "hello bob", new String[]{"hello", "bob"});
	}

	private static void test(String input, String check, String[] words) {
		String result = v0(input, words);
		Out.result(input, result + " | " + check);
	}

	private static String v0(String input, String[] words) {
		StringBuilder result = new StringBuilder();

		while (input.length() > 0) {
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				int index = input.indexOf(word);
				if (index >= 0) {
					String subWord = input.substring(index, word.length());
					input = input.replaceFirst(word, "");
					result.append(subWord);
					result.append(" ");
				}
			}
		}
		return result.toString();
	}
}
