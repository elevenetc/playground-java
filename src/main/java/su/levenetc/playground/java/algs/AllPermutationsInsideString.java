package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.List;

public class AllPermutationsInsideString {


    static List<Integer> result = new LinkedList<>();
    static char[] stringChars;
    static StringBuilder sbPerm;
    static boolean lookingForFirstChar = true;
    static int currentIndex = 0;
    static int length = 0;

    public static List<Integer> get(String perm, String string) {

        length = 0;
        currentIndex = 0;
        result.clear();
        stringChars = string.toCharArray();
        sbPerm = new StringBuilder(perm);
        lookingForFirstChar = true;

        for (int i = 0; i < stringChars.length; i++) {
            char ch = stringChars[i];
            //sbPerm.deleteCharAt()
        }

        return result;
    }

    private static void reset() {
        lookingForFirstChar = true;
        length = 0;
        sbPerm.setLength(0);
    }

    public static boolean checkInclusion(String perm, String str) {

        sbPerm = new StringBuilder(perm);
        stringChars = str.toCharArray();

        for (int i = 0; i < stringChars.length; i++) {

            char ch = stringChars[i];
            int index = sbPerm.indexOf(String.valueOf(ch));

            if (lookingForFirstChar) {
                if (index > -1) {

                    length++;
                    lookingForFirstChar = false;
                    sbPerm.deleteCharAt(index);

                    if (sbPerm.length() == 0) {
                        return true;
                    }
                }
            } else {
                if (index > -1) {
                    length++;

                    if (length > perm.length()) {
                        reset2(perm);
                        continue;
                    }

                    sbPerm.deleteCharAt(index);
                    if (sbPerm.length() == 0) {
                        return true;
                    }
                } else {
                    reset2(perm);
                }
            }
        }

        return false;
    }

    private static void reset2(String perm) {
        length = 0;
        lookingForFirstChar = true;
        sbPerm.setLength(0);
        sbPerm.append(perm);
    }

}
