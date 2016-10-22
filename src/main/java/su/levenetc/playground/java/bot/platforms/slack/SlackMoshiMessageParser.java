package su.levenetc.playground.java.bot.platforms.slack;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.models.User;

import java.io.IOException;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class SlackMoshiMessageParser implements SlackPlatform.MessageParser {

    private Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<BaseMessage> baseMessageAdapter;
    private final JsonAdapter<ReconnectUrl> reconnectUrlAdapter;
    private final JsonAdapter<Msg> messageAdapter;
    private final JsonAdapter<Typing> typingAdapter;

    public SlackMoshiMessageParser() {
        baseMessageAdapter = moshi.adapter(BaseMessage.class);
        reconnectUrlAdapter = moshi.adapter(ReconnectUrl.class);
        messageAdapter = moshi.adapter(Msg.class);
        typingAdapter = moshi.adapter(Typing.class);
    }

    @Override
    public Single<byte[]> toByte(Message message) {
        return Single.create(emitter -> {
            try {
                Msg msg = new Msg();
                msg.channel = message.getTarget().getId();
                msg.text = message.getMessage();
                msg.type = "message";
                final String result = messageAdapter.toJson(msg);
                emitter.onSuccess(result.getBytes());
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }

    @Override
    public Single<Message> parse(String rawMessage) {
        return Single.create(emitter -> {
            Message result;

            try {
                final BaseMessage baseMessage = baseMessageAdapter.fromJson(rawMessage);
                if ("reconnect_url".equals(baseMessage.type)) {
                    final ReconnectUrl reconnectUrl = reconnectUrlAdapter.fromJson(rawMessage);
                    result = new Message(SlackMessageTypes.RECONNECT_URL);
                    result.setMessage(reconnectUrl.url);
                } else if ("presence_change".equals(baseMessage.type)) {
                    result = new Message(SlackMessageTypes.PRESENCE_CHANGE);
                } else if ("hello".equals(baseMessage.type)) {
                    result = new Message(SlackMessageTypes.HELLO);
                } else if ("user_typing".equals(baseMessage.type)) {
                    result = new Message(SlackMessageTypes.TYPING);
                } else if ("message".equals(baseMessage.type)) {
                    final Msg msg = messageAdapter.fromJson(rawMessage);
                    result = new Message(SlackMessageTypes.MESSAGE);
                    result.setMessage(msg.text);
                    result.setOwner(new User(msg.user));
                    result.setTarget(new User(msg.channel));
                } else {
                    emitter.onError(new RuntimeException("Unknown result type: " + baseMessage.type));
                    return;
                }
                emitter.onSuccess(result);
            } catch (IOException e) {
                emitter.onError(e);
            }

        });
    }

    private static class BaseMessage {
        String type;
    }

    private static class ReconnectUrl {
        String url;
    }

    private static class Msg {
        String channel;
        String user;
        String text;
        String team;
        String type;
        double ts;
    }

    private static class Typing {
        String channel;
        String user;
    }
}