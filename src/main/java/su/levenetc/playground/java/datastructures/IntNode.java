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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        IntNode node = this;
        sb.append("{");
        while (node != null) {
            sb.append(String.valueOf(node.value));
            node = node.next;
            if (node != null) {
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
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
}
