package su.levenetc.playground.java.bot.services.filters;

import io.reactivex.functions.Predicate;
import su.levenetc.playground.java.bot.models.Message;

/**
 * Created by eugene.levenetc on 28/10/2016.
 */
public class Filters {
    public static Predicate<Message> kindOf(String value) {
        return message -> {
            String v = value.toLowerCase().replace("!", "").trim();
            final String m = message.getMessage().toLowerCase().replace("!", "").trim();
            return v.equals(m);
        };
    }
}
