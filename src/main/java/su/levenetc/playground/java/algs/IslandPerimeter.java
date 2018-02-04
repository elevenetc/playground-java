package su.levenetc.playground.java.algs;

public class IslandPerimeter {
    public static int islandPerimeter(int[][] grid) {
        int result = 0;
        for(int r = 0; r < grid.length; r++){
            int[] row = grid[r];
            for(int c = 0; c < row.length; c++){
                int g = row[c];

                if(g == 1) result += count(grid, c, r);
            }
        }
        return result;
    }

    static int count(int[][] grid, int c, int r){
        int result = 0;
        result += hasBorder(grid, c - 1, r) ? 1 : 0;
        result += hasBorder(grid, c + 1, r) ? 1 : 0;
        result += hasBorder(grid, c, r + 1) ? 1 : 0;
        result += hasBorder(grid, c, r - 1) ? 1 : 0;
        return result;
    }

    static boolean hasBorder(int[][] grid, int c, int r){
        if(r < 0 || r > grid.length - 1 || c < 0 || c > grid[0].length - 1) return true;
        return grid[r][c] == 0;
    }
}
