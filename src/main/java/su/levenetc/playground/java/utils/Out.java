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

    public static int index = 0;

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

    public static void plnBin(byte val, String postfix) {
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

    public static void plnBin(byte val) {
        Out.pln(binValue(val));
    }


    @NotNull
    public static String binValue(int val) {
        String cutBinStr = Integer.toBinaryString(val);
        return toBinString(cutBinStr, 32);
    }

    @NotNull
    public static String binValue(byte val) {

        String cutBinStr;

        if (val == 0) {
            cutBinStr = StringUtils.multiply('0', 32);
        } else {
            cutBinStr = Integer.toBinaryString(val);
        }

        return cutBinStr.substring(32 - 8, 32);
    }

    @NotNull
    private static String toBinString(String cutBinStr, int totalLength) {

        String fullBinStr = StringUtils.multiply('0', totalLength - cutBinStr.length()) + cutBinStr;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < fullBinStr.length(); i++) {
            char ch = fullBinStr.charAt(i);
            sb.append(ch);
            if (i != 31 && i != 0 && (i + 1) % 8 == 0) {
                sb.append('_');
            }
        }

        return sb.toString();
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

    public static void pln(char[] chars) {
        System.out.println(String.valueOf(chars));
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

    public static void plnIndex(String value) {
        pln(index++, value);
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

    public static void plnCurrentThread(Object tag, String message) {
        pln(tag, currentThread() + ": " + message);
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
        for (int r = 0; r < matrix.length; r++) {
            final int[] row = matrix[r];
            for (int c = 0; c < row.length; c++) {
                Out.p(row[c]);
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

    public static void format(String format, Object... str) {
        Out.pln(String.format(format, str));
    }
}
