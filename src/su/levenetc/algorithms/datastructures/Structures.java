package su.levenetc.algorithms.datastructures;

import su.levenetc.algorithms.utils.Out;

/**
 * Created by elevenetc on 06/07/15.
 */
public class Structures {
	public static void run() {
		alist();
	}

	private static void alist() {
		AList<String> alist = new AList<>();
		Out.pln(alist);
		alist.add("0");
		alist.add("1");
		alist.add("2");
		Out.pln(alist);
		alist.pop();
		Out.pln(alist);
		alist.delete(0);
		Out.pln(alist);
	}
}
