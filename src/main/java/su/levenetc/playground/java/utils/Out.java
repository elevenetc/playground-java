package su.levenetc.playground.java.utils;

import su.levenetc.playground.java.datastructures.Graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by elevenetc on 04/07/15.
 */
public class Out {

    public static void plnBin(String prefix, int val) {
        Out.pln(prefix + ": " + Integer.toBinaryString(val));
    }

    public static void plnBin(int val) {
        Out.pln(Integer.toBinaryString(val));
    }

    public static void pln(HashMap<String, String> hashMap) {
        for (String key : hashMap.keySet())
            Out.pln(key + ":" + hashMap.get(key));
    }

    public static void pln() {
        System.out.print("\n");
    }

    public static void pln(Collection result) {
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void p(Object result) {
        System.out.print(result.toString());
    }

    public static void pln(Object result) {
        System.out.println(result);
    }

    public static void plnArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void plnArray(boolean[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void plnArray(long[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void pln(float result) {
        System.out.println(result);
    }

    public static void pln(String prefix, int result) {
        pln(prefix + ": " + result);
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

    public static void plnCurrentThread() {
        pln(Thread.currentThread());
    }

    public static void plnCurrentThread(String tag) {
        pln(currentThread() + ": " + tag);
    }

    public static String currentThread() {
        return "[" + Thread.currentThread().getName() + "]";
    }

    public static void bin(int value) {
        pln(Integer.toString(value, 2));
    }

    public static void hex(int value) {
        pln(Integer.toString(value, 16));
    }

    public static void chars(String string) {
        for (int i = 0; i < string.length(); i++) {
            final char ch = string.charAt(i);
            Out.pln(ch + " : " + (int) ch);
        }
    }

    public static void pln(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            final int[] row = matrix[i];
            for (int k = 0; k < matrix.length; k++) {
                Out.p(row[k]);
                Out.p(" ");
            }
            Out.pln();
        }
    }

    public static void plnBinary(int value) {
        Out.pln(Integer.toBinaryString(value));
    }

    public static void plnInverted(List list) {
        for (int i = 0; i < list.size(); i++) {
            Out.pln(list.get(i));
        }
    }
}
