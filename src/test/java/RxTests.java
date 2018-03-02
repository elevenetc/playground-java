import org.junit.Test;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import su.levenetc.playground.java.rxjava.LongRunningAction;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadUtils;

/**
 * Created by eleven on 02/10/2016.
 */
public class RxTests {
    @Test
    public void testUnsubHandler() {

//        Action0 action = mock(Action0.class);
//
//        Observable.create(subscriber -> {
//            subscriber.onNext(new Object());
//            subscriber.add(Subscriptions.create(action));
//        }).subscribe().unsubscribe();
//
//        verify(action).call();
    }

    @Test
    public void testMultiThreadPublish() {
        PublishSubject<String> observable = PublishSubject.create();

        observable
                .observeOn(ThreadUtils.createScheduler("Thread:A"))
                .subscribe(s -> {
                    Out.pln("Consumer:A:start:" + s);
                    Out.plnCurrentThread();
                    Out.pln("Consumer:A:end:" + s);
                });

        observable
                .observeOn(ThreadUtils.createScheduler("Thread:B"))
                .subscribe(s -> {
                    Out.pln("Consumer:B:start:" + s);
                    Out.plnCurrentThread();
                    Out.pln("Consumer:B:end:" + s);
                });

        new Thread(() -> observable.onNext("X"), "ProducerThread").start();


        ThreadUtils.sleep(500);
    }

    @Test
    public void testHotCompletable() {

        final Completable completable = Completable
                .fromAction(LongRunningAction.create())
                .subscribeOn(Schedulers.io())
                .cache();

        completable.subscribe(() -> Out.pln("Sub-A"));
        final Disposable sub = completable.subscribe(() -> Out.pln("Sub-B"));
        sub.dispose();

        ThreadUtils.sleep(1500);

        completable.subscribe(() -> Out.pln("Sub-C"));
    }

    @Test
    public void testIfCompletableCanceled() {
        final Disposable sub = Completable.fromAction(new LongRunningAction())
                .doOnTerminate(() -> Out.pln("on terminate"))
                .subscribe(() -> Out.pln("complete"));
        sub.dispose();
    }

    @Test
    public void minMerge() {
        final Observable<Float> obsA = Observable.create(subscriber -> {
            Out.pln("init fast");
            int i = 0;
            while (i != 10) {
                i++;
                ThreadUtils.sleep(100);
                Out.pln("fast:" + i);
                subscriber.onNext((float) i);
            }
            subscriber.onComplete();
        });

        final Observable<Float> obsB = Observable.create(subscriber -> {
            Out.pln("init slow");
            int i = 0;
            while (i != 10) {
                i++;
                ThreadUtils.sleep(1000);
                Out.pln("slow:" + i);
                subscriber.onNext((float) i);
            }
            subscriber.onComplete();
        });

        Observable.merge(obsB, obsA)
                .subscribeOn(Schedulers.computation())
                .subscribe(new Consumer<Float>() {
                    @Override
                    public void accept(Float aFloat) {
                        Out.pln("result:" + aFloat);
                    }
                });

        ThreadUtils.sleep(3 * 1000);
    }

    @Test
    public void minZip() {

        final Observable<Float> obsA = Observable.create(subscriber -> {
            Out.pln("init fast");
            int i = 0;
            while (i != 10) {
                i++;
                ThreadUtils.sleep(100);
                Out.pln("fast:" + i);
                subscriber.onNext((float) i);
            }
            subscriber.onComplete();
        });

        final Observable<Float> obsB = Observable.create(subscriber -> {
            Out.pln("init slow");
            int i = 0;
            while (i != 10) {
                i++;
                ThreadUtils.sleep(1000);
                Out.pln("slow:" + i);
                subscriber.onNext((float) i);
            }
            subscriber.onComplete();
        });

        Observable
                .zip(obsA, obsB, new BiFunction<Float, Float, Float>() {
                    @Override
                    public Float apply(Float aFloat, Float bFloat) {
                        Out.pln("compare: a:" + aFloat + ", b:" + bFloat);
                        return Math.min(aFloat, bFloat);
                    }
                })
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<Float>() {
                    @Override
                    public void accept(Float progress) {
                        Out.pln(progress);
                    }
                });

        ThreadUtils.sleep(3 * 1000);
    }
}
