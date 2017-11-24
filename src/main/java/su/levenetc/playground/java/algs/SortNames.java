package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import java.util.*;

/**
 * Created by eleven on 07/02/2016.
 */
public class SortNames {
	public static void run() {
		String[] names = new String[]{
				"Luis",
				"Hector",
				"Selena",
				"Emmanuel",
				"Amish"
		};

		Out.result(Arrays.asList(names), sort(Arrays.asList(names)));
	}

	private static List<String> sort(List<String> unsorted) {

		LinkedList<String> sorted = new LinkedList<>();

		HashMap<Integer, String> firsts = new HashMap<>();
		HashMap<Integer, String> lasts = new HashMap<>();

		for (String name : unsorted) {
			int keyFirst = Character.toLowerCase(name.charAt(0));
			int keyLast = Character.toLowerCase(name.charAt(name.length() - 1));

			firsts.put(keyFirst, name);
			lasts.put(keyLast, name);
		}

		Set<Map.Entry<Integer, String>> entries = firsts.entrySet();
		for (Map.Entry<Integer, String> entry : entries) {
			int key = entry.getKey();
			String name = entry.getValue();

			if (lasts.get(key) == null) {
				sorted.add(name);
			}
		}

		while (sorted.size() < unsorted.size()) {
			String lastName = sorted.getLast();
			int lastKey = lastName.charAt(lastName.length() - 1);

			sorted.add(firsts.get(lastKey));
		}

		return sorted;
	}

//	private static String[] sort(String[] array) {
//		Arrays.sort(array, new Comparator<String>() {
//
//			StringBuilder sb = new StringBuilder();
//
//			@Override public int compare(String a, String b) {
//
//				a = a.toLowerCase();
//				b = b.toLowerCase();
//
//				char cA0 = a.charAt(0);
//				char cA1 = a.charAt(a.size() - 1);
//
//				char cB0 = b.charAt(0);
//				char cB1 = b.charAt(b.size() - 1);
//
//				String a0 = String.valueOf(cA0);
//				String a1 = String.valueOf(cA1);
//
//
//				String b0 = String.valueOf(cB0);
//				String b1 = String.valueOf(cB1);
//
//				if (cA1 == cB0) {
//					return -1;
//				} else if (cA0 == cB1) {
//					return 1;
//				} else {
//					return 0;
//				}
//
////				sb.setLength(0);
//////				String aa = sb.append(a1).toString();
////				String aa = sb.append(a1).append(b0).toString();
////				sb.setLength(0);
//////				String bb = sb.append(b0).toString();
////				String bb = sb.append(b1).append(a0).toString();
////
////				return aa.compareTo(bb) + bb.compareTo(aa);
//			}
//		});
//
//		return array;
//	}
}
