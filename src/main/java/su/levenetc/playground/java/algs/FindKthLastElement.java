package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.datastructures.ListNode;

public class FindKthLastElement {

    static int result = -1;

    static int findRecursive(int k, ListNode root) {
        result = -1;
        recurse(root, k);
        return result;
    }

    private static int recurse(ListNode node, int k) {
        if (node == null) {
            return 0;
        } else {
            int res = recurse(node.next, k) + 1;
            if (res == k) result = node.value;
            return res;
        }
    }


    static int findIterative(int k, ListNode root) {
        ListNode fast = root;
        ListNode slow = root;

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
