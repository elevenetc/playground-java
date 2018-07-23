package su.levenetc.playground.java.datastructures;

public class CircularQueue {

    private final int[] array;
    private int front = -1;
    private int end = -1;
    private int size = 0;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public CircularQueue(int k) {
        array = new int[k];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {

        if (isFull()) return false;


        if (isEmpty()) {
            size++;
            front = 0;
            end = 0;
            array[end] = value;
        } else {
            size++;
            checkAndEnqueue(value);
        }

        return true;
    }

    private void checkAndEnqueue(int value) {
        if (end == array.length - 1) {
            end = 0;
        } else {
            end++;
        }
        array[end] = value;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            size--;
            checkAndDequeue();
            return true;
        }
    }

    private void checkAndDequeue() {

        if (front == array.length - 1) {
            front = 0;
        } else {
            front++;
        }
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) return -1;
        return array[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) return -1;
        else return array[end];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return size == array.length;
    }

    @Override
    public String toString() {

        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder();
        int f = front;
        int s = size;

        sb.append('[');

        while (s > 0) {

            sb.append(array[f]);
            f++;
            s--;

            if (f == array.length) {
                f = 0;
            }

            if (s > 0) {
                sb.append(',');
            }
        }

        sb.append(']');

        return sb.toString();
    }
}
