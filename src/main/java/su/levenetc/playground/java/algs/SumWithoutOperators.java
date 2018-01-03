package su.levenetc.playground.java.algs;

public class SumWithoutOperators {

    public static String binarySum(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int al = a.length() - 1;
        int bl = b.length() - 1;
        int carry = 0;
        while (al >= 0 || bl >= 0) {
            int sum = carry;
            if (al >= 0) sum += a.charAt(al) == '0' ? 0 : 1;
            if (bl >= 0) sum += b.charAt(bl) == '0' ? 0 : 1;
            char ch = ((sum | 1) == sum) ? '1' : '0';
            sb.insert(0, ch);
            carry = sum >>> 1;
            al--;
            bl--;
        }
        if (carry != 0) sb.insert(0, carry);
        return sb.toString();
    }

    public static int sum(int x, int y) {
        while (y != 0) {
            int carry = (x & y);
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }
}
