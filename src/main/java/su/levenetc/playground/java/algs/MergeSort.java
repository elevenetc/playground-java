package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.TestUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eleven on 24/01/2016.
 */
public class MergeSort {

	public static void run() {
//		testSort(new int[]{0, 1, 1});
//		testSort(new int[]{0, 1, 2});

		List<Integer> sort = sort(new ArrayList<Integer>() {{
			add(-100);
			add(5);
			add(1);
			add(-101);
			add(55);
			add(4);
		}});
		
		TestUtils.testSort(sort);
	}

	private static <T extends Comparable<? super T>> List<T> sort(List<T> unsorter) {

		if (unsorter.size() <= 1) return unsorter;

		int mid = unsorter.size() / 2;
		List<T> left = unsorter.subList(0, mid);
		List<T> right = unsorter.subList(mid, unsorter.size());

		return merge(sort(left), sort(right));
	}

	private static <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {
		List<T> result = new ArrayList<>();

		Iterator<T> leftIterator = left.iterator();
		Iterator<T> rightIterator = right.iterator();

		while (leftIterator.hasNext() || rightIterator.hasNext()) {

			if (leftIterator.hasNext() && rightIterator.hasNext()) {
				T l = leftIterator.next();
				T r = rightIterator.next();

				if (l.compareTo(r) <= 0) {
					result.add(l);
					result.add(r);
				} else {
					result.add(r);
					result.add(l);
				}
			} else if (!leftIterator.hasNext()) {
				while (rightIterator.hasNext()) result.add(rightIterator.next());
				break;
			} else if (!rightIterator.hasNext()) {
				while (leftIterator.hasNext()) result.add(leftIterator.next());
				break;
			}

		}

		return result;
	}
}
