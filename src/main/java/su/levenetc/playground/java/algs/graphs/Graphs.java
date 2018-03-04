package su.levenetc.playground.java.algs.graphs;

import static su.levenetc.playground.java.algs.graphs.GNode.node;
import static su.levenetc.playground.java.algs.graphs.Graph.traverseAll;

public class Graphs {

    public static Graph spider() {
        //          0
        //      /   |   \
        //     1    2    3
        //    /     |     \
        //   4      5      6
        //  /\      |      /\
        // 7  8     9    10  11
        //         / \
        //        12  13

        GNode[] nodes = createNodes(13);
        nodes[0].child(nodes[1]);
        nodes[0].child(nodes[2]);
        nodes[0].child(nodes[3]);

        nodes[1].child(nodes[4]);
        nodes[2].child(nodes[5]);
        nodes[3].child(nodes[6]);

        nodes[4].child(nodes[7]);
        nodes[4].child(nodes[8]);

        nodes[5].child(nodes[9]);

        nodes[6].child(nodes[10]);
        nodes[6].child(nodes[11]);

        nodes[9].child(nodes[12]);
        nodes[9].child(nodes[13]);

        return new Graph(nodes);
    }

    public static Graph diamond3() {

        //   0
        //  / \
        // 1   2
        //  \ /
        //   3

        GNode[] nodes = createNodes(3);
        nodes[0].child(nodes[1]);
        nodes[0].child(nodes[2]);

        nodes[1].child(nodes[3]);
        nodes[2].child(nodes[3]);

        return new Graph(nodes);
    }

    public static Graph dimond3Extended() {

        //     0
        //    / \
        //   1   2
        //    \ /
        //     3
        //     |
        //     4
        //    / \
        //   5   6
        //    \ / \
        //     7   8

        Graph graph = diamond3();

        GNode node = graph.get(3);
        GNode n4 = node.add(node(4));
        GNode n5 = n4.add(5);
        GNode n6 = n4.add(6);
        GNode n7 = n5.add(7);

        n6.add(n7);
        n6.add(8);

        graph.resetNodes(traverseAll(graph.get(0)));

        return graph;
    }

    public static Graph dimond3Extended2() {

        //        -3 -4 -> 8
        //         \ /
        //         -2
        //         /
        //       -1
        //      /
        //     0
        //    / \
        //   1   2
        //    \ /
        //     3
        //     |
        //     4
        //    / \
        //   5   6
        //    \ / \
        //     7   8 <- -4

        Graph graph = diamond3();

        GNode node = graph.get(3);
        GNode n4 = node.add(node(4));
        GNode n5 = n4.add(5);
        GNode n6 = n4.add(6);
        GNode n7 = n5.add(7);

        n6.add(n7);
        n6.add(8);

        graph.get(0).add(-1).add(-2).add(-3);
        graph.resetNodes(traverseAll(graph.get(0)));
        graph.get(-2).add(-4);
        graph.resetNodes(traverseAll(graph.get(0)));
        graph.get(-4).add(graph.get(8));

        graph.resetNodes(traverseAll(graph.get(0)));

        return graph;
    }

    public static Graph basicBinaryTree() {

        //        0
        //      /   \
        //     1     2
        //    / \   / \
        //   3   4 5   6


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
