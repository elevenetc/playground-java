package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

public class LCS {

    public static String lcs(String s1, String s2) {
        return lcs(s1, s2, new HashMap<>());
    }

    public static String lcs(String s1, String s2, Map<String, String> mem) {

        if (mem.containsKey(s1 + s2)) return mem.get(s1 + s2);

        if (s1.isEmpty()) return "";
        else if (s2.isEmpty()) return "";

        char ch1 = s1.charAt(0);
        char ch2 = s2.charAt(0);

        String result;

        if (ch1 == ch2) {

            result = ch1 + lcs(s1.substring(1, s1.length()), s2.substring(1, s2.length()), mem);

        } else {

            String resultA = lcs(s1, s2.substring(1, s2.length()), mem);
            String resultB = lcs(s1.substring(1, s1.length()), s2, mem);

            result = resultA.length() > resultB.length() ? resultA : resultB;
        }

        mem.put(s1 + s2, result);

        return result;
    }

    public static String lcsMatrix(String s1, String s2) {

        StringBuilder sb = new StringBuilder();

        for (char ch1 : s1.toCharArray()) {
            for (char ch2 : s2.toCharArray()) {
                if (ch1 == ch2) {
                    sb.append(ch2);
                }
            }
        }

        return sb.toString();
    }
}
