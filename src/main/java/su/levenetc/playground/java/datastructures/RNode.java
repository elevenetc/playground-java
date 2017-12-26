package su.levenetc.playground.java.datastructures;

import java.util.Objects;

import su.levenetc.playground.java.utils.Out;

public class RNode {

    public int value;
    public RNode next;
    public RNode rnd;
    public boolean clone;

    public RNode() {

    }

    public RNode(int value) {
        this.value = value;
    }

    public RNode(int value, RNode next, RNode rnd) {
        this.value = value;
        this.next = next;
        this.rnd = rnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RNode rNode = (RNode) o;
        return value == rNode.value &&
                Objects.equals(next, rNode.next) &&
                Objects.equals(rnd, rNode.rnd);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value, next, rnd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("(%d)", value));
        sb.append('[');

        RNode node = this;

        while (node != null) {
            int r = (node.rnd == null) ? -1 : node.rnd.value;
            sb.append(String.format("{value:%d, rnd:%d}", node.value, r));
            node = node.next;
        }

        sb.append(']');
        return sb.toString();
    }

    public static RNode list(int... values) {
        RNode root = new RNode(values[0]);
        RNode node = root;
        for (int i = 1; i < values.length; i++) {
            int value = values[i];
            node.next = new RNode(value);
            node = node.next;
        }
        node = root;

        while (node != null) {
            RNode rnd = getRandom(root, values.length);

            if (rnd == null) {
                Out.pln("AAAA");
            }

            node.rnd = rnd;

            node = node.next;

        }

        return root;
    }

    public static RNode getRandom(RNode list, int size) {
        double random = Math.random();
        int rnd = (int) (random * size);
        RNode result = list;

        while (rnd > 0) {
            result = result.next;
            rnd--;
        }
        return result;
    }
}
