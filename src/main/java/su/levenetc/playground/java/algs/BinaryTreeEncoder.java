package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.BNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeEncoder {

    private static String NULL_NODE_VALUE = "null";

    static BNode attach(int i, int layer, String[] values) {
        if (i >= values.length) return null;
        String v = values[i];
        if (v.equals(NULL_NODE_VALUE)) return null;
        BNode node = new BNode(Integer.valueOf(v));
        node.left = attach(2 * i + 1, layer + 1, values);
        node.right = attach(2 * i + 2, layer + 1, values);
        return node;
    }

    public String encode(BNode root) {
        Queue<BNode> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();

        queue.add(root);
        queue.add(null);

        BNode nullNode = new BNode(0);

        while (!queue.isEmpty()) {
            BNode n = queue.poll();

            if (n == null) {

                if (!queue.isEmpty()) {
                    queue.add(null);
                }

            } else {

                if (n == nullNode) {

                    list.add(NULL_NODE_VALUE);
                    continue;
                } else {
                    list.add(String.valueOf(n.value));
                }

                queue.add(n.left != null ? n.left : nullNode);
                queue.add(n.right != null ? n.right : nullNode);
            }
        }

        return list.toString().replace(" ", "");
    }

    public BNode decode(String data) {
        data = data.replace("[", "").replace("]", "");

        if (data.isEmpty()) {
            return null;
        } else {
            String[] values = data.split(",");
            return attach(0, 0, values);
        }
    }
}
