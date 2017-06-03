package su.levenetc.playground.java.datastructures;

import java.util.HashMap;
import java.util.Map;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 01/06/2017.
 */
public class ExpressionTree {

    private Map<Type, String> expressions = new HashMap<>();
    private Graph infixGraph;
    private Node root;

    public ExpressionTree() {

    }

    public ExpressionTree(String expression, Type type) {

        expressions.put(type, expression);
        buildTree(expression, type);
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private void buildTree(String expression, Type type) {
        if (type == Type.INFIX) {
            buildInfixGraph(expression);
        }
    }

    private void buildInfixGraph(String expression) {
        infixGraph = new Graph();
        final int length = expression.length();
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);

            if (isOperator(ch)) {

            } else {

            }
        }
    }

    static boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '/' || ch == '*';
    }

    static boolean isOperand(char ch) {
        return !isOperator(ch);
    }

    public void print(Type type) {
        Out.pln();
        if (type == Type.INFIX) {
            printInOrder(root);
        } else if (type == Type.PREFIX) {
            printPreOrder(root);
        } else if (type == Type.POSTFIX) {
            printPostOrder(root);
        }
    }

    private void printPostOrder(Node node) {
        if (node == null) return;
        printPostOrder(node.left);
        printPostOrder(node.right);
        Out.p(node.value);
    }

    private void printPreOrder(Node node) {
        if (node == null) return;
        Out.p(node.value);
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    private void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        Out.p(node.value);
        printInOrder(node.right);
    }

    public enum Type {
        PREFIX, INFIX, POSTFIX;
    }

    public static class Node {

        public char value;
        public Node left;
        public Node right;

        public Node(char value) {
            this.value = value;
        }
    }
}