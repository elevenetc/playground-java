package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene.levenetc on 22/06/2017.
 */
public class IsValidSudoku {

    public static boolean isValid(char[][] grid) {
        return isRowsValid(grid) && isColumnsValid(grid) && isBlocksValid(grid);
    }

    public static boolean isValid2(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char value = board[r][c];
                if (value != '.')
                    if (!seen.add(value + " in row " + r) ||
                            !seen.add(value + " in column " + c) ||
                            !seen.add(value + " in block " + r / 3 + "-" + c / 3))
                        return false;
            }
        }
        return true;
    }

    static boolean isRowsValid(char[][] grid) {

        for (int r = 0; r < grid.length; r++) {
            char[] row = grid[r];
            Set<Character> set = new HashSet<>();
            for (int c = 0; c < row.length; c++) {
                char ch = grid[r][c];
                if (ch == '.') continue;
                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    static boolean isColumnsValid(char[][] grid) {

        for (int c = 0; c < 9; c++) {

            Set<Character> set = new HashSet<>();
            for (int r = 0; r < 9; r++) {
                char ch = grid[r][c];
                if (ch == '.') continue;
                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }
        }
        return true;
    }

    static boolean isBlocksValid(char[][] grid) {

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (!isBlockValid(grid, r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean isBlockValid(char[][] grid, int r, int c) {
        r *= 3;
        c *= 3;
        int maxR = r + 3;
        int maxC = c + 3;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            char ch = grid[r][c];
            if (ch != '.') {
                if (set.contains(ch)) {
                    return false;
                } else {
                    set.add(ch);
                }
            }

            c++;

            if (c == maxC) {
                r++;
                c -= 3;
            }

        }

        return true;


    }
}
