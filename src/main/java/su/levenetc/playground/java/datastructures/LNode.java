package su.levenetc.playground.java.datastructures;

public class LNode {

    public int value;
    public LNode next;

    public LNode(int value) {
        this.value = value;
    }

    public LNode get(int value) {
        LNode node = this;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int size() {
        LNode node = next;
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
        LNode node = this;
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

    public static LNode node(int value) {
        return new LNode(value);
    }

    public static LNode range(int from, int to) {
        LNode root = new LNode(from);
        LNode node = root;
        while (from != to) {
            from++;
            node.next = new LNode(from);
            node = node.next;
        }
        return root;
    }

    public static LNode list(int... values) {
        if (values.length == 0) return null;
        LNode root = new LNode(values[0]);
        LNode current = root;
        for (int i = 1; i < values.length; i++) {
            current.next = new LNode(values[i]);
            current = current.next;
        }
        return root;
    }

    public static LNode tail(LNode head) {
        LNode tail = head;
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

        LNode listNode = (LNode) o;

        return value == listNode.value;
    }

    public boolean valueEquals(LNode node) {
        if (node == null) return false;
        LNode current = this;
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
