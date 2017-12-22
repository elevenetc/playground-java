package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

import su.levenetc.playground.java.datastructures.BNode;

public class BuiltTreePath {
    static List<BNode> buildPath(BNode root, BNode target) {
        return buildPathInt(root, target).list;
    }

    static Result buildPathInt(BNode root, BNode target) {
        if (root == null) return null;

        if (root.value == target.value) {
            Result result = new Result();
            result.list.add(root);
            return result;
        } else {
            Result left = buildPathInt(root.left, target);
            Result right = buildPathInt(root.right, target);

            if (left == null && right == null) return null;

            Result res = left == null ? right : left;

            res.list.add(root);

            return res;
        }
    }

    static class Result {
        List<BNode> list = new LinkedList<>();
    }
}
