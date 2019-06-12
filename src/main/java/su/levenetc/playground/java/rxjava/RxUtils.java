package su.levenetc.playground.java.rxjava;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadUtils;

public class RxUtils {

    public static Observable<String> list(String... i) {
        return list(0, i);
    }

    public static Observable<String> list(long delay, String... i) {
        return Observable.create(e -> {
            for (String n : i) {

                ThreadUtils.sleep(delay);

                if (!e.isDisposed()) {

                    Out.plnCurrentThread("emitting", n);
                    e.onNext(n);
                }
            }
            if (!e.isDisposed()) e.onComplete();

        });
    }

    public static Observable<Integer> obs(int s) {
        return Observable.just(s);
    }

    public static Observable<String> obs(String s) {
        return Observable.just(s);
    }

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

    public static void printLong(Observable<Long> observable) {
        print(observable.map(aLong -> aLong));
    }

    public static void printString(Observable<String> observable) {
        print(observable.map(o -> o));
    }

    public static void print(Maybe<Integer> observable) {
        print(observable.toObservable().cast(Object.class));
    }

    public static void print(Observable<Object> observable) {
        observable
                .doOnSubscribe(disposable -> Out.pln("doOnSubscribe"))
                .subscribe(
                        o -> Out.plnCurrentThread("onNext", o),
                        throwable -> Out.plnCurrentThread("onError", throwable),
                        () -> Out.plnCurrentThread("complete")
                );
    }

    public static Observable<Object> longRunning(long time) {
        return Observable.fromCallable(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                ThreadUtils.sleep(time);
                return "long-running-" + time;
            }
        }).subscribeOn(Schedulers.io());
    }

    public static void printInt(Observable<Integer> scan) {
        print(scan.cast(Object.class));
    }
}
