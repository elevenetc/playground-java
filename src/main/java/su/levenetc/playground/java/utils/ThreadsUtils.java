package su.levenetc.playground.java.utils;

import java.util.concurrent.Executors;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by elevenetc on 04/07/15.
 */
public class ThreadsUtils {

    public static Thread runContinuous(Runnable task, String name) {
        return runContinuous(task, name, -1);
    }

    public static Thread runContinuous(Runnable task, String name, long delay) {
        Thread thread = new Thread(() -> {
            while (true) {
                if (delay > 0) ThreadsUtils.sleep(delay);
                task.run();
            }
        }, name);
        thread.start();
        return thread;
    }

    public static void run(Runnable task) {
        new Thread(task).start();
    }

    public static Scheduler createScheduler(String name) {
        return Schedulers.from(Executors.newSingleThreadExecutor(runnable -> new Thread(runnable, name)));
    }

    public static void sleepA() {
        sleep(1000);
    }

    public static void sleepB() {
        sleep(2000);
    }

    public static void sleepC() {
        sleep(3000);
    }

    public static void sleepForever() {
        sleep(Long.MAX_VALUE);
    }

    public static void sleep(long ms) {
        sleep(ms, null);
    }

    public static void sleep(long ms, DoOnWakeup handler) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }

        if (handler != null) handler.wakeupHandler();
    }


    public static void startNonDemonThread(long ms) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                sleep(ms);
            }
        }).start();
    }
}
