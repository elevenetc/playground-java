package utils;

import java.util.*;

/**
 * Created by eugene.levenetc on 13/04/2017.
 */
public class AssertUtils {

    public static boolean assertContains(List<int[]> arrays, int... values) {
        for (int[] array : arrays) {
            boolean found = true;
            for (int i = 0; i < values.length; i++) {
                if (array[i] != values[i]) {
                    found = false;
                    break;
                }
            }
            if (found) return true;
        }
        throw new AssertionError("cant find values: " + Arrays.toString(values));
    }

    public static <K, T> void assertContains(Map<K, Set<T>> map, T... checkSet) {
        List<Set<T>> list = new ArrayList<>();
        for (K key : map.keySet()) {
            final Set<T> set = map.get(key);
            list.add(set);
        }
        assertContains(list, checkSet);
    }

    public static <T> void assertContains(List<Set<T>> sets, T... checkSet) {
        boolean contains = false;
        for (Set<T> set : sets) {
            contains = true;

            if (checkSet.length != set.size()) {
                contains = false;
                continue;
            }

            for (T object : checkSet) {
                if (!set.contains(object)) {
                    contains = false;
                    break;
                }
            }
            if (contains) {
                break;
            }
        }
        if (!contains) {
            throw new AssertionError("No checkSet " + Arrays.toString(checkSet) + " in sets " + sets.toString());
        }
    }

    public static <T> void assertContains(Set<T> set, T... expects) {
        for (T object : expects) {
            if (!set.contains(object)) {
                throw new AssertionError(set + " does not contain object: " + object);
            }
        }
    }
}
