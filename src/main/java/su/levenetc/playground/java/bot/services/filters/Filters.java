package su.levenetc.playground.java.bot.services.filters;

import io.reactivex.functions.Predicate;
import su.levenetc.playground.java.bot.models.Message;

/**
 * Created by eugene.levenetc on 28/10/2016.
 */
public class Filters {
    public static Predicate<Message> kindOf(String value) {
        return message -> kindOfString(value).test(message.getMessage());
    }

    public static Predicate<String> kindOfString(String inputValue) {
        return caseValue -> {
            final String result = caseValue.toLowerCase().replace("!", "").trim();
            return result.equals(inputValue);
        };
    }
}
