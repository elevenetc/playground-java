package su.levenetc.playground.java.algs;

import java.util.LinkedList;

public class ReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        LinkedList<Integer> numbers = new LinkedList<>();

        for (String token : tokens) {

            if (isNumber(token)) {
                int n = Integer.valueOf(token);
                numbers.push(n);
            } else {
                int n1 = numbers.pop();
                int n2 = numbers.pop();
                int result;

                if (token.equals("+")) {
                    result = n1 + n2;
                } else if (token.equals("-")) {
                    result = n2 - n1;
                } else if (token.equals("*")) {
                    result = n1 * n2;
                } else {
                    result = n2 / n1;
                }

                numbers.push(result);
            }
        }

        return numbers.get(0);
    }

    static boolean isNumber(String s) {
        if (s.length() > 1) {
            return true;
        } else {
            return s.charAt(0) >= '0' && s.charAt(0) <= '9';
        }
    }
}
