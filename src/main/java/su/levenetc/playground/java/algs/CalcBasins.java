package su.levenetc.playground.java.algs;

import java.util.*;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class CalcBasins {

    static HashMap<Field, Set<Field>> depths;
    static Field[][] fields;

    public static int[] calculateBasins(int[][] grid) {


        depths = new HashMap<>();
        fields = new Field[grid.length][grid[0].length];

        for (int u = 0; u < grid.length; u++) {
            for (int v = 0; v < grid[u].length; v++) {
                fields[u][v] = new Field(grid[u][v], u, v);
            }
        }

        for (int u = 0; u < grid.length; u++) {
            for (int v = 0; v < grid[u].length; v++) {
                final HashSet<Field> path = new HashSet<>();
                final Field bottom = flow(fields[u][v], path);

                if (depths.containsKey(bottom)) {
                    Set<Field> paths = depths.get(bottom);
                    path.addAll(paths);
                }

                depths.put(bottom, path);
            }
        }

        int[] result = new int[depths.size()];
        int i = 0;
        for (Iterator<Field> iterator = depths.keySet().iterator(); iterator.hasNext(); ) {
            Field field = iterator.next();
            final Set<Field> paths = depths.get(field);
            result[i] = paths.size();
            i++;
        }
        Arrays.sort(result);
        reverseArray(result);
        return result;
    }

    static void reverseArray(int[] array) {
        final int mid = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        while (start < mid) {
            int tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            start++;
            end--;
        }
    }

    static Field flow(Field field, Set<Field> path) {
        if (field == null) return null;
        int u = field.u;
        int v = field.v;

        path.add(field);

        //final Field f0 = getNeighbour(u + 1, v + 1);
        //final Field f1 = getNeighbour(u - 1, v + 1);
        //final Field f2 = getNeighbour(u + 1, v - 1);
        //final Field f3 = getNeighbour(u - 1, v - 1);

        final Field f4 = getNeighbour(u, v + 1);
        final Field f5 = getNeighbour(u, v - 1);
        final Field f6 = getNeighbour(u + 1, v);
        final Field f7 = getNeighbour(u - 1, v);

        final Field bottom = getBottom(field, f4, f5, f6, f7);

        if (bottom == field) {
            return bottom;
        } else {
            return flow(bottom, path);
        }
    }

    static Field getBottom(Field center, Field... fields) {
        Field bottom = center;
        for (Field field : fields) {
            if (field == null) continue;
            if (field.alt < bottom.alt) {
                bottom = field;
            }
        }
        return bottom;
    }

    static Field getNeighbour(int u, int v) {
        if (u < 0 || u > fields.length - 1) return null;
        if (v < 0 || v > fields[0].length - 1) return null;
        return fields[u][v];
    }

    static class Field {

        int alt;
        int u;
        int v;

        public Field(int alt, int u, int v) {
            this.alt = alt;
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Field field = (Field) o;

            if (u != field.u) return false;
            return v == field.v;
        }

        @Override
        public int hashCode() {
            int result = u;
            result = 31 * result + v;
            return result;
        }
    }
}
