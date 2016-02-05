package su.levenetc.playground.java.utils;

import java.util.List;

/**
 * Created by eleven on 25/01/2016.
 */
public class TestUtils {
	public static <T extends Comparable<? super T>> void testSort(List<T> check) {
		Out.pln("Check:");
		Out.pln(check);
		Out.pln("Result:");

		T prevValue = check.get(0);
		for (int i = 1; i < check.size(); i++) {
			if (check.get(i).compareTo(prevValue) < 0) {
				throw new RuntimeException("Value " + check.get(i) + " at index " + i + " is lower than previous value: " + check.get(i - 1));
			}
			prevValue = check.get(i);
		}

		Out.pln("MergeSort ok with " + check);
	}
}
