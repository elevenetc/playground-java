package su.levenetc.playground.java.datastructures;

import java.util.LinkedList;
import java.util.Objects;

public class CustomHashSet {

    Bucket[] buckets = new Bucket[1001];

    /**
     * Initialize your data structure here.
     */
    public CustomHashSet() {

    }

    public void add(int key) {
        int k = getKey(key);
        if (buckets[k] == null) {
            buckets[k] = new Bucket();
        }

        if (!contains(key)) {
            buckets[k].nodes.add(new Node(key));
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int k = getKey(key);
            buckets[k].nodes.remove(new Node(key));
        }
    }

    private int getKey(int key) {
        return key / 1000;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int k = getKey(key);
        if (buckets[k] == null) {
            return false;
        } else {
            for (Node n : buckets[k].nodes) {
                if (n.value == key) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Bucket {
        LinkedList<Node> nodes = new LinkedList<>();
    }

    static class Node {
        int value;

        Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value;
        }

        @Override
        public int hashCode() {

            return Objects.hash(value);
        }
    }
}
