package su.levenetc.playground.java.algs.stacks;

public class TwoStackQueue {

    private Stack back = new Stack();
    private Stack front = new Stack();

    public int size() {
        return front.size() + back.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void enqueue(int value) {
        back.push(value);
    }

    public int dequeue() {
        moveToFront();
        return front.pop();
    }

    public int peek() {
        moveToFront();
        return front.peek();
    }

    private void moveToFront() {
        if (front.isEmpty())
            while (!back.isEmpty())
                front.push(back.pop());
    }
}
