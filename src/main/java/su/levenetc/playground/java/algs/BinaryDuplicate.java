package su.levenetc.playground.java.algs;

import java.util.Scanner;

/**
 * Created by eugene.levenetc on 17/05/2017.
 */
public class BinaryDuplicate {
    static String string;

    static void buildS() {
        StringBuilder sb = new StringBuilder("0");

        while(sb.length() <= 1000){
            sb.append(invert(sb.toString()));
        }

        string = sb.toString();
    }

    static String invert(String value) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < value.length(); i++){
            char ch = value.charAt(i);
            sb.append(ch == '0' ? '1' : '0');
        }
        return sb.toString();
    }

    static char duplication(int i){
        return string.charAt(i);
    }

    public static void main(String[] args) {
        buildS();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int x = in.nextInt();
            System.out.println(duplication(x));
        }
    }
}
