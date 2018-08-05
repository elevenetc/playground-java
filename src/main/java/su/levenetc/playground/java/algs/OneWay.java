package su.levenetc.playground.java.algs;

public class OneWay {
    static boolean check(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return checkEqualLengthStrings(s1, s2);
        } else {
            return checkNotEqualsLengthStrings(s1, s2);
        }
    }

    private static boolean checkNotEqualsLengthStrings(String s1, String s2) {
        if (Math.abs(s1.length() - s2.length()) > 1) return false;

        int is = 0;
        int il = 0;
        String sShort;
        String sLong;
        boolean foundDiff = false;

        if (s1.length() < s2.length()) {
            sShort = s1;
            sLong = s2;
        } else {
            sShort = s2;
            sLong = s1;
        }


        while (is < sShort.length() || il < sLong.length()) {

            if (is < sShort.length() && il < sLong.length()) {
                char chA = sShort.charAt(is);
                char chB = sLong.charAt(il);

                if (chA == chB) {
                    is++;
                    il++;
                } else {

                    if (foundDiff) return false;

                    foundDiff = true;
                    il++;
                }
            } else {
                if (foundDiff) return false;
                il++;
            }
        }

        return true;
    }

    private static boolean checkEqualLengthStrings(String s1, String s2) {
        int i1 = 0;
        int i2 = 0;
        boolean foundDiff = false;
        while (i1 < s1.length() && i2 < s2.length()) {
            char ch1 = s1.charAt(i1);
            char ch2 = s2.charAt(i2);

            if (ch1 != ch2) {
                if (foundDiff) return false;
                else foundDiff = true;
            }

            i1++;
            i2++;
        }
        return true;
    }
}
