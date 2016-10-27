package su.levenetc.playground.java.bot.platforms.slack;

import su.levenetc.playground.java.bot.models.Channel;

import java.util.Collections;
import java.util.List;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class InitData {

    private String currentUserId;
    private List<Channel> channels;


    public List<Channel> getChannels() {
        return Collections.unmodifiableList(channels);
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public void setCurrentUserId(String id) {
        this.currentUserId = id;
    }

    public String getCurrentUserId() {
        return currentUserId;
    }
}
