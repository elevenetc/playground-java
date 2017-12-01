package su.levenetc.playground.java.utils;

import java.util.*;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class Utils {


    public static boolean isCompletable(String full, String prefix) {
        if (prefix.length() > full.length()) return false;
        if (prefix.length() == 0) return false;
        char[] chars = prefix.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (full.charAt(i) != ch) {
                return false;
            }
        }
        return true;
    }

    public static List<Integer> listRange(int from, int to) {
        List<Integer> result = new LinkedList<>();
        for (int i = from; i <= to; i++) {
            result.add(i);
        }
        return result;
    }

    public static int[] range(int from, int to) {
        return range(from, to, 1);
    }

    public static int[] range(int from, int to, int step) {
        int length = to - from + 1;
        int[] result = new int[(int) Math.ceil(length / (float) step)];
        int value = from;
        for (int i = 0; i < result.length; i++) {
            result[i] += value;
            value += step;
        }
        return result;
    }

    public static LinkedList<Integer> linkedList(int... values) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int value : values) result.add(value);
        return result;
    }

    public static List<Integer> list(int... values) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int value : values) result.add(value);
        return result;
    }

    public static char[] charArray(char... values) {
        return values;
    }

    public static int[] array(int... values) {
        return values;
    }

    public static <T> Set<T> set(T... values) {
        Set<T> result = new HashSet<>();
        result.addAll(Arrays.asList(values));
        return result;
    }

    public static <T> T get(List<T> list, int index) {
        if (index < 0 || index > list.size() - 1) {
            return null;
        } else {
            return list.get(index);
        }
    }

    public static int[][] toArrays(List<List<Integer>> list) {
        int[][] result = new int[list.size()][];
        for (int i = 0; i < result.length; i++) {
            final List<Integer> integers = list.get(i);
            result[i] = new int[integers.size()];
            for (int i1 = 0; i1 < result[i].length; i1++) {
                result[i][i1] = integers.get(i1);
            }
        }
        return result;
    }

    public static boolean containsOrdered(int[][] arrays, int... array) {
        for (int[] a : arrays) if (Arrays.equals(a, array)) return true;
        return false;
    }

    public static boolean containsNotOrdered(int[][] arrays, int... array) {
        HashSet<Integer> checkSet = new HashSet(toList(array));
        for (int[] a : arrays) {
            if (new HashSet(toList(a)).equals(checkSet)) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] array, int value) {
        for (int i : array) if (i == value) return true;
        return false;
    }

    public static List<Integer> toList(int... values) {
        List<Integer> result = new LinkedList<>();
        for (int value : values) {
            result.add(value);
        }
        return result;
    }

    public static Set<Integer> intSet(int... values) {
        Set<Integer> set = new HashSet<>();

        for (int value : values) {
            set.add(value);
        }

        return set;
    }

//    public static <T> List<T> toList(T... values) {
//        List<T> result = new ArrayList<>();
//        result.addAll(Arrays.asList(values));
//        return result;
//    }
}
