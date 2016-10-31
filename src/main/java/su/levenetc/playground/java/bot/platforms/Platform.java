package su.levenetc.playground.java.bot.platforms;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import su.levenetc.playground.java.bot.HellBot;
import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.models.User;
import su.levenetc.playground.java.bot.platforms.slack.InitData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public abstract class Platform {

    private final PublishSubject<Message> messagePublisher = PublishSubject.create();
    private InitData initData;
    private User[] debugUsers;
    private HellBot.Mode mode;

    protected Platform() {

    }

    public abstract Observable<Message> personalMessages();

    public Observable<Message> allMessages() {
        return messagePublisher;
    }

    public abstract Single<InitData> start();

    public abstract Single<List<User>> getUsers();

    public abstract Single<Object> sendPrivateMessageTo(User user, String text);

    public abstract Single<Object> sendMessage(Message.Builder messageBuilder);

    protected void handleParsedMessage(Message message) {
        messagePublisher.onNext(message);
    }

    public void setInitData(InitData initData) {
        this.initData = initData;
    }

    protected InitData getInitData() {
        return initData;
    }

    private Message.Builder createBuilder() {
        final Message.Builder result = new Message.Builder();
        result.setPlatform(this);
        return result;
    }

    public void setDebugUsers(User[] debugUsers) {
        this.debugUsers = debugUsers;
    }

    public void setMode(HellBot.Mode mode) {
        this.mode = mode;
    }

    protected Function<List<User>, List<User>> filterUsers() {
        return users -> {
            if (mode == HellBot.Mode.DEBUG) {
                List<User> result = new ArrayList<>();

                for (User debugUser : debugUsers) {
                    for (User user : users) {
                        if (debugUser.getId().equals(user.getId()))
                            result.add(user);
                    }
                }

                return result;

            } else if (mode == HellBot.Mode.RELEASE) {
                return users;
            } else {
                throw new RuntimeException("Invalid platform mode: " + mode);
            }
        };
    }
}
