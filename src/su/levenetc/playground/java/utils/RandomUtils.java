package su.levenetc.playground.java.utils;

import java.util.Random;

/**
 * Created by eugene.levenetc on 18/05/16.
 */
public class RandomUtils {
    public static void genRandom() {

        final int length = 32;
        final char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();

        for (int i = 0; i < length; i++)
            sb.append(chars[random.nextInt(chars.length)]);

        Out.pln(sb.toString());
    }
}