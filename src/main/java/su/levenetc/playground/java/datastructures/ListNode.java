package su.levenetc.playground.java.datastructures;

public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode get(int value) {
        ListNode node = this;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        ListNode node = next;
        int result = 1;
        int max = 1000;
        while (node != null) {
            node = node.next;
            result++;
            max--;
            if (max == 0) {
                return -1;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        ListNode node = this;
        int length = size();
        sb.append("[");
        sb.append("size:");
        sb.append(length);
        sb.append("]");
        sb.append("{");

        if (length == -1) {
            sb.append(value);
            sb.append(':');
            sb.append("looped");
            sb.append('}');
            return sb.toString();
        }

        while (node != null) {
            counter++;

            if (counter > 100) {
                sb.append("loop detected");
                break;
            }

            sb.append(String.valueOf(node.value));
            node = node.next;
            if (node != null) {
                sb.append(">");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    public static ListNode node(int value) {
        return new ListNode(value);
    }

    public static ListNode range(int from, int to) {
        ListNode root = new ListNode(from);
        ListNode node = root;
        while (from != to) {
            from++;
            node.next = new ListNode(from);
            node = node.next;
        }
        return root;
    }

    public static ListNode list(int... values) {
        if (values.length == 0) return null;
        ListNode root = new ListNode(values[0]);
        ListNode current = root;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return root;
    }

    public static ListNode tail(ListNode head) {
        ListNode tail = head;
        while (head != null) {
            tail = head;
            head = head.next;
        }
        return tail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode listNode = (ListNode) o;

        return value == listNode.value;
    }

    public boolean valueEquals(ListNode node) {
        if (node == null) return false;
        ListNode current = this;
        while (current != null && node != null) {
            if (current.value != node.value) {
                return false;
            }
            current = current.next;
            node = node.next;
        }

        return current == null && node == null;
    }

    @Override
    public int hashCode() {
        return value;
    }
}
