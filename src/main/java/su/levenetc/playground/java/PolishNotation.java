package su.levenetc.playground.java;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by eugene.levenetc on 17/07/2017.
 */
public class PolishNotation {
    public static int evaluateReverse(String... params) {

        Deque<String> stack = new LinkedList<>();

        for (String value : params) {
            if (isOperator(value)) {
                String operator = value;
                String valueB = stack.pop();
                String valueA = stack.pop();
                stack.push(eval(valueA, valueB, operator));
            } else {
                stack.push(value);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    static String eval(String valueA, String valueB, String operator) {
        final int a = Integer.parseInt(valueA);
        final int b = Integer.parseInt(valueB);
        int intResult = 0;
        if (operator.equals("+")) {
            intResult = a + b;
        } else if (operator.equals("-")) {
            intResult = a - b;
        } else if (operator.equals("/")) {
            intResult = a / b;
        } else if (operator.equals("*")) {
            intResult = a * b;
        }

        return String.valueOf(intResult);
    }

    static boolean isOperator(String value) {
        return value.equals("*")
                || value.equals("-")
                || value.equals("+")
                || value.equals("/");
    }
}
