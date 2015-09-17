package su.levenetc.algorithms.utils;

/**
 * Created by elevenetc on 04/07/15.
 */
public class Out {

	public static void plnBin(int val) {
		System.out.println(Integer.toBinaryString(val));
	}

	public static void pln(Object result) {
		System.out.println(result.toString());
	}

	public static void pln(float result) {
		System.out.println(result);
	}

	public static void pln(String result) {
		System.out.println(result);
	}

	public static void meth(String result) {
		System.out.println("method(" + SysUtils.time() + "): " + result);
	}

}
