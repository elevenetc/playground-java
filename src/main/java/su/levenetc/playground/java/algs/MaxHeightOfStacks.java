package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by eugene.levenetc on 07/05/2017.
 * https://www.hackerrank.com/challenges/equal-stacks
 */
public class MaxHeightOfStacks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int h1[] = new int[n1];
        int h2[] = new int[n2];
        int h3[] = new int[n3];
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;

        for (int h1_i = 0; h1_i < n1; h1_i++) {
            h1[h1_i] = in.nextInt();
            sum1 += h1[h1_i];
        }

        for (int h2_i = 0; h2_i < n2; h2_i++) {
            h2[h2_i] = in.nextInt();
            sum2 += h2[h2_i];
        }

        for (int h3_i = 0; h3_i < n3; h3_i++) {
            h3[h3_i] = in.nextInt();
            sum3 += h3[h3_i];
        }

        n1 = 0;
        n2 = 0;
        n3 = 0;

        while (sum1 != sum2 && sum1 != sum3) {

            if (sum1 > sum2 && sum1 > sum3) {
                sum1 -= h1[n1];
                //System.out.println("min1:" + h1[n1]);
                n1++;
                //continue;
            }

            if (sum2 > sum1 && sum2 > sum3) {
                sum2 -= h2[n2];
                //System.out.println("min2:" + h2[n2]);
                n2++;

                //continue;
            }

            if (sum3 > sum2 && sum3 > sum1) {
                sum3 -= h3[n3];
                //System.out.println("min3:" + h3[n3]);
                n3++;
                //continue;
            }
        }

        System.out.println(sum1);

        //List<Integer> sum1 = calcSum(h1);
        //List<Integer> sum2 = calcSum(h2);
        //List<Integer> sum3 = calcSum(h2);

        //System.out.println(findCommonMax(sum1, sum2, sum3));
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
