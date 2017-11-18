package su.levenetc.playground.java.algs.stacks;

public class SortStack {
    public static Stack sort(Stack stack) {
        Stack tmp = new Stack();

        while (!stack.isEmpty()) {
            int value = stack.pop();

            while (!tmp.isEmpty() && tmp.peek() > value)
                stack.push(tmp.pop());

            tmp.push(value);
        }

        while (!tmp.isEmpty()) stack.push(tmp.pop());
        return stack;
    }
}
