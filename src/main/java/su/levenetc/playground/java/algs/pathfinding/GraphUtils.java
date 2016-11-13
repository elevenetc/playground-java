package su.levenetc.playground.java.algs.pathfinding;

import su.levenetc.playground.java.utils.Out;

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
}
