package su.levenetc.playground.java.rxjava;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.concurrent.Executors;

/**
 * Created by eugene.levenetc on 14/03/2017.
 */
public class SubScheduler {

    final static Scheduler realmSch = getScheduler("realm");
    final static Scheduler backgroundSch = getScheduler("background");
    final static Scheduler uiSch = getScheduler("ui");

    public static void run() {

        getIntFromDB()
                .observeOn(backgroundSch)
                .doOnNext(new Action1<SomeObj>() {
                    @Override
                    public void call(SomeObj obj) {
                        printThread("doOnNext");
                        obj.value = 100;
                    }
                })
                .observeOn(uiSch)
                .subscribe(new Action1<SomeObj>() {
                    @Override
                    public void call(SomeObj obj) {
                        printThread("complete");
                    }
                });
    }

    private static Observable<SomeObj> getIntFromDB() {
        return Observable.create(new Observable.OnSubscribe<SomeObj>() {
            @Override
            public void call(Subscriber<? super SomeObj> subscriber) {
                printThread("realm");
                subscriber.onNext(new SomeObj());
                subscriber.onCompleted();
            }
        }).subscribeOn(realmSch);
    }

    private static Scheduler getScheduler(String name) {
        return Schedulers.from(Executors.newSingleThreadExecutor(r -> {
            final Thread thread = new Thread(r, name);
            thread.setDaemon(false);
            return thread;
        }));
    }

    private static void printThread(String place) {
        System.out.println("place: " + place + ", thread: " + Thread.currentThread().getName());
    }

    private static class SomeObj {
        private int value = 10;
    }
}
