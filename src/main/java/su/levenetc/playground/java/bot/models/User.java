package su.levenetc.playground.java.bot.models;

/**
 * Created by eugene.levenetc on 22/10/2016.
 */
public class User implements MessageTarget {

    private final String id;
    private String name;

    public User(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
