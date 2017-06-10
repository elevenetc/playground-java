package su.levenetc.playground.java.datastructures;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by eugene.levenetc on 01/06/2017.
 */
public class ExpressionTree {

    private Map<Type, String> expressions = new HashMap<>();
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

    public void buildTree(String expression, Type type) {
        if (type == Type.INFIX) {
            buildInfixGraph(expression);
        }
    }

    private void buildInfixGraph(String expression) {
        final int length = expression.length();
        Deque<Node> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = expression.charAt(i);

            if (isOperator(ch)) {
                Node operator = new Node(ch);
                operator.left = stack.pop();
                stack.push(operator);
            } else if (isOperand(ch)) {

                Node operand = new Node(ch);
                if (!stack.isEmpty()) {
                    final Node operator = stack.pop();
                    operator.right = operand;
                    stack.push(operator);
                } else {
                    stack.push(operand);
                }

            } else if (isOpenBracket(ch)) {

            }
        }
        root = stack.pop();
    }

    static Node makeExp(String expression, int index) {
        final char ch = expression.charAt(index);
        if (isOpenBracket(ch)) {
            return makeExp(expression, ++index);
        } else if (isOperand(ch)) {
            int closeIndex = index + 2;
            char close = expression.charAt(closeIndex);
            while (isCloseBracket(close)) {
                closeIndex++;
                close = expression.charAt(closeIndex);
            }
            expression.substring(index, closeIndex);
        }
        return null;
    }

    static boolean isOpenBracket(char ch) {
        return ch == '(';
    }

    static boolean isCloseBracket(char ch) {
        return ch == ')';
    }

    static boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '/' || ch == '*';
    }

    static boolean isLevelOperator(char ch) {
        return ch == '/' || ch == '*';
    }

    static boolean isOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }

    public String toString(Type type) {
        StringBuilder result = new StringBuilder();
        if (type == Type.INFIX) {
            buildInOrder(root, result, 0);
        } else if (type == Type.PREFIX) {
            buildPreOrder(root, result);
        } else if (type == Type.POSTFIX) {
            buildPostOrder(root, result);
        }
        return result.toString();
    }

    private void buildPostOrder(Node node, StringBuilder result) {
        if (node == null) return;
        buildPostOrder(node.left, result);
        buildPostOrder(node.right, result);
        result.append(node.value);
    }

    private void buildPreOrder(Node node, StringBuilder result) {
        if (node == null) return;
        result.append(node.value);
        buildPreOrder(node.left, result);
        buildPreOrder(node.right, result);
    }

    private void buildInOrder(Node node, StringBuilder result, int level) {
        if (node == null) return;

        if (isLevelOperator(node.value)) {
            level++;
            result.append('(');
        }

        buildInOrder(node.left, result, level);

        if (isLevelOperator(node.value)) {
            result.append(')');
        }

        result.append(node.value);

        buildInOrder(node.right, result, level);
    }

    public Node getRoot() {
        return root;
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

        @Override
        public String toString() {
            return String.format("(%c)", value);
        }
    }
}