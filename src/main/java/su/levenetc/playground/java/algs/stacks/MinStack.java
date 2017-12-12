package su.levenetc.playground.java.algs.stacks;

public class MinStack extends Stack {

    Stack minStack = new Stack();

    @Override
    public void push(int value) {
        if (value <= min()) {
            minStack.push(value);
        }
        super.push(value);
    }

    @Override
    public int pop() {
        int result = super.pop();

        if (result == min()) {
            minStack.pop();
        }

        return result;
    }

    public int min() {
        if (minStack.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return minStack.peek();
        }
    }
}
