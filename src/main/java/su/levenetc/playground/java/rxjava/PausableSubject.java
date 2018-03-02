package su.levenetc.playground.java.rxjava;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import su.levenetc.playground.java.utils.Out;

public class PausableSubject {

    PublishSubject<String> subject = PublishSubject.create();
    boolean paused;
    private Disposable sub;

    public PausableSubject() {
        Observable<String> obs = subject.doOnSubscribe(new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) {

            }
        });

        Observable.fromArray("a", "b").zipWith(Observable.interval(1, TimeUnit.SECONDS), new BiFunction<String, Long, String>() {
            @Override
            public String apply(String s, Long aLong) {
                return s;
            }
        });
    }

    public void onResume() {
        sub = subject.subscribe(state -> Out.pln("state", state));
    }

    public void onPause() {
        sub.dispose();
    }

    public Observable<String> state() {
        return subject.doOnDispose(new Action() {
            @Override
            public void run() {
                paused = true;
            }
        });
    }
}
