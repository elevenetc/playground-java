package su.levenetc.playground.java.algs;

import java.util.*;

/**
 * Created by eugene.levenetc on 17/04/2017.
 */
public class AlgorithmicCrush {

    static int size;
    static int operations;
    static List<LinkedList<Row>> froms;
    static List<LinkedList<Row>> tos;
    static Set<Row> group;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        size = scanner.nextInt();
        operations = scanner.nextInt();
        long maxValue = 0;

        froms = fill(size);
        tos = fill(size);
        group = new HashSet<>();

        for (int i = 0; i < operations; i++) {
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;
            int value = scanner.nextInt();
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

        System.out.println(maxValue);
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
        System.out.println(iterations);

        if (tos.get(index) != null) {
            LinkedList<Row> tosRows = tos.get(index);
            for (Row row : tosRows) {
                group.remove(row);
            }
        }
        return result;
    }

    static long[] concat(long[] first, long[] second) {
        long[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
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
