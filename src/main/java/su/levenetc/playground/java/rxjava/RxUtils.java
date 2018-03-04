package su.levenetc.playground.java.rxjava;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import su.levenetc.playground.java.utils.ThreadUtils;

public class RxUtils {
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
