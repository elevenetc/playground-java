package su.levenetc.playground.java.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by elevenetc on 04/07/15.
 */
public class Out {

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static void three(Object a, Object b, Object c) {
        pln(String.format("%s, %s, %s", a, b, c));
    }

    public static void plnBin(Object prefix, int val) {
        plnBin(prefix.toString(), val);
    }

    public static void plnBinPostfix(int val) {
        pln(binValue(val), String.valueOf(val));
    }

    public static void plnBin(String prefix, int val) {
        Out.pln(prefix + ": " + binValue(val));
    }

    public static void plnBin(int val, String postfix) {
        pln(binValue(val), postfix);
    }

    public static void pBin(String prefix, int val) {
        Out.p(prefix + ": " + binValue(val));
    }

    public static void pBin(int val) {
        Out.p(binValue(val));
    }

    public static void plnBin(int val) {
        Out.pln(binValue(val));
    }

    @NotNull
    public static String binValue(int val) {
        StringBuilder binValue = new StringBuilder(Integer.toBinaryString(val));
        final int rem = 32 - binValue.length();
        for (int i = 0; i < rem; i++) binValue.insert(0, new char[]{'0'}, 0, 1);
        return binValue.toString();
    }

    public static void pln(HashMap<String, String> hashMap) {
        for (String key : hashMap.keySet())
            Out.pln(key + ":" + hashMap.get(key));
    }

    public static void pln(String prefix, Object a, Object b, Object c) {
        pln(prefix + ": (" + a + ", " + b + ", " + c + ")");
    }

    public static void pln(String prefix, Object a, Object b) {
        pln(prefix + ": (" + a + ", " + b + ")");
    }

    public static void pln(Object a, Object b) {
        pln(a + ": " + b);
    }

    public static void pln() {
        System.out.print("\n");
    }

    public static void pln(Collection result) {
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void p(String prefix, Object result) {
        System.out.print(prefix + ":" + result);
    }

    public static void pSpace(Object value) {
        System.out.print(" " + value.toString());
    }

    public static void p(Object result) {
        System.out.print(result.toString());
    }

    public static void pln(Object result) {
        System.out.println(result);
    }

    public static void plnTime(Object result) {
        System.out.println(SysUtils.time() + ":" + result);
    }

    public static void pln(int[] array) {
        plnArray(array);
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

    public static void pln(char result) {
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

    public static void method(String name, Object... params) {
        pln(name, Arrays.deepToString(params));
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

    public static void plnCurrentThread(Object tag) {
        pln(currentThread() + ": " + tag);
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

    public static String toBin(int value) {
        return Integer.toString(value, 2);
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
        for (int i = list.size() - 1; i >= 0; i--) {
            Out.pln(list.get(i));
        }
    }

    public static void plnRange(int[] a, int from, int to) {
        plnRange(null, a, from, to, -1);
    }

    public static void plnRange(String prefix, int[] a, int from, int to, int highlight) {

        Out.p(prefix == null ? "[" : prefix + ": [");
        for (int i = from; i <= to; i++) {
            if (highlight == i) Out.p(ANSI_RED);
            Out.p(a[i]);
            if (highlight == i) Out.p(ANSI_RESET);
            if (i < to) Out.p(", ");
        }
        Out.p("]");
    }
}
