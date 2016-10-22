package su.levenetc.playground.java.bot.models;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class Channel implements MessageTarget {

    private final String id;

    public Channel(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return null;
    }
}
