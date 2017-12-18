package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class IsHappyNumber {
    static boolean is(int n) {
        List<Integer> v = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {

            while (n != 0) {
                int d = n % 10;
                n /= 10;
                v.add(d);
            }

            for (int i : v) {
                n += Math.pow(i, 2);
            }

            v.clear();
        }
        return n == 1;
    }
}
