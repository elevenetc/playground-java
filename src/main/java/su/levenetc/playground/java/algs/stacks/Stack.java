package su.levenetc.playground.java.algs.stacks;

import su.levenetc.playground.java.Main;

public class Stack {

    Node top;

    public void push(int value) {
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
        Node l = this.top;
        top = l.prev;
        return l.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    static class Node {
        Node prev;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }
}
