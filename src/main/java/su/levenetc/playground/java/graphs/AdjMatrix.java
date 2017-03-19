package su.levenetc.playground.java.graphs;

/**
 * Created by eugene.levenetc on 18/03/2017.
 */
public class AdjMatrix {

    private int[][] matrix;
    private int nodesAmount;

    public AdjMatrix(int nodesAmount) {
        matrix = new int[nodesAmount][nodesAmount];
        this.nodesAmount = nodesAmount;
    }

    public void addConnection(int w, int h) {
        matrix[w][h] = 1;
        matrix[h][w] = 1;
    }

    public int numOfConnections() {

        if (nodesAmount <= 1) return nodesAmount;

        boolean[] visited = new boolean[nodesAmount];
        int connections = 0;
        for (int i = 0; i < nodesAmount; i++) {
            if (visited[i]) {
                continue;
            }
            dfs(i, visited);
            connections++;
        }
        return connections;
    }

    public void dfs(int index, boolean[] visited) {
        final int[] children = matrix[index];
        for (int i = 0; i < children.length; i++) {
            if (visited[i]) continue;
            if (children[i] == 1) {
                visited[i] = true;
                dfs(i, visited);
            }
        }
    }

    public boolean dfs(int nodeA, int nodeB, boolean[] visited) {
        if (matrix[nodeA][nodeB] == 1) {
            visited[nodeA] = true;
            visited[nodeB] = true;
            return true;
        }

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

    public boolean dfs(int nodeA, int nodeB) {
        return dfs(nodeA, nodeB, new boolean[matrix.length]);
    }

    private boolean internalDFS(boolean[] visited, int index, int search) {


        final int[] children = matrix[index];

        for (int i = 0; i < children.length; i++) {
            if (!visited[i] && children[i] == 1) {
                visited[i] = true;

                if (search == i) {
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
