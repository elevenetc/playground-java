package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

import java.util.LinkedList;

/**
 * Created by eugene.levenetc on 09/03/2017.
 */
public class Brackets {

    private LinkedList<Character> stack = new LinkedList<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public boolean add(char bracket) {

        boolean open = bracket == '{' || bracket == '(' || bracket == '[';

        if (open) {
            stack.add(bracket);
            return true;
        } else {

            if (!stack.isEmpty()) {
                final char popped = stack.removeLast();
                if (bracket == '}' && popped == '{') {
                    return true;
                } else if (bracket == ')' && popped == '(') {
                    return true;
                } else if (bracket == ']' && popped == '[') {
                    return true;
                }
            }

            Out.pln("Not balanced!");
            return false;
        }
    }
}