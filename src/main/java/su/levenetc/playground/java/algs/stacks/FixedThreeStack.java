package su.levenetc.playground.java.algs.stacks;

public class FixedThreeStack implements ThreeStack {

    private int[] data;
    private int[] pointers;
    private int capacity;

    public FixedThreeStack() {
        this(9);
    }

    public FixedThreeStack(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        pointers = new int[3];
        pointers[0] = -1;
        pointers[1] = -1;
        pointers[2] = -1;
    }

    @Override
    public boolean push(int value, int stack) {
        int pointer = pointers[stack];
        if (pointer == maxIndex(stack)) {
            return false;
        } else if (pointer == maxIndex(stack)) {
            return false;
        } else if (pointer == -1) {
            pointers[stack] = minIndex(stack);
            data[pointers[stack]] = value;
            return true;
        } else {
            pointers[stack]++;
            data[pointers[stack]] = value;
            return true;
        }
    }

    @Override
    public int peek(int stack) {
        return data[pointers[stack]];
    }

    @Override
    public int pop(int stack) {
        int pointer = pointers[stack];
        if (pointer == -1) {
            throw new RuntimeException();
        } else if (pointer == minIndex(stack)) {
            int value = data[pointer];
            pointers[stack] = -1;
            return value;
        } else {
            int value = data[pointer];
            pointers[stack]--;
            return value;
        }
    }

    @Override
    public boolean isEmpty(int stack) {
        return pointers[stack] == -1;
    }

    @Override
    public int size(int stack) {
        if (pointers[stack] == -1) {
            return 0;
        } else {
            return pointers[stack] - minIndex(stack) + 1;
        }
    }

    private int maxIndex(int stack) {
        int partSize = capacity / pointers.length;
        return minIndex(stack) + (partSize - 1);
    }

    private int minIndex(int stack) {
        int partSize = capacity / pointers.length;
        return partSize * stack;
    }
}
