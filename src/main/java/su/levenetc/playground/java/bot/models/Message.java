package su.levenetc.playground.java.bot.models;

import su.levenetc.playground.java.bot.platforms.Platform;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class Message {

    private int messageType;
    private String message;
    private MessageTarget target;
    private User owner;
    private boolean isDirect;

    private String ownerId;
    private String channelId;

    public Message() {

    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getTargetId() {
        return target.getId();
    }

    public String getOwnerId() {
        return owner.getId();
    }

    public boolean isDirect() {
        return isDirect;
    }

    public void setDirect(boolean direct) {
        isDirect = direct;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTarget(MessageTarget target) {
        this.target = target;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }

    public MessageTarget getTarget() {
        return target;
    }

    public Message respond(String text) {
        Message result = new Message();
        result.setTarget(owner);
        result.setMessage(text);
        return result;
    }

    public static class Builder {

        private Message message;
        private Platform platform;

        public void respondTo(Message message) {
            this.message = message;
        }

        public void channelId(String channelId) {

        }

        public void with(String text) {
            Message message = new Message();
            message.setChannelId(this.message.channelId);
            message.setMessage(text);
            platform.sendMessage(message).subscribe();
        }

        public void setPlatform(Platform platform) {
            this.platform = platform;
        }
    }
}
