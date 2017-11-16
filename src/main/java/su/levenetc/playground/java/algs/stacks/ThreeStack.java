package su.levenetc.playground.java.algs.stacks;

public interface ThreeStack {
    boolean push(int value, int stack);

    int peek(int stack);

    int pop(int stack);

    boolean isEmpty(int stack);

    int size(int stack);
}
