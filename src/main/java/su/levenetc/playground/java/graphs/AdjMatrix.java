package su.levenetc.playground.java.graphs;

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

    public boolean dfs(int nodeA, int nodeB) {

        if (matrix[nodeA][nodeB] == 1) return true;

        final boolean[] visited = new boolean[matrix.length];
        visited[nodeA] = true;
        final int[] children = matrix[nodeA];

        for (int i = 0; i < children.length; i++) {
            if (!visited[i] && children[i] == 1) {
                visited[i] = true;
                if (internalDFS(visited, i, nodeB)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean internalDFS(boolean[] visited, int index, int search) {


        final int[] children = matrix[index];

        for (int i = 0; i < children.length; i++) {
            if (!visited[i] && children[i] == 1) {
                visited[i] = true;

                if(search == i){
                    return true;
                }

                if (internalDFS(visited, i, search)) {
                    return true;
                }
            }
        }

        return false;
    }
}
