package su.levenetc.playground.java.bot.wws;

import rx.functions.Action1;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public interface WWSClient {
    void connect();

    void setMessageHandler(Action1<String> handler);

    void setErrorHandler(Action1<Throwable> handler);
}
