package su.levenetc.playground.java.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class Utils {

    public static boolean contains(int[] array, int value) {
        for (int i : array) {
            if (i == value) return true;
        }
        return false;
    }

    public static <T> List<T> toList(T... values) {
        List<T> result = new ArrayList<>();
        result.addAll(Arrays.asList(values));
        return result;
    }
}
