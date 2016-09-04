package su.levenetc.playground.java.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

/**
 * Created by eugene.levenetc on 18/05/16.
 */
public class RandomUtils {
    public static String genRandom() {

        final int length = 32;
        final char[] chars = "1234567890abcdefghijklmnopqrstuvwxyz".toCharArray();
        final StringBuilder sb = new StringBuilder();
        final Random random = new Random();

        for (int i = 0; i < length; i++)
            sb.append(chars[random.nextInt(chars.length)]);

        String result = sb.toString();
        Out.pln(result);
        return result;
    }

    public static void hashRandom() {
        final String imei = "sd5f-23dc";
        final int length = 32;
        final String randomString = genRandom();
        //final String randomString = "u6qazg7xktabxm941x5xtcuxw0a1k2f9";
        final String seed = randomString.substring(8, length - 8);
        String concat = imei + seed;
        try {
            MessageDigest digester = MessageDigest.getInstance("SHA-256");
            digester.update(concat.getBytes());
            byte[] hashed = digester.digest();
            Out.pln("input:" + concat + " out:" + Base64.getEncoder().encodeToString(hashed));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}