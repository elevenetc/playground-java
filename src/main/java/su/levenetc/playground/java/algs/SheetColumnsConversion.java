package su.levenetc.playground.java.algs;

public class SheetColumnsConversion {
    static int stringToNum(String str) {
        int column = 0;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char num = str.charAt(i);
            column += (num - 64) * Math.pow(26, length - i - 1);
        }
        return column;
    }

}
