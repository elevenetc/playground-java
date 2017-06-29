package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 29/06/2017.
 */
public class LinkedListPalindrome {

    public static boolean isListPalindrome(ListNode<Integer> node) {
        if (node == null) return true;
        if (node.next == null) return true;

        ListNode<Integer> slow = node;
        ListNode<Integer> fast = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode<Integer> left = node;
        ListNode<Integer> right = slow;

        while (right != null) {

            if (!left.value.equals(right.value)) {
                return false;
            }

            right = right.next;
            left = left.next;
        }


        return true;
    }

    public static <T> ListNode<T> reverse(ListNode<T> head) {
        if (head == null) return null;
        ListNode<T> current = head;
        ListNode<T> next;
        ListNode<T> prev = null;

        while (current.next != null) {

            next = current.next;

            current.next = prev;

            prev = current;
            current = next;

            if (current.next == null) {
                current.next = prev;
                break;
            }
        }
        return current;
    }

    public static class ListNode<T> {

        public ListNode(T x) {
            value = x;
        }

        public ListNode<T> add(T value) {
            this.next = new ListNode<>(value);
            return this.next;
        }


        T value;
        ListNode<T> next;

    }

    public static <T> ListNode<T> getList(T... values) {
        final T headValue = values[0];
        ListNode<T> head = new ListNode<>(headValue);
        ListNode<T> current = head;
        for (int i = 1; i < values.length; i++) {
            current = current.add(values[i]);
        }
        return head;
    }
}
