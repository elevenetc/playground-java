package su.levenetc.playground.java.lang;

import su.levenetc.playground.java.utils.Out;

import java.util.Date;

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
    }
}
