package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParenthesis {
    public static boolean isValid(String s) {

        int i = 0;
        Deque<Character> stack = new LinkedList<>();

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (stack.isEmpty()) {
                if (isClosing(ch)) return false;
                stack.push(ch);
            } else {
                if (isOpening(ch)) {
                    stack.push(ch);
                } else {
                    char opening = stack.pop();
                    if (!match(opening, ch)) return false;
                }
            }

            i++;
        }

        return stack.isEmpty();
    }

    static boolean match(char opening, char closing) {
        return opening == '(' && closing == ')'
                || opening == '{' && closing == '}'
                || opening == '[' && closing == ']';
    }

    static boolean isClosing(char ch) {
        return !isOpening(ch);
    }

    static boolean isOpening(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }
}
