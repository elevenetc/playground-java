package su.levenetc.playground.java.bot.models;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class User implements MessageTarget {

    private final String id;

    public User(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
