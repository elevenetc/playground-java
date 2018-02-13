package su.levenetc.playground.java.algs.trees;

import su.levenetc.playground.java.datastructures.BNode;

public class PathSum {
    public static boolean rootToLeafSum(BNode node, int sum) {
        if (node == null && sum == 0) return true;
        if (node == null) return false;
        return rootToLeafSum(node.left, sum - node.value) | rootToLeafSum(node.right, sum - node.value);
    }
}
