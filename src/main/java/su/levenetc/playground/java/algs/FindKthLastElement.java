package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.LNode;

public class FindKthLastElement {

    static int result = -1;

    static int findRecursive(int k, LNode root) {
        result = -1;
        recurse(root, k);
        return result;
    }

    private static int recurse(LNode node, int k) {
        if (node == null) {
            return 0;
        } else {
            int res = recurse(node.next, k) + 1;
            if (res == k) result = node.value;
            return res;
        }
    }


    static int findIterative(int k, LNode root) {
        LNode fast = root;
        LNode slow = root;

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
