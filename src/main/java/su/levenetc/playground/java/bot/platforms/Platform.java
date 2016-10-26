package su.levenetc.playground.java.bot.platforms;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.models.User;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public abstract class Platform {

    private final PublishSubject<Message> messagePublisher = PublishSubject.create();

    public Platform() {

    }

    public Observable<Message> getMessageObservable() {
        return messagePublisher;
    }

    public abstract Single<Object> start();

    public abstract Observable<User> loadUsers();

    public abstract Single<Object> sendMessage(Message message);

    protected void handleParsedMessage(Message message) {
        messagePublisher.onNext(message);
    }

}
