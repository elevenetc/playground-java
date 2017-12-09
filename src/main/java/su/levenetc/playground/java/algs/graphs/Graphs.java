package su.levenetc.playground.java.algs.graphs;

public class Graphs {

    public static Graph diamond3() {
        GNode[] nodes = createNodes(3);
        nodes[0].child(nodes[1]);
        nodes[0].child(nodes[2]);

        nodes[1].child(nodes[3]);
        nodes[2].child(nodes[3]);

        return new Graph(nodes);
    }

    public static Graph basicBinaryTree() {
        GNode[] nodes = createNodes(6);

        nodes[0].child(nodes[1]);
        nodes[0].child(nodes[2]);
        nodes[1].child(nodes[3]);
        nodes[1].child(nodes[4]);
        nodes[2].child(nodes[5]);
        nodes[2].child(nodes[6]);

        return new Graph(nodes);
    }

    public static GNode[] createNodes(int count) {
        GNode[] result = new GNode[count + 1];
        for (int i = 0; i <= count; i++) {
            result[i] = new GNode(i);
        }
        return result;
    }
}
