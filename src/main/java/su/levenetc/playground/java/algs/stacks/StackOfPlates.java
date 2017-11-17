package su.levenetc.playground.java.algs.stacks;

import java.util.Deque;
import java.util.LinkedList;

public class StackOfPlates {

    LinkedList<Deque<Integer>> stacks = new LinkedList<>();
    private final int threshold;

    public StackOfPlates(int threshold) {

        this.threshold = threshold;
    }

    public int stacksSize() {
        return stacks.size();
    }

    public int sizeOf(int index) {
        return stacks.get(index).size();
    }

    public int popAt(int index) {
        if (index == stacks.size() - 1) return pop();

        Deque<Integer> stack = stacks.get(index);
        int result = stack.pop();


        Deque<Integer> lastStack = stacks.get(stacks.size() - 1);
        int polled = lastStack.removeLast();
        int i = stacks.size() - 2;

        while (i >= index) {

            if (i == index) {
                stack.push(polled);
            } else {
                Deque<Integer> st = stacks.get(i);
                int tmpPolled = st.removeLast();
                st.push(polled);
                polled = tmpPolled;
            }


            i--;
        }

        return result;
    }

    public void push(int value) {
        if (stacks.isEmpty()) {
            addNewStack(value);
        } else {
            Deque<Integer> last = stacks.get(stacks.size() - 1);
            if (last.size() == threshold) {
                addNewStack(value);
            } else {
                last.push(value);
            }
        }
    }

    public int pop() {
        Deque<Integer> lastStack = stacks.get(stacks.size() - 1);
        int value = lastStack.pop();

        if (lastStack.isEmpty()) {
            stacks.removeLast();
        }

        return value;
    }

    private void addNewStack(int value) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(value);
        stacks.add(stack);
    }
}
