package su.levenetc.playground.java.algs.trees;

import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.datastructures.BNode;

public class PathSum2 {

    public List<List<Integer>> pathSum(BNode root, int sum) {
        List<List<Integer>> result = new LinkedList<>();
        allSumPaths(root, 0, sum, new LinkedList<>(), result);
        return result;
    }

    static void allSumPaths(BNode node, int currentSum, int targetSum, List<Integer> sum, List<List<Integer>> result) {
        if (node != null) {

            currentSum += node.value;
            sum.add(node.value);

            if (node.left == null && node.right == null && currentSum == targetSum) {
                result.add(new LinkedList<>(sum));
            } else {
                allSumPaths(node.left, currentSum, targetSum, sum, result);
                allSumPaths(node.right, currentSum, targetSum, sum, result);
            }

            sum.remove(sum.size() - 1);
        }
    }
}
