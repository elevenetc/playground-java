package su.levenetc.playground.java.algs;

import java.util.LinkedList;
import java.util.Queue;

public class EnglishInt {
    static String toString(int n) {

        String[] map1 = new String[]{
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "sever",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };

        String[] map10 = new String[]{
                "",
                "twenty",
                "thirty",
                "forty",
                "fifty",
                "sixty",
                "seventy",
                "eighty",
                "ninety"
        };

        String hundred = "hundred";
        String thousand = "thousand";

        if (n <= 19) {
            return map1[n];
        } else {

            int i = 10;

            Queue<String> nums = new LinkedList<>();

            int d0 = n % 10;
            n /= 10;

            if (d0 > 0) nums.add(map1[d0]);

            while (n > 0) {
                int rem = n % 10;
                n /= 10;

                if (i == 10) {
                    nums.add(map10[rem]);
                } else if (i == 100) {

                    nums.add(hundred);
                    nums.add(map1[rem]);

                } else if (i == 1000) {
                    nums.add(thousand);
                    nums.add(map1[rem]);
                }

                i *= 10;
            }

            StringBuilder sb = new StringBuilder();

            while (!nums.isEmpty()) {
                sb.insert(0, nums.poll());

                if (!nums.isEmpty()) {
                    sb.insert(0, " ");
                }
            }


            return sb.toString();
        }
    }
}
