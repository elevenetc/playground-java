package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eugene.levenetc on 07/05/2017.
 * https://www.hackerrank.com/challenges/equal-stacks
 */
public class MaxHeightOfStacks {

    public static int get(int[] h1, int[] h2, int[] h3) {
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int i : h1) sum1 += i;
        for (int i : h2) sum2 += i;
        for (int i : h3) sum3 += i;
        return get(h1, h2, h3, sum1, sum2, sum3);
    }

    public static int get(int[] h1, int[] h2, int[] h3, int sum1, int sum2, int sum3) {

        int n1 = 0;
        int n2 = 0;
        int n3 = 0;

        while (sum1 != sum2 || sum1 != sum3) {

            if (sum1 > sum2 && sum1 > sum3) {
                sum1 -= h1[n1];
                System.out.println("min1:" + h1[n1]);
                n1++;
                //continue;
            }

            if (sum2 > sum1 && sum2 > sum3) {
                sum2 -= h2[n2];
                System.out.println("min2:" + h2[n2]);
                n2++;

                //continue;
            }

            if (sum3 > sum2 && sum3 > sum1) {
                sum3 -= h3[n3];
                System.out.println("min3:" + h3[n3]);
                n3++;
                //continue;
            }

            if (sum1 == 0 || sum2 == 0 || sum3 == 0) return 0;
        }

        return sum1;
    }

    public static int get01(int[] h1, int[] h2, int[] h3) {
        List<Integer> s1 = calcSum(h1);
        List<Integer> s2 = calcSum(h2);
        List<Integer> s3 = calcSum(h3);

        return findCommonMax(s1, s2, s3);
    }

    static int findCommonMax(List<Integer> sum1, List<Integer> sum2, List<Integer> sum3) {
        int result = 0;
        for (int i1 = 0; i1 < sum1.size(); i1++) {
            int i1Value = sum1.get(i1);
            for (int i2 = 0; i2 < sum2.size(); i2++) {
                int i2Value = sum2.get(i2);
                for (int i3 = 0; i3 < sum3.size(); i3++) {
                    int i3Value = sum3.get(i3);

                    if (i1Value == i2Value && i1Value == i3Value) {
                        result = Math.max(i1Value, result);
                    }
                }
            }
        }
        return result;
    }

    static List<Integer> calcSum(int[] array) {
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            sum += array[i];
            result.add(sum);
        }
        return result;
    }
}
