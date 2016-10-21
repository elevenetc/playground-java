import org.junit.Test;
import rx.Observable;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by eleven on 02/10/2016.
 */
public class RxTests {
	@Test public void testUnsubHandler() {

		Action0 action = mock(Action0.class);

		Observable.create(subscriber -> {
			subscriber.onNext(new Object());
			subscriber.add(Subscriptions.create(action));
		}).subscribe().unsubscribe();

		verify(action).call();
	}
}
