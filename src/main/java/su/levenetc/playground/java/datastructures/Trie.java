package su.levenetc.playground.java.datastructures;

public class Trie {

    Node root = new Node((char) 0, true);

    public void add(String s) {
        if (s.isEmpty()) return;

        Node n = root;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            int chIndex = ch - 'a';
            boolean isLast = i == s.length() - 1;

            if (n.children[chIndex] == null) {
                n.children[chIndex] = new Node(ch, isLast);
                n = n.children[chIndex];
            } else {
                if (isLast) {
                    n.children[chIndex].isWord = true;
                } else {
                    n = n.children[chIndex];
                }
            }
        }
    }

    public boolean contains(String s) {
        return contains(s, true);
    }

    public boolean startsWith(String s) {
        return contains(s, false);
    }

    private boolean contains(String s, boolean fullWord) {
        if (s.isEmpty()) return true;
        if (root.children[s.charAt(0) - 'a'] == null) return false;

        Node n = root.children[s.charAt(0) - 'a'];

        for (int i = 1; i < s.length(); i++) {

            char ch = s.charAt(i);
            int charIndex = ch - 'a';
            boolean isLast = i == s.length() - 1;

            if (n.children[charIndex] == null) {
                return false;
            } else {
                n = n.children[charIndex];
            }
        }

        return !fullWord || n.isWord;
    }

    static class Node {

        char ch;
        Node[] children = new Node[26];
        boolean isWord;

        public Node(char ch, boolean isWord) {
            this.ch = ch;
            this.isWord = isWord;
        }

        @Override
        public String toString() {
            return "{" + ch + '}';
        }
    }
}
