package su.levenetc.playground.java.rxjava;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import org.jetbrains.annotations.NotNull;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadUtils;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class RxUtils {

    public static Scheduler scheduler(String name) {
        return Schedulers.from(Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, name)));
    }

    public static Action error() {
        return makeLogAction("error");
    }

    public static Action complete() {
        return complete("completed");
    }

    public static Consumer<String> completeString(String value) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                Out.pln(value);
            }
        };
    }

    public static Consumer<String> completeString() {
        return s -> Out.plnCurrentThread(s);
    }


    public static Consumer<String> completeError(String value) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                throw new RuntimeException(value);
            }
        };
    }


    public static Consumer<String> completeError(Throwable t) {
        return new Consumer<String>() {
            @Override
            public void accept(String s) {
                throw new RuntimeException(t);
            }
        };
    }

    public static Action complete(String value) {
        return makeLogAction(value);
    }

    public static Consumer<Throwable> logError() {
        return new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
                Out.pln("error");
            }
        };
    }

    @NotNull
    private static Action makeLogAction(String message) {
        return () -> Out.pln(message);
    }


    public static Observable<Integer> computeSum(int a, int b) {
        return Observable.fromCallable(new Callable<Integer>() {
            @Override
            public Integer call() {
                ThreadUtils.sleep(1000);
                return a + b;
            }
        });
    }
}
