package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.stacks.StackOfPlates;

import static org.junit.Assert.assertEquals;

public class StackOfPlatesTests {
    @Test
    public void test() {
        StackOfPlates stack = new StackOfPlates(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        assertEquals(3, stack.stacksSize());
        assertEquals(3, stack.popAt(0));
        assertEquals(4, stack.popAt(0));

        assertEquals(3, stack.sizeOf(0));
        assertEquals(3, stack.sizeOf(1));
        assertEquals(1, stack.sizeOf(2));
    }
}