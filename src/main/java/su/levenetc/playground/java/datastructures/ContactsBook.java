package su.levenetc.playground.java.datastructures;

import java.util.HashMap;

/**
 * Created by eugene.levenetc on 08/03/2017.
 */
public class ContactsBook {

    HashMap<Character, Node> map = new HashMap<>();

    public void add(String name) {
        internalAdd(name);
    }

    public int find(String prefix) {
        if (map.isEmpty()) return 0;
        int result = 0;
        for (int i = 0; i < prefix.length(); i++) {
            final char c = prefix.charAt(i);

            if (map.containsKey(c)) {
                final Node node = map.get(c);
                result = internalFind(prefix, node, 1);
                break;
            }
        }
        return result;
    }

    private int internalFind(String prefix, Node node, int index) {
        if(index > prefix.length() - 1) return node.i;
        final char ch = prefix.charAt(index);
        if (index == prefix.length() - 1) {
            if (node.nodes.containsKey(ch)) {
                final Node node1 = node.nodes.get(ch);
                if (node1.ch == ch) {
                    return node1.i;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }

        } else {

            if (node.nodes.containsKey(ch)) {
                return internalFind(prefix, node.nodes.get(ch), ++index);
            } else {
                return 0;
            }
        }
    }

    private void internalAdd(String name) {
        final char c = name.charAt(0);

        if (map.containsKey(c)) {
            final Node node = map.get(c);
            node.i++;
            addNode(name, 1, node);
        } else {
            Node node = new Node();
            map.put(c, node);

            node.ch = c;
            node.i = 1;
            addNode(name, 1, node);
        }
    }

    private void addNode(String name, int index, Node node) {
        if (index > name.length() - 1) {
            return;
        }
        final char c = name.charAt(index);

        if (node.nodes.containsKey(c)) {
            final Node newNode = node.nodes.get(c);
            newNode.i++;
            addNode(name, ++index, newNode);
        } else {
            Node newNode = new Node();
            newNode.ch = c;
            node.nodes.put(c, newNode);
            addNode(name, ++index, newNode);
        }
    }

    static class Node {
        char ch;
        int i = 1;
        HashMap<Character, Node> nodes = new HashMap<>();

    }
}
