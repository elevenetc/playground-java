package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by eleven on 07/02/2016.
 * http://www.careercup.com/question?id=15500701
 */
public class ClearCopies {

	public static void run() {
		List<Integer> sample = new ArrayList<Integer>() {{
			add(10);
			add(-1);
			add(-1);
			add(11);
			add(10);
			add(12);
			add(-2);
			add(10);
		}};

		ArrayList<Integer> copySample = new ArrayList<>(sample);
//		Out.result(copySample, clearCopies(sample));

		Out.result(copySample, new LinkedHashSet<>(sample));
	}

	private static List<Integer> clearCopies(List<Integer> list) {
		List<Integer> copies = new ArrayList<>();

		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			int value = iterator.next();

			if (copies.contains(value)) {
				iterator.remove();
			} else {
				copies.add(value);
			}
		}

		return list;
	}
}
