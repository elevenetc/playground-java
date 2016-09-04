package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eleven on 07/02/2016.
 * http://www.careercup.com/question?id=5158359730749440
 */
public class FindIntersection {
	public static void run() {
		int[] a = new int[]{10, 03, 11, 12};
		int[] b = new int[]{10, 40, 11, 10, 10, 12};
		Out.pln(find(a, b));
	}

	private static List<Integer> find(int[] a, int[] b) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (i < b.length) {
				if (a[i] == b[i]) {
					result.add(a[i]);
				}
			}
		}
		return result;
	}
}
