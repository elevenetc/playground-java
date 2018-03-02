package su.levenetc.playground.java.utils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderedExecutor implements Executor {

    private final Thread thread;
    private final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private volatile boolean isEnabled = true;

    public OrderedExecutor() {
        thread = new Thread(() -> {
            while (isEnabled) {
                try {
                    ThreadUtils.sleep(1000);
                    queue.take().run();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public void execute(Runnable runnable) {
        queue.add(runnable);
    }

    public void shutdown() {
        isEnabled = false;
    }
}
