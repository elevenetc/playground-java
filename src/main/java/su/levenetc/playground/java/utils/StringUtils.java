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

    public static void swap(String[] letters, int left, int right) {
        String temp = letters[left];
        letters[left] = letters[right];
        letters[right] = temp;
    }


    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static String setChar(String str, int index, char value) {
        char[] chars = str.toCharArray();
        chars[index] = value;
        return String.valueOf(chars);
    }

    public static String multiply(char ch, int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static String prepend(char ch, String src) {
        return prepend(ch, 1, src);
    }

    public static String prepend(char ch, int count, String src) {
        for (int i = 0; i < count; i++)
            src = ch + src;
        return src;
    }
}
