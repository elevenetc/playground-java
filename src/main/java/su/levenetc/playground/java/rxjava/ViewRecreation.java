package su.levenetc.playground.java.rxjava;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import su.levenetc.playground.java.utils.Out;
import su.levenetc.playground.java.utils.ThreadsUtils;

public class ViewRecreation {

    private static Maybe<Object> completedMaybe = Maybe.create(MaybeEmitter::onComplete);


    private ViewModel vm;
    private Disposable sub;

    public void onCreate() {
        Out.pln("onCreate");
        vm = new ViewModel(new Cache(), new Socket());
    }

    public void onResume() {
        Out.pln("onResume");
        sub = vm.messagesObservable().subscribe(this::handleState);
    }

    public void onPause() {
        Out.pln("onPause");
        sub.dispose();
    }

    public void onStop() {
        Out.pln("onStop");

    }

    private void handleState(Object state) {
        Out.pln("updateState", state);
    }

    static class ViewModel {

        private Cache cache;
        private Socket socket;

        private boolean subscribedOnce;

        public ViewModel(Cache cache, Socket socket) {

            this.cache = cache;
            this.socket = socket;
        }

        Observable<Object> messagesObservable() {

            return cache.getMessages().compose(upstream -> {

                if (subscribedOnce) {
                    return completedMaybe;
                } else {
                    subscribedOnce = true;
                    return upstream;
                }

            }).toObservable().concatWith(socket.messagesObservable());
        }
    }

    static class Socket {

        private PublishSubject<Object> stream = PublishSubject.create();

        public Socket() {


            new Thread(new Runnable() {
                @Override
                public void run() {

                    int i = 0;

                    while (true) {
                        stream.onNext("socket-hello: " + i);
                        i++;
                        ThreadsUtils.sleep(1000);
                    }
                }
            }).start();
        }

        Observable<Object> messagesObservable() {
            return stream;
        }
    }

    static class Cache {

        Maybe<Object> getMessages() {
            return Maybe.just(getMessagesSync());
        }

        @NotNull
        private ViewRecreation.MessagesList getMessagesSync() {
            return new MessagesList(
                    //new Message("init - 0"),
                    //new Message("init - 1")
            );
        }


    }

    static class MessagesList {

        List<Message> messages;

        public MessagesList(List<Message> messages) {
            this.messages = messages;
        }

        public MessagesList(Message... messages) {
            this.messages = Arrays.asList(messages);
        }

        public MessagesList() {
            this.messages = new LinkedList<>();
        }

        @Override
        public String toString() {
            return messages.toString();
        }
    }

    static class Message {
        String text;

        public Message(String text) {
            this.text = text;
        }

        public Message() {
            this.text = "";
        }

        @Override
        public String toString() {
            return String.format("{message:%s}", text);
        }
    }
}
