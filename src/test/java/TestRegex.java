import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 19/09/16.
 */
public class TestRegex {
    @Test
    public void amountOfFindings() {
        final String regex = "%s";
        final String input = "%s %s";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        assertEquals(amountOfFindings(matcher), 2);
    }

    private static int amountOfFindings(Matcher matcher) {
        int result = 0;
        while (matcher.find()) result++;
        return result;
    }
}
