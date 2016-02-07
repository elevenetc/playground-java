package su.levenetc.playground.java.utils;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by elevenetc on 04/07/15.
 */
public class Out {


	public static void plnBin(int val) {
		System.out.println(Integer.toBinaryString(val));
	}

	public static void pln() {
		System.out.println("\n");
	}

	public static void pln(Collection result) {
		System.out.println(Arrays.toString(result.toArray()));
	}

	public static void p(Object result) {
		System.out.print(result.toString());
	}

	public static void pln(Object result) {
		System.out.println(result.toString());
	}

	public static void pln(float result) {
		System.out.println(result);
	}

	public static void pln(int result) {
		System.out.println(result);
	}

	public static void pln(String result) {
		System.out.println(result);
	}

	public static void result(Object in, Object out) {
		pln(" in: " + in + "\nout: " + out);
	}

	public static void result(Object[] in, Object[] out) {
		result(Arrays.toString(in), Arrays.toString(out));
	}


	public static void meth(String result) {
		System.out.println("method(" + SysUtils.time() + "): " + result);
	}

	public static void newLine() {
		System.out.println("");
	}
}
