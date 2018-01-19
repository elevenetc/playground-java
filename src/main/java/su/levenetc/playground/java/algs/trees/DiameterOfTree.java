package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class DiameterOfTree {

    public static int get(BNode root){
        DiameterData data = new DiameterData();
        int diameter = diameter(root, data);
        return Math.max(diameter, data.longestArc);
    }

    static int diameter(BNode node, DiameterData data) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        } else if (node.left == null) {
            return diameter(node.right, data) + 1;
        } else if (node.right == null) {
            return diameter(node.left, data) + 1;
        } else {
            int left = diameter(node.left, data) + 1;
            int right = diameter(node.right, data) + 1;
            data.longestArc = Math.max(left + right, data.longestArc);
            return Math.max(left, right);
        }
    }

    static class DiameterData {
        int longestArc;
    }
}
