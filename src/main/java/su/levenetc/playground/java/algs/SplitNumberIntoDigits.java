package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

public class SplitNumberIntoDigits {
    public static List<Integer> split(int value) {
        List<Integer> result = new LinkedList<>();
        while (value != 0) {
            result.add(value % 10);
            value /= 10;
        }
        return result;
    }
}
