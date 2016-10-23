import io.reactivex.subjects.PublishSubject;
import org.junit.Test;
import rx.Observable;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleven on 02/10/2016.
 */
public class RxTests {
    @Test
    public void testUnsubHandler() {

        Action0 action = mock(Action0.class);

        Observable.create(subscriber -> {
            subscriber.onNext(new Object());
            subscriber.add(Subscriptions.create(action));
        }).subscribe().unsubscribe();

        verify(action).call();
    }

    @Test
    public void testMultiThreadPublish() {
        PublishSubject<String> observable = PublishSubject.create();

        observable
                .observeOn(ThreadsUtils.createScheduler("Thread:A"))
                .subscribe(s -> {
                    Out.pln("Consumer:A:start:" + s);
                    Out.plnCurrentThread();
                    Out.pln("Consumer:A:end:" + s);
                });

        observable
                .observeOn(ThreadsUtils.createScheduler("Thread:B"))
                .subscribe(s -> {
                    Out.pln("Consumer:B:start:" + s);
                    Out.plnCurrentThread();
                    Out.pln("Consumer:B:end:" + s);
                });

        new Thread(() -> observable.onNext("X"), "ProducerThread").start();


        ThreadsUtils.sleep(500);
    }
}