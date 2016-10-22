package su.levenetc.playground.java.bot.wws;

import io.reactivex.Observable;
import io.reactivex.Single;
import rx.functions.Action1;
import su.levenetc.playground.java.bot.models.Message;

import javax.websocket.*;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
@ClientEndpoint
public class TyrusSocketClient implements SocketClient {

    private final String url;
    private Action1<Message> messageHandler;
    private Action1<Throwable> errorHandler;

    public TyrusSocketClient(String url) {
        this.url = url;
    }


    @Override
    public Single<Observable<String>> connect(String url) {

        return null;

//        return Single.create(new SingleOnSubscribe<Object>() {
//            @Override
//            public void subscribe(SingleEmitter<Object> e) throws Exception {
//                ClientManager client = ClientManager.createClient();
//
//                try {
//                    client.setAsyncSendTimeout(1000);
//                    final Future<Session> future = client.asyncConnectToServer(this, URI.create(url));
//                    future.get();
//                    e.onSuccess(new Object());
//                } catch (DeploymentException | ExecutionException | InterruptedException ex) {
//                    e.onError(ex);
//                }
//
//
//            }
//        });
    }

    @Override
    public Observable<String> messageObservable() {
        return null;
    }

    @Override
    public void setMessageHandler(Action1<Message> handler) {
        messageHandler = handler;
    }

    @Override
    public void setErrorHandler(Action1<Throwable> handler) {
        errorHandler = handler;
    }

    @Override
    public Single<Object> sendMessage(byte[] message) {
        return null;
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
        if (messageHandler != null) messageHandler.call(null);
    }

    private void handleException(Throwable throwable) {
        if (errorHandler != null) errorHandler.call(throwable);
        else throwable.printStackTrace();
    }

}
