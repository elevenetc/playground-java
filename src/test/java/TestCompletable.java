import org.junit.Test;
import rx.Completable;
import rx.Observable;

/**
 * Created by eugene.levenetc on 07/10/16.
 */
public class TestCompletable {
    @Test
    public void testOnError() {
        //Completable.fromObservable(Observable.error(new RuntimeException("X"))).subscribe();
        Completable.fromObservable(Observable.just("X")).subscribe();
    }
}
