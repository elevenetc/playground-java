package su.levenetc.algorithms.datastructures;

import su.levenetc.algorithms.utils.Out;

/**
 * Created by elevenetc on 06/07/15.
 */
public class Structures {
	public static void run() {
		//alist();
		//lList();
		hmap();
	}

	private static void hmap() {
		//HMap<String> hMap = new HMap<>();
	}

	private static void alist() {
		AList<String> alist = new AList<>(3);
		Out.pln(alist);

		String sixElem = "6";
		String elemFive = "5";

		alist.add("0");
		alist.add("1");
		alist.add("2");
		alist.add("3");
		alist.add("4");

		alist.add(elemFive);

		alist.add(sixElem);
		alist.remove(elemFive);
		alist.remove(sixElem);

		Out.pln("FINAL " + alist);
	}

	private static void lList() {
		LList<String> llist = new LList<>();
		llist.add("0");
		llist.add("1");
		llist.add("2");

		Out.pln(llist);

		Out.pln("contains:" + "1: " + llist.contains("1"));
		Out.pln("contains:" + "10: " + llist.contains("10"));


		llist.remove("1");
		Out.pln(llist);
		llist.remove("0");
		Out.pln(llist);
		llist.remove("2");
		Out.pln(llist);
		llist.remove("20");
		Out.pln(llist);
	}
}
