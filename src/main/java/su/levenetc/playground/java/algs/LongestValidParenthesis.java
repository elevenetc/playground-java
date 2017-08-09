package su.levenetc.playground.java.algs;

import java.util.Deque;
import java.util.LinkedList;

public class LongestValidParenthesis {

    public static int get(String value) {

        Deque<Bracket> brackets = new LinkedList<>();
        int result = 0;

        for (int i = 0; i <= value.length() - 1; i++) {
            char c = value.charAt(i);
            if (c == '(') {

                brackets.push(new Bracket(i, true));

            } else {
                if (brackets.isEmpty() || brackets.peek().isClosed()) {

                    brackets.push(new Bracket(i, false));

                } else {

                    brackets.pop();
                    int currentLen;

                    if (brackets.isEmpty()) {
                        currentLen = i + 1;
                    } else {
                        currentLen = i - brackets.peek().index;
                    }

                    result = Math.max(result, currentLen);
                }
            }
        }

        return result;
    }

    static class Bracket {

        int index;
        boolean open;

        Bracket(int index, boolean open) {
            this.index = index;
            this.open = open;
        }

        boolean isClosed() {
            return !open;
        }
    }
}