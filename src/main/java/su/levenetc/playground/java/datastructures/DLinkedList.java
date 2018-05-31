package su.levenetc.playground.java.datastructures;

public class DLinkedList {

    private DNode tail;
    private DNode head;
    private int size;

    public boolean contains(int value) {
        if (size == 0) return false;

        DNode node = tail;

        while (node != null) {
            if (node.value == value) return true;
            node = node.next;
        }

        return false;
    }

    public int size() {
        return size;
    }

    public DNode tail() {
        return tail;
    }

    public DNode head() {
        return head;
    }

    /**
     * Adds new node to head
     */
    public void add(DNode newNode) {

        if (size == 0) {
            tail = newNode;
            head = tail;
            tail.next = head;
            head.prev = tail;
        } else if (size == 1) {
            head = newNode;
            head.prev = tail;
            tail.next = head;
        } else {
            head.next = newNode;
            newNode.prev = head;
            head = newNode;
        }
        size++;
    }

    public void remove(DNode node) {

        if (size == 1) {
            tail = null;
            head = null;
        } else {
            DNode next = node.next;
            DNode prev = node.prev;

            if (prev != null) prev.next = next;
            if (next != null) next.prev = prev;

            if (node == tail) {
                tail = next;
            } else if (node == head) {
                head = prev;
            }
        }

        node.next = null;
        node.prev = null;

        size--;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        } else if (size == 1) {
            return String.format("[%s]", tail.toString());
        } else {
            DNode node = tail;
            StringBuilder sb = new StringBuilder();
            sb.append('[');

            while (node != null) {
                sb.append(node.toString());
                if (node.next != null) {
                    sb.append(", ");
                }
                node = node.next;
            }

            sb.append(']');

            return sb.toString();
        }
    }

    public static class DNode {
        int value;
        DNode next;
        DNode prev;

        public DNode(int value) {
            this.value = value;
        }

        static boolean compare(DNode a, DNode b) {
            if (a == null && b == null) return true;
            if (a == null || b == null) return false;
            return a.value == b.value;
        }

        @Override
        public String toString() {
            return String.format("{%d}", value);
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof DNode)) return false;
            DNode node = (DNode) o;
            return node.value == value && compare(prev, node.prev) && compare(next, node.next);
        }
    }
}