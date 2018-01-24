package su.levenetc.playground.java.algs;

public class AddBinary {
    public static String add(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int rem = 0;

        while (ai >= 0 || bi >= 0) {
            int an = 0;
            int bn = 0;

            if (ai >= 0) {
                an = a.charAt(ai) - 48;
                ai--;
            }

            if (bi >= 0) {
                bn = b.charAt(bi) - 48;
                bi--;
            }

            int sum = an + bn + rem;

            if (sum == 3) {
                rem = 1;
                sb.insert(0, '1');
            } else if (sum == 2) {
                rem = 1;
                sb.insert(0, '0');
            } else {
                rem = 0;
                sb.insert(0, '1');
            }
        }

        if (rem == 1) sb.insert(0, '1');

        return sb.toString();
    }
}
