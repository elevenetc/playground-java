package su.levenetc.playground.java.algs.trees;

import java.util.HashMap;

import su.levenetc.playground.java.datastructures.BNode;

public class PathSum3 {

    public int get(BNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    public int helper(BNode root, int currSum, int targetSum, HashMap<Integer, Integer> preSum) {
        if (root == null) return 0;

        currSum += root.value;

        int result = preSum.getOrDefault(currSum - targetSum, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        result += helper(root.left, currSum, targetSum, preSum) + helper(root.right, currSum, targetSum, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);

        return result;
    }
}
