package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

public class AddTwoHugeNumbers {

    public static List<Integer> formattedSum(LinkedList<Integer> a, LinkedList<Integer> b) {
        LinkedList<Integer> aList = splitInt(a.removeFirst());
        LinkedList<Integer> bList = splitInt(b.removeFirst());
        for (Integer aValue : a) {
            aList.addAll(fixLeadingZeroAndSplit(aValue));
        }

        for (Integer bValue : b) {
            bList.addAll(fixLeadingZeroAndSplit(bValue));
        }
        return sum(aList, bList);
    }

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

    public static LinkedList<Integer> fixLeadingZeroAndSplit(int value) {

        LinkedList<Integer> result;
        if (value >= 1000) {
            result = splitInt(value);
        } else {
            result = splitInt(value);
            if (value >= 100) {
                result.addFirst(0);
            } else if (value >= 10) {
                result.addFirst(0);
                result.addFirst(0);
            } else {
                result.addFirst(0);
                result.addFirst(0);
                result.addFirst(0);
            }
        }

        return result;
    }

    public static LinkedList<Integer> removeLeadingZeroes(LinkedList<Integer> values) {
        LinkedList<Integer> result = new LinkedList<>();
        while (values.size() >= 4) {
            int value4 = values.removeLast();
            int value3 = values.removeLast();
            int value2 = values.removeLast();
            int value1 = values.removeLast();

            if (value1 != 0) {
                result.add(value1);
                result.add(value2);
                result.add(value3);
                result.add(value4);
            } else if (value2 != 0) {
                result.add(value2);
                result.add(value3);
                result.add(value4);
            } else if (value3 != 0) {
                result.add(value3);
                result.add(value4);
            } else {
                result.add(value4);
            }
        }

        while (!values.isEmpty()) {
            result.addFirst(values.removeLast());
        }

        return result;
    }
}
