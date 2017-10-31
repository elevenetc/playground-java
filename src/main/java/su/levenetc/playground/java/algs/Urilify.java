package su.levenetc.playground.java.algs;

public class Urilify {

    static String get0(String value) {
        return get0(value.toCharArray());
    }

    static String get0(char... value) {
        int lastChar = lastCharIndex(value);
        int endIndex = value.length - 1;
        for (int i = lastChar; i > 0; i--) {
            char ch = value[i];

            if (ch == ' ') {
                value[endIndex] = '0';
                value[--endIndex] = '2';
                value[--endIndex] = '%';
            } else {
                value[endIndex] = ch;
                endIndex--;
            }
        }
        return new String(value);
    }

    static int lastCharIndex(char... value) {
        for (int i = value.length - 1; i >= 0; i--) {
            char ch = value[i];
            if (ch != ' ') return i;
        }
        return 0;
    }
}
