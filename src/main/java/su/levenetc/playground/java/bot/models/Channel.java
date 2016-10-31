package su.levenetc.playground.java.bot.models;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class Channel implements MessageTarget {

    private String id;
    private String userId;
    private boolean isUserChannel;

    public Channel(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isUserChannel() {
        return isUserChannel;
    }

    public void setUserChannel(boolean userChannel) {
        isUserChannel = userChannel;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
