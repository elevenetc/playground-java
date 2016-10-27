package su.levenetc.playground.java.utils;

import java.util.Random;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class StringUtils {
    public static String getRandomString(int length) {
        final char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();

        for (int i = 0; i < length; i++)
            sb.append(chars[random.nextInt(chars.length)]);

        return sb.toString();
    }
}
