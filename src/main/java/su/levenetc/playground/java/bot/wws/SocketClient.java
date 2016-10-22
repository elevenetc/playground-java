package su.levenetc.playground.java.bot.wws;

import io.reactivex.Observable;
import io.reactivex.Single;
import rx.functions.Action1;
import su.levenetc.playground.java.bot.models.Message;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public interface SocketClient {

    Single<Observable<String>> connect(String url);

    Observable<String> messageObservable();

    void setMessageHandler(Action1<Message> handler);

    void setErrorHandler(Action1<Throwable> handler);

    Single<Object> sendMessage(byte[] message);

    interface Factory {
        SocketClient create(String url);
    }
}
