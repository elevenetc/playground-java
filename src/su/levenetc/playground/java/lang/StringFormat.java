package su.levenetc.playground.java.lang;

import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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

        checkFormat("%2$s %3$d %3$s", 3);
        //checkFormat("%1$d %2$s %3", 2);
    }

    private static void checkFormat(String source, int mustBe) {
        List<String> validReplacements = getValidReplacements(source);
        Out.pln("check format '" + source + "': " + assertEquals(validReplacements.size(), mustBe));
        checkAmountOfValidReplacements(source, validReplacements);
    }

    private static boolean compareFormats(String formatA, String formatB) {
        return false;
    }

    private static List<String> getValidReplacements(String format) {
        List<String> replacements = new ArrayList<>();
        Pattern p = Pattern.compile("%\\d(\\$s|\\$d)");
        Matcher m = p.matcher(format);
        while (m.find())
            replacements.add(m.group(0));

        return replacements;
    }

    private static void checkAmountOfValidReplacements(String source, List<String> replacements) {

        int size = replacements.size();
        replacements = new ArrayList<>(replacements);
        List<String> notFount = new ArrayList<>();

        for (int i = 1; i <= size; i++) {

            Iterator<String> iterator = replacements.iterator();
            boolean found = false;

            while (iterator.hasNext()) {
                String match = iterator.next();

                String checkMatch = "%" + i;
                if (match.contains(checkMatch)) {
                    found = true;
                    iterator.remove();
                    break;
                }
            }

            if (!found)
                notFount.add("%" + i);
        }

        if (replacements.size() > 0 || notFount.size() > 0) {
            Out.pln("Found problems for '" + source + "'");

            if (replacements.size() > 0) Out.pln("Redundant replacement: " + replacements);

            if (notFount.size() > 0) Out.pln("Not found replacement: " + notFount);
        }
    }

}
