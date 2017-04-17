package su.levenetc.playground.java.algs;

import java.util.*;

/**
 * Created by eugene.levenetc on 17/04/2017.
 */
public class AlgorithmicCrush {

    static List<LinkedList<Row>> froms;
    static List<LinkedList<Row>> tos;
    static Set<Row> group;

    public static long getMax02(int[][] operations, int size) {

        long[] array = new long[size + 1];
        for (int i = 0; i < operations.length; i++) {
            int[] operation = operations[i];
            int from = operation[0];
            int to = operation[1];
            int value = operation[2];

            array[from] += value;
            array[to + 1] -= value;
        }

        long sum = 0;
        long max = 0;
        for (long value : array) {
            sum += value;
            max = Math.max(max, sum);

        }
        return max;
    }

    public static long getMax01(int[][] operations, int size) {
        long maxValue = 0;

        froms = fill(size);
        tos = fill(size);
        group = new HashSet<>();

        for (int i = 0; i < operations.length; i++) {
            final int[] operation = operations[i];
            int from = operation[0];
            int to = operation[1];
            int value = operation[2];
            Row row = new Row(from, to, value);

            if (froms.get(from) == null) {
                froms.set(from, new LinkedList<>());
            }
            if (tos.get(to) == null) {
                tos.set(to, new LinkedList<>());
            }
            froms.get(from).add(row);
            tos.get(to).add(row);
        }

        for (int i = 0; i < size; i++) {
            long merged = merge(i);
            if (merged > maxValue) {
                maxValue = merged;
            }
        }

        return maxValue;
    }

    static <T> List<T> fill(int size) {
        List<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
        return list;
    }

    static long merge(int index) {
        if (froms.get(index) != null) {
            LinkedList<Row> fromRows = froms.get(index);
            for (Row row : fromRows) {
                group.add(row);
            }
        }
        long result = 0;
        int iterations = 0;
        for (Row row : group) {
            iterations++;
            result += row.value;
        }

        if (tos.get(index) != null) {
            LinkedList<Row> tosRows = tos.get(index);
            for (Row row : tosRows) {
                group.remove(row);
            }
        }
        return result;
    }

    static class Row {
        int value;
        int from;
        int to;

        Row(int from, int to, int value) {
            this.from = from;
            this.to = to;
            this.value = value;
        }
    }
}
