package su.levenetc.playground.java.algs;

import java.util.HashMap;

/**
 * Created by eugene.levenetc on 30/04/2017.
 */
public class DigitSum {

    static HashMap<String, Integer> sums = new HashMap<>();

    public static int run(String n, int ind) {

        while (ind % 10 == 0) ind = ind / 10;

        int sum = 0;
        for (int i = 0; i < ind; i++) {
            sum += arraySum(n.toCharArray(), 0);
        }

        while (sum > 9) {
            sum = arraySum(String.valueOf(sum).toCharArray(), 0);
        }
        return sum;
    }

    static int arraySum(char[] chars, int index) {
        if (index > chars.length - 1) return 0;
        if (index == chars.length - 1) return toInt(chars[index]);
        int sum = arraySum(chars, index + 1);
        final int i = toInt(chars[index]);
        String key = String.valueOf(sum) + i;
        if (!sums.containsKey(key)) {
            int result = i + sum;
            sums.put(String.valueOf(sum) + i, result);
            sums.put(i + String.valueOf(sum), result);
        }
        return sums.get(key);
    }

    static int toInt(char ch) {
        if (ch == '0') return 0;
        if (ch == '1') return 1;
        if (ch == '2') return 2;
        if (ch == '3') return 3;
        if (ch == '4') return 4;
        if (ch == '5') return 5;
        if (ch == '6') return 6;
        if (ch == '7') return 7;
        if (ch == '8') return 8;
        if (ch == '9') return 9;
        return Integer.parseInt(String.valueOf(ch));
    }
}
