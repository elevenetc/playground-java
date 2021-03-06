package su.levenetc.playground.java.bot.platforms.slack;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import io.reactivex.Single;
import su.levenetc.playground.java.bot.models.Message;
import su.levenetc.playground.java.bot.models.User;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class SlackMoshiParser implements SlackPlatform.MessageParser {

    private Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<BaseMessage> baseMessageAdapter;
    private final JsonAdapter<ReconnectUrl> reconnectUrlAdapter;
    private final JsonAdapter<Msg> messageAdapter;
    private final JsonAdapter<Typing> typingAdapter;
    private final AtomicInteger messageId = new AtomicInteger();

    public SlackMoshiParser() {
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
                msg.id = messageId.incrementAndGet();
                msg.channel = message.getChannelId();
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
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.RECONNECT_URL);
                    result.setText(reconnectUrl.url);
                } else if ("presence_change".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.PRESENCE_CHANGE);
                } else if ("hello".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.HELLO);
                } else if ("user_typing".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.TYPING);
                } else if ("im_marked".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.IM_MARKED);
                } else if ("group_marked".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.GROUP_MARKED);
                } else if ("message".equals(baseMessage.type)) {
                    final Msg msg = messageAdapter.fromJson(rawMessage);
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.MESSAGE);
                    result.setText(msg.text);
                    result.setOwnerId(msg.user);
                    result.setChannelId(msg.channel);
                    result.setOwner(new User(msg.user));
                    result.setTarget(new User(msg.channel));
                } else if ("error".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.ERROR);
                    result.setText(rawMessage);
                } else if ("channel_marked".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.CHANNEL_MARKED);
                } else if ("pref_change".equals(baseMessage.type)) {
                    result = new Message();
                    result.setMessageType(SlackMessageTypes.PRESENCE_CHANGE);
                } else {
                    if (!baseMessage.ok && baseMessage.type == null) {
                        emitter.onError(new RuntimeException("Unknown result type: null. Raw message: " + rawMessage));
                        return;
                    } else if (!baseMessage.ok) {
                        emitter.onError(new RuntimeException("Unknown result type: " + baseMessage.type));
                        return;
                    } else {
                        result = new Message();
                        result.setMessageType(SlackMessageTypes.DELIVERED);
                    }

                }
                emitter.onSuccess(result);
            } catch (IOException e) {
                emitter.onError(e);
            }

        });
    }

    private static class BaseMessage {
        String type;
        boolean ok;
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
        int id;
        double ts;
    }

    private static class Typing {
        String channel;
        String user;
    }
}