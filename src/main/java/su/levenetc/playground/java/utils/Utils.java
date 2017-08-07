package su.levenetc.playground.java.utils;

import java.util.*;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class Utils {

    public static List<Integer> range(int from, int to) {
        List<Integer> result = new LinkedList<>();
        for (int i = from; i <= to; i++) result.add(i);
        return result;
    }

    public static int[] arrayRange(int from, int to) {
        int length = to - from + 1;
        int[] result = new int[length];
        int value = from;
        for (int i = 0; i < length; i++) {
            result[i] = value;
            value++;
        }
        return result;
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

    public static boolean contains(int[][] arrays, int... array) {
        for (int[] a : arrays) if (Arrays.equals(a, array)) return true;
        return false;
    }

    public static boolean contains(int[] array, int value) {
        for (int i : array) if (i == value) return true;
        return false;
    }

    public static <T> List<T> toList(T... values) {
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(values));
        return result;
    }
}
