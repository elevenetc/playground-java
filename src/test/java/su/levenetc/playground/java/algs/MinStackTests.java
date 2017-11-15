package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.stacks.MinStack;

import static org.junit.Assert.assertEquals;

public class MinStackTests {
    @Test
    public void test() {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        assertEquals(1, stack.min());
        stack.push(-1);
        assertEquals(-1, stack.min());
        stack.push(10);
        stack.push(100);
        assertEquals(-1, stack.min());
        stack.pop();
        assertEquals(-1, stack.min());
        stack.pop();
        stack.pop();
        assertEquals(1, stack.min());
    }
}
