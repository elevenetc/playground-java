package su.levenetc.playground.java.lang;

import su.levenetc.playground.java.utils.Out;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static su.levenetc.playground.java.utils.TestUtils.assertEquals;

/**
 * Created by eugene.levenetc on 26/08/16.
 */
public class StringFormat {
    public static void run() {
        Out.pln(String.format("first: %1$s second: %2$s", "x", "y"));
        Out.pln(String.format("first: %1$d second: %2$d", 1, 2));
        Out.pln(String.format("first: %1$d second: %2$s", 1, "a"));
        Out.pln(String.format("object: %1$s", new Object()));
        Out.pln(String.format("date: %1$tm.%1$te.%1$tY", new Date()));

        checkFormat("%2$s %3$d", 2);
        checkFormat("%1$d %2$s %3$d", 3);
    }

    private static void checkFormat(String formatA, int amount) {
        Out.pln("'" + formatA + "': " + assertEquals(getAmountOfValidReplacements(formatA), amount));
    }

    private static boolean compareFormats(String formatA, String formatB) {
        return false;
    }

    private static int amountOfReplacement(String format) {
        int result = 0;
        int lastIndex = 0;
        while (lastIndex > -1) {
            String check = "%";
            lastIndex = format.indexOf(check, lastIndex);
            if (lastIndex > -1) {
                int length = check.length();
                lastIndex += length;
                result++;
            }

        }
        return result;
    }

    private static int getAmountOfValidReplacements(String format) {
        Pattern p = Pattern.compile("%\\d(\\$s|\\$d)");
        Matcher m = p.matcher(format);
        int result = 0;
        while (m.find()) result++;
        return result;
    }

    private static boolean isReplacementValid(String replacement) {
        return false;
    }
}
