package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.List;

import su.levenetc.playground.java.datastructures.BNode;

public class BuildTreePaths {
    public List<String> binaryTreePaths(BNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, root, sb);
        return res;
    }

    private void helper(List<String> res, BNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        sb.append(root.value);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            helper(res, root.left, sb);
            helper(res, root.right, sb);
        }
        sb.setLength(len);
    }
}
