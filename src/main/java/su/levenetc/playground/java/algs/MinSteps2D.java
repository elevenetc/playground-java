package su.levenetc.playground.java.algs;

/**
 * https://codelab.interviewbit.com/problems/reach/
 *
 * You are in an infinite 2D grid where you can move in any of the 8 directions :
 *
 * You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
 *
 * Input : [(0, 0), (1, 1), (1, 2)]
 * Output : 2
 */
public class MinSteps2D {
    static int minSteps(int ax, int ay, int bx, int by) {
        if (ax == bx && ay == by) return 0;
        int diffX = Math.abs(ax - bx);
        int diffY = Math.abs(ay - by);

        if (diffX == 0) {
            return diffY;
        } else if (diffY == 0) {
            return diffX;
        } else if (diffX == diffY) {
            return diffX;
        } else {
            int min = Math.min(diffX, diffY);
            int max = Math.max(diffX, diffY);

            return min + (max - min);
        }
    }

}
