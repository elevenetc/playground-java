package su.levenetc.playground.java.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class Utils {

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
