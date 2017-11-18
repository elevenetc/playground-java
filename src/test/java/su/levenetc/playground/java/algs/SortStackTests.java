package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.stacks.Stack;
import su.levenetc.playground.java.utils.Out;

import static su.levenetc.playground.java.algs.stacks.SortStack.sort;

public class SortStackTests {
    @Test
    public void test() {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(5);
        stack.push(25);
        stack.push(0);
        Out.pln(stack);
        Out.pln(sort(stack));
    }
}
