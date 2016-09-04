package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.TestUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by eleven on 25/01/2016.
 */
public class MergeSort01 {
	public static void run() {

		List<Integer> unsorted = new ArrayList<Integer>() {{
			add(0);
			add(2);
			add(1);
			add(1);
		}};

		TestUtils.testSort(sort(unsorted));
	}

	private static <T extends Comparable<? super T>> List<T> sort(List<T> unsorted) {
		if (unsorted.size() <= 1) return unsorted;

		int mid = unsorted.size() / 2;
		List<T> left = unsorted.subList(0, mid);
		List<T> right = unsorted.subList(mid, unsorted.size());

		return merge(sort(left), sort(right));
	}

	private static <T extends Comparable<? super T>> List<T> merge(List<T> left, List<T> right) {

		List<T> result = new ArrayList<>();
		Iterator<T> lIterator = left.iterator();
		Iterator<T> rIterator = right.iterator();

		while (lIterator.hasNext() || rIterator.hasNext()) {

			if (lIterator.hasNext() && rIterator.hasNext()) {
				T l = lIterator.next();
				T r = rIterator.next();

				if (l.compareTo(r) <= 0) {
					result.add(l);
					result.add(r);
				} else {
					result.add(r);
					result.add(l);
				}
			} else if (lIterator.hasNext()) {
				while (lIterator.hasNext()) result.add(lIterator.next());
				break;
			} else {
				while (rIterator.hasNext()) result.add(rIterator.next());
				break;
			}
		}

		return result;
	}
}
