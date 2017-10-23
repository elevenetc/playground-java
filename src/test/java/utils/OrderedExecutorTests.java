package utils;

import org.junit.Test;

import su.levenetc.playground.java.utils.OrderedExecutor;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class OrderedExecutorTests {
    @Test
    public void test() {
        OrderedExecutor executor = new OrderedExecutor();
        executor.execute(() -> Out.pln("hello-1"));
        executor.execute(() -> Out.pln("hello-2"));

        ThreadsUtils.sleep(5000);
    }
}
