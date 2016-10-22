package su.levenetc.playground.java.bot.wws;

import org.glassfish.tyrus.client.ClientManager;
import rx.functions.Action1;

import javax.websocket.*;
import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
@ClientEndpoint
public class TyrusWWSClient implements WWSClient {

    private final String url;
    private Action1<String> messageHandler;
    private Action1<Throwable> errorHandler;

    public TyrusWWSClient(String url) {
        this.url = url;
    }


    @Override
    public void connect() {
        ClientManager client = ClientManager.createClient();

        try {
            client.setAsyncSendTimeout(1000);
            final Future<Session> future = client.asyncConnectToServer(this, URI.create(url));
            future.get();
        } catch (DeploymentException | ExecutionException | InterruptedException e) {
            handleException(e);
        }
    }

    @Override
    public void setMessageHandler(Action1<String> handler) {
        messageHandler = handler;
    }

    @Override
    public void setErrorHandler(Action1<Throwable> handler) {
        errorHandler = handler;
    }

    @OnOpen
    public void onOpen(Session userSession) {

    }

    @OnClose
    public void onClose(Session userSession, CloseReason reason) {

    }

    @OnError
    public void onError(Throwable throwable) {
        handleException(throwable);
    }

    @OnMessage
    public void onMessage(String message) {
        if (messageHandler != null) messageHandler.call(message);
    }

    private void handleException(Throwable throwable) {
        if (errorHandler != null) errorHandler.call(throwable);
        else throwable.printStackTrace();
    }

}
