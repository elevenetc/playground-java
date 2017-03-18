package su.levenetc.playground.java.graphs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by eugene.levenetc on 18/03/2017.
 */
public class AdjMatrix {

    private int[][] matrix;

    public AdjMatrix(int nodesAmount) {
        matrix = new int[nodesAmount][nodesAmount];
    }

    public void addConnection(int w, int h) {
        matrix[w][h] = 1;
        matrix[h][w] = 1;
    }

    Set<Integer> visited = new HashSet<>();

    public boolean hasConnectionDFS(int nodeA, int nodeB) {

        if(matrix[nodeA][nodeB] == 1) return true;

        int[] children = matrix[nodeA];
        visited.clear();
        visited.add(nodeA);
        for (int node = 0; node < children.length; node++) {

            if (visited.contains(node)) continue;

            if (searchIn(matrix[node], nodeB)) {
                return true;
            }
        }
        return false;
    }

    private boolean searchIn(int[] children, int value) {
        for (int node = 0; node < children.length; node++) {
            if (visited.contains(node)) continue;

            boolean hasConnection = children[node] == 1;

            if(hasConnection){
                visited.add(node);

                if (node == value) {
                    return true;
                }

                searchIn(matrix[node], value);
            }
        }
        return false;
    }
}
