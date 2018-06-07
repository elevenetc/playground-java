package su.levenetc.playground.java.algs;

public class BackSpaceStrings {
    public static boolean equal(String a, String b) {
        return pass(a).equals(pass(b));
    }

    static String pass(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
