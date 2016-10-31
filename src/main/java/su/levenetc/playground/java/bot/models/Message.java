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

    public static Message message(String text) {
        final Message result = new Message();
        result.setText(text);
        return result;
    }

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

    public void setText(String message) {
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
        result.setText(text);
        return result;
    }

    public static class Builder {

        private Message respondMessage;
        private Platform platform;
        private Action action;
        private String text;

        public MessageTarget getMessageTarget() {
            return messageTarget;
        }

        public void setMessageTarget(MessageTarget messageTarget) {
            this.messageTarget = messageTarget;
        }

        private MessageTarget messageTarget;

        public static Message.Builder respondTo(Message message) {
            Message.Builder result = new Builder();
            result.action = Action.RESPOND_TO;
            result.respondMessage = message;
            return result;
        }

        public Action getAction() {
            return action;
        }

        public Message getRespondMessage() {
            return respondMessage;
        }

        public String getText() {
            return text;
        }

        public void setPlatform(Platform platform) {
            this.platform = platform;
        }

        public void setAction(Action action) {
            this.action = action;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Message.Builder with(String text) {
            this.text = text;
            return this;
        }

        public enum Action {
            RESPOND_TO, PM
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Builder builder = (Builder) o;

            if (action != builder.action) return false;
            return text.equals(builder.text);

        }

        @Override
        public int hashCode() {
            int result = action.hashCode();
            result = 31 * result + text.hashCode();
            return result;
        }
    }
}
