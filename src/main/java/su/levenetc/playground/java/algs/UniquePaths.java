package su.levenetc.playground.java.algs;


/**
 * https://leetcode.com/problems/unique-paths/description/
 */
public class UniquePaths {
    static int count(int w, int h) {

        if (w == 1 || h == 1) return 1;

        int[][] map = new int[w][h];
        for (int r = 0; r < map.length; r++) map[r][0] = 1;
        for (int c = 0; c < map[0].length; c++) map[0][c] = 1;

        for (int r = 1; r < map.length; r++) {
            int[] row = map[r];
            for (int c = 1; c < row.length; c++) {
                row[c] = map[r - 1][c] + map[r][c - 1];
            }
        }

        return map[w - 1][h - 1];
    }
}
