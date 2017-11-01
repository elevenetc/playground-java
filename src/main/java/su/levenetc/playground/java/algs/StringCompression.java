package su.levenetc.playground.java.algs;

public class StringCompression {
    static String get(String value) {

        if (value.length() <= 0) return value;

        StringBuilder sb = new StringBuilder();
        char current = value.charAt(0);
        int counter = 1;
        for (int i = 1; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (ch == current) {
                counter++;
            } else {
                sb.append(current);
                sb.append(counter);
                current = ch;
                counter = 1;
            }
        }

        String compressed = sb.toString();
        if (value.length() == compressed.length()) {
            return value;
        } else {
            return compressed;
        }
    }
}
