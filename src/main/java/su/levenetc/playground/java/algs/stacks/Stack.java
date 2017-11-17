package su.levenetc.playground.java.algs.stacks;

public class Stack {

    Node top;
    private int size;

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

    static class Node {
        Node prev;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
