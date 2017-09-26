package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

public class AddTwoHugeNumbers {

    public static List<Integer> sum(List<Integer> a, List<Integer> b) {
        LinkedList<Integer> top = splitInts(a);
        LinkedList<Integer> bottom = splitInts(b);
        LinkedList<Integer> result = new LinkedList<>();
        if (top.size() < bottom.size()) {
            LinkedList<Integer> tmp = top;
            top = bottom;
            bottom = tmp;
        }

        while (!bottom.isEmpty()) {
            int lastBottom = bottom.removeLast();
            int lastTop = top.removeLast();
            int value = lastBottom + lastTop;
            if (value >= 10) {
                value = value - 10;
                if (top.isEmpty()) {
                    result.addFirst(1);
                } else {
                    int newLast = top.getLast() + 1;
                    top.set(top.size() - 1, newLast);
                }
            }

            result.addFirst(value);
        }

        while (!top.isEmpty()) {
            int last = top.removeLast();
            result.addFirst(last);
        }

        return result;
    }

    public static LinkedList<Integer> splitInts(List<Integer> values) {
        LinkedList<Integer> result = new LinkedList<>();
        for (Integer value : values) {
            List<Integer> split = splitInt(value);
            result.addAll(split);
        }
        return result;
    }

    public static LinkedList<Integer> splitInt(int value) {
        if (value <= 9) {
            LinkedList<Integer> result = new LinkedList<>();
            result.add(value);
            return result;
        }

        String str = String.valueOf(value);
        char[] chars = str.toCharArray();
        LinkedList<Integer> result = new LinkedList<>();

        for (char ch : chars) {
            result.add(Character.digit(ch, 10));
        }
        return result;
    }
}
