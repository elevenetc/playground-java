package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

import java.util.LinkedList;
import java.util.List;

public class TrimTree {
    static BNode trim(BNode node, int left, int right) {

        if (node == null || (node.left == null && node.right == null)) return node;

        List<Integer> nodes = new LinkedList<>();
        toArray(node, nodes);

        int l = 0;
        int r = nodes.size() - 1;

        while (nodes.get(l) < left || nodes.get(r) > right) {
            if (nodes.get(l) < left) {
                l++;
            }
            if (nodes.get(r) > right) {
                r--;
            }
        }


        nodes = nodes.subList(l, r + 1);

        return toBST(nodes, 0, nodes.size() - 1);
    }

    static BNode toBST(List<Integer> nodes, int l, int r) {
        if (l > r) return null;
        int mid = (r - l) / 2 + l;
        BNode node = new BNode(nodes.get(mid));
        node.left = toBST(nodes, l, mid - 1);
        node.right = toBST(nodes, mid + 1, r);
        return node;
    }

    static void toArray(BNode node, List<Integer> list) {
        if (node == null) return;
        toArray(node.left, list);
        list.add(node.value);
        toArray(node.right, list);
    }
}
