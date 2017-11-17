package su.levenetc.playground.java.datastructures;

public class IntNode {
    public int value;
    public IntNode next;

    public IntNode(int value) {
        this.value = value;
    }

    public IntNode get(int value) {
        IntNode node = this;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public int length() {
        IntNode node = next;
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
        IntNode node = this;
        int length = length();
        sb.append("[");
        sb.append("length:");
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

    public static IntNode node(int value) {
        return new IntNode(value);
    }

    public static IntNode list(int... values) {
        if (values.length == 0) return null;
        IntNode root = new IntNode(values[0]);
        IntNode current = root;
        for (int i = 1; i < values.length; i++) {
            current.next = new IntNode(values[i]);
            current = current.next;
        }
        return root;
    }

    public static IntNode tail(IntNode head) {
        IntNode tail = head;
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

        IntNode intNode = (IntNode) o;

        return value == intNode.value;
    }

    public boolean valueEquals(IntNode node) {
        if (node == null) return false;
        IntNode current = this;
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
