package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.algs.pathfinding.NumNode;
import su.levenetc.playground.java.utils.Out;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by eugene.levenetc on 10/11/2016.
 */
public class GraphUtils {
    public static NumNode[][] genEmpty() {
        NumNode[][] result = new NumNode[3][3];
        for (int x = 0; x < result.length; x++) {
            for (int y = 0; y < result[x].length; y++) {
                result[x][y] = new NumNode(x, y);
                result[x][y].setValue(0);
            }
        }
        return result;
    }

    public static void printGraph(NumNode[][] graph) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < graph.length; x++) {
            for (int y = 0; y < graph.length; y++) {
                sb.append(graph[x][y].getValue());
            }
            sb.append('\n');
        }
        Out.pln(sb.toString());
    }

    public static boolean containsCycleIterative(int[][] matrix) {

        boolean[] visited = new boolean[matrix.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.add(0);

        while (!stack.isEmpty()) {

            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;

                final int[] children = matrix[node];
                for (int i = 0; i < children.length; i++) {
                    if (children[i] == 1) {
                        stack.push(i);
                    }
                }

            } else {
                Out.pln("Found cycle " + node);
                return true;
            }


        }

        Out.plnArray(visited);

        return false;
    }

    public static boolean containsCycleRecursive(int[][] matrix) {

        for (int n = 0; n < matrix.length; n++) {
            int[] children = matrix[n];

            if (checkChildren(n, matrix, children, new boolean[matrix.length])) {
                return true;
            }
        }

        return false;
    }

    static boolean checkChildren(int node, int[][] matrix, int[] children, boolean[] visited) {

        if (visited[node]) {
            return true;
        }

        for (int ch = 0; ch < children.length; ch++) {
            if (children[ch] == 1) {
                visited[node] = true;

                if (checkChildren(ch, matrix, matrix[ch], visited)) {
                    return true;
                }
            }
        }
        Arrays.fill(visited, false);
        return false;
    }
}
