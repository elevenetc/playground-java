package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.stacks.FixedThreeStack;
import su.levenetc.playground.java.algs.stacks.ThreeStack;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ThreeStackTests {
    @Test
    public void test() {
        ThreeStack stack = new FixedThreeStack();

        assertTrue(stack.isEmpty(0));
        assertTrue(stack.isEmpty(1));
        assertTrue(stack.isEmpty(2));

        assertEquals(0, stack.size(0));
        assertEquals(0, stack.size(1));
        assertEquals(0, stack.size(2));

        stack.push(0, 0);
        stack.push(10, 1);
        stack.push(100, 2);

        assertEquals(1, stack.size(0));
        assertEquals(1, stack.size(1));
        assertEquals(1, stack.size(2));

        assertEquals(0, stack.peek(0));
        assertEquals(10, stack.peek(1));
        assertEquals(100, stack.peek(2));

        stack.push(1, 0);
        stack.push(11, 1);
        stack.push(101, 2);

        assertEquals(2, stack.size(0));
        assertEquals(2, stack.size(1));
        assertEquals(2, stack.size(2));

        assertEquals(1, stack.pop(0));
        assertEquals(11, stack.pop(1));
        assertEquals(101, stack.pop(2));

        assertEquals(1, stack.size(0));
        assertEquals(1, stack.size(1));
        assertEquals(1, stack.size(2));
    }
}
