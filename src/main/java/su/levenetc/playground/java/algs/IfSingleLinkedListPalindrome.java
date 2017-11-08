package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

import su.levenetc.playground.java.datastructures.IntNode;

public class IfSingleLinkedListPalindrome {
    static boolean check(IntNode root) {

        IntNode slow = root;
        IntNode fast = root;
        Deque<IntNode> left = new LinkedList<>();
        IntNode right = null;

        while (fast != null) {

            left.push(slow);
            slow = slow.next;

            if (fast.next == null) {
                left.pop();
                right = fast;
                fast = null;
            } else if (fast.next.next == null) {
                right = left.peek().next;
                fast = null;
            } else {
                fast = fast.next.next;
            }
        }


        while (right != null && !left.isEmpty()) {

            if (!right.equals(left.pop())) {
                return false;
            }

            right = right.next;
        }

        return right == null && left.isEmpty();
    }
}