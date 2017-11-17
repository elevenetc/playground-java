package su.levenetc.playground.java.algs.stacks;

public class TwoStackQueue {

    Stack stackFresh = new Stack();
    Stack stackOld = new Stack();

    public int size() {
        return stackOld.size() + stackFresh.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(int value) {
        stackFresh.push(value);
    }

    public int dequeue() {
        moveToOld();
        return stackOld.pop();
    }

    public int peek() {
        moveToOld();
        return stackOld.peek();
    }

    private void moveToOld() {
        if (stackOld.isEmpty())
            while (!stackFresh.isEmpty())
                stackOld.push(stackFresh.pop());
    }
}
