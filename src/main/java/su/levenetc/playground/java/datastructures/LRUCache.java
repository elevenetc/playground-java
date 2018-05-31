package su.levenetc.playground.java.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node top = new Node();
    private Node bottom = new Node();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        bottom.next = top;
        top.prev = bottom;
    }

    public int recentlyUsed() {
        return top.prev.value;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        detachNode(node);
        moveToTop(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        } else if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            detachNode(node);
            moveToTop(node);
        } else {
            removeLeastUsedIfNeeded();
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            moveToTop(newNode);
        }
    }

    private void moveToTop(Node node) {
        Node prevTop = top.prev;
        prevTop.next = node;
        node.prev = prevTop;
        node.next = top;
        top.prev = node;
    }

    private void detachNode(Node node) {
        Node p = node.prev;
        Node n = node.next;
        p.next = n;
        n.prev = p;
    }

    private void removeLeastUsedIfNeeded() {
        if (map.size() == capacity) {
            Node toRemove = bottom.next;
            map.remove(toRemove.key);
            detachNode(toRemove);
        }
    }

    @Override
    public String toString() {

        Node n = bottom;
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (n != null) {
            sb.append(n.toString());
            n = n.next;
            if (n != null) {
                sb.append(", ");
            }
        }

        sb.append("]");

        return sb.toString();
    }

    static class Node {

        int key = -1;
        int value = -1;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {

        }

        @Override
        public String toString() {
            return String.format("{%d, %d}", key, value);
        }
    }
}
