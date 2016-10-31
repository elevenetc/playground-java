package su.levenetc.playground.java.bot.wws;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import okhttp3.*;
import okhttp3.ws.WebSocket;
import okhttp3.ws.WebSocketCall;
import okhttp3.ws.WebSocketListener;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import rx.functions.Action1;
import su.levenetc.playground.java.bot.models.Message;

import java.io.IOException;
import java.io.Reader;
import java.util.concurrent.TimeUnit;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class OkHttpSocketClient implements SocketClient {

    private final StringBuilder stringBuilder = new StringBuilder();
    private final char[] charBuffer = new char[1024];
    private PublishSubject<String> messagePublisher = PublishSubject.create();
    private WebSocket webSocket;

    public OkHttpSocketClient() {

    }

    @Override
    public Single<Observable<String>> connect(String url) {

        return Single.create(emitter -> {
            try {
                WebSocketCall.create(
                        buildClient(),
                        new Request.Builder().url(url).build()
                ).enqueue(new WebSocketListener() {
                    @Override
                    public void onOpen(WebSocket webSocket, Response response) {
                        OkHttpSocketClient.this.webSocket = webSocket;
                        emitter.onSuccess(messagePublisher);
                    }

                    @Override
                    public void onFailure(IOException e, Response response) {

                    }

                    @Override
                    public void onMessage(ResponseBody message) throws IOException {
                        stringBuilder.setLength(0);
                        final Reader reader = message.charStream();
                        int numChars;
                        while ((numChars = reader.read(charBuffer)) >= 0) {
                            stringBuilder.append(charBuffer, 0, numChars);
                        }
                        message.close();
                        messagePublisher.onNext(stringBuilder.toString());
                    }

                    @Override
                    public void onPong(Buffer payload) {

                    }

                    @Override
                    public void onClose(int code, String reason) {

                    }
                });

            } catch (Exception e1) {
                emitter.onError(e1);
            }
        });
    }

    @Override
    public Observable<String> messageObservable() {
        return messagePublisher;
    }

    @NotNull
    private OkHttpClient buildClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(0, TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        return builder.build();
    }

    @Override
    public void setMessageHandler(Action1<Message> handler) {

    }

    @Override
    public void setErrorHandler(Action1<Throwable> handler) {

    }

    @Override
    public Single<Object> sendMessage(byte[] message) {
        return Single.create(emitter -> {
            try {
                webSocket.sendMessage(FormBody.create(WebSocket.TEXT, message));
                emitter.onSuccess(new Object());
            } catch (IOException e) {
                emitter.onError(e);
            }
        });
    }
}
