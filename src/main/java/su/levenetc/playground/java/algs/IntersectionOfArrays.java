package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {
    static List<Integer> get(int[] a, int[] b) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] array;
        if (a.length < b.length) {
            array = b;
            count(map, a);
        } else {
            array = a;
            count(map, b);
        }

        List<Integer> result = new LinkedList<>();

        for (int n : array) {
            if (map.containsKey(n)) {
                result.add(n);
                int count = map.get(n);
                if (count == 1) {
                    map.remove(n);
                } else {
                    map.put(n, --count);
                }
            }
        }

        return result;

    }

    static void count(Map<Integer, Integer> map, int[] nums) {
        for (int n : nums) {
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
    }

}
