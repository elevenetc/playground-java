package su.levenetc.playground.java.algs.stacks;

public class Stack {

    Node top;
    private int size;

    public Stack() {

    }

    public Stack(int... values) {
        push(values);
    }

    public void push(int... values) {
        for (int v : values) push(v);
    }

    public void push(int value) {
        size++;
        Node newNode = new Node(value);
        if (top == null) {
            top = newNode;
        } else {

            newNode.prev = top;
            top = newNode;
        }
    }

    public int peek() {
        return top.value;
    }

    public int pop() {
        size--;
        Node l = this.top;
        top = l.prev;
        return l.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        if (isEmpty()) {
            sb.append("empty");
        } else {
            Node n = top;

            while (n != null) {

                sb.append(n.value);

                if (n.prev != null) {
                    sb.append('>');
                }

                n = n.prev;
            }
        }

        sb.append(']');
        return sb.toString();
    }

    static class Node {
        Node prev;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
