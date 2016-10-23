package su.levenetc.playground.java.utils;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.Executors;

/**
 * Created by elevenetc on 04/07/15.
 */
public class ThreadsUtils {

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
