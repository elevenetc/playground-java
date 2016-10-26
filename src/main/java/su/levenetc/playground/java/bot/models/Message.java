package su.levenetc.playground.java.bot.models;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class Message {

    private int messageType;
    private String message;
    private MessageTarget target;
    private User owner;
    private boolean isDirect;

    public Message() {

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

    public Message respond(String message) {
        Message result = new Message();
        result.setTarget(target);
        result.setMessage(message);
        return result;
    }
}
