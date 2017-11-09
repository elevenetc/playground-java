package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.IntNode;

public class FindKthLastElement {

    static int result = -1;

    static int findRecursive(int k, IntNode root) {
        result = -1;
        recurse(root, k);
        return result;
    }

    private static int recurse(IntNode node, int k) {
        if (node == null) {
            return 0;
        } else {
            int res = recurse(node.next, k) + 1;
            if (res == k) result = node.value;
            return res;
        }
    }


    static int findIterative(int k, IntNode root) {
        IntNode fast = root;
        IntNode slow = root;

        for (int i = 1; i <= k; i++) {
            fast = fast.next;
            if (fast == null) return -1;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.value;
    }
}
