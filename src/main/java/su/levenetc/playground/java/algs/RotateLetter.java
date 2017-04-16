package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.StringUtils;

/**
 * Created by eugene.levenetc on 16/04/2017.
 */
public class RotateLetter {

    public static char rotate(char ch, int shift) {
        if (StringUtils.isCapital(ch)) {
            return rotate(ch, shift, 'A', 'Z');
        } else {
            return rotate(ch, shift, 'a', 'z');
        }
    }

    public static char rotate(char ch, int shift, char first, char last) {
        if (ch + shift <= last) {
            return (char) (ch + shift);
        } else {
            int range = last - first + 1;
            int diff = ch + shift - last;
            int cutDiff = diff % range;
            if (cutDiff == 0) {
                return last;
            } else {
                return (char) ((first - 1) + cutDiff);
            }
        }
    }

}