package su.levenetc.playground.java.datastructures;

public class IntNode {
    public int value;
    public IntNode next;

    public IntNode(int value) {
        this.value = value;
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
