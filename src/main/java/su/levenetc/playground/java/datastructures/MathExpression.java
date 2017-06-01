package su.levenetc.playground.java.datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 01/06/2017.
 */
public class MathExpression {

    private Map<Type, String> expressions = new HashMap<>();
    private Graph infixGraph;

    public MathExpression(String expression, Type type) {

        expressions.put(type, expression);
        buildTree(expression, type);
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

    enum Type {
        PREFIX, INFIX, POSTFIX;
    }
}