package su.levenetc.playground.java.bot.services.simpleconversation;

/**
 * Created by eugene.levenetc on 23/10/2016.
 */
public class AnyAnswer extends Answer<Void> {

    public AnyAnswer() {
        super(null);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}