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

    public static boolean isCapital(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static String swap(String str, int a, int b) {
        if (a == b) return str;
        char[] charArray = str.toCharArray();
        char aTemp = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = aTemp;
        return String.valueOf(charArray);
    }
}
