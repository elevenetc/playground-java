package su.levenetc.playground.java.algs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by eugene.levenetc on 18/04/2017.
 */
public class EqualChocolateDistr {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            int students = scanner.nextInt();
            int[] array = new int[students];
            for (int s = 0; s < students; s++) {
                array[s] = scanner.nextInt();
            }
            System.out.println(maxOps(array, 0));
        }
    }

    static int maxOps(int[] array, int attempts) {
        if (isEqual(array)) return attempts;
        if (outOfRange(array)) return Integer.MAX_VALUE;

        System.out.println(Arrays.toString(array));

        int add1 = addAndSub(array, 1, attempts);
        int add2 = addAndSub(array, 2, attempts);
        int add5 = addAndSub(array, 5, attempts);

        return Math.min(Math.min(add1, add2), add5);
    }

    static int addAndSub(int[] array, int value, int attempts) {

        int indexOfMax = getIndexOfMax(array);
        int[] results = new int[array.length];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (i == indexOfMax) continue;
            add(array, value, indexOfMax);
            results[i] = maxOps(array, attempts + 1);
            sub(array, value, indexOfMax);
        }

        for (int i = 0; i < results.length; i++) {
            if (i == indexOfMax) continue;
            if (results[i] < result) {
                result = results[i];
            }
        }

        return result;
    }

    static int getIndexOfMax(int[] array) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int min(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = Math.min(array[i], result);
        }
        return result;
    }

    static boolean outOfRange(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if (value > 1000) {
                return true;
            }
        }
        return false;
    }

    static void add(int[] array, int value, int exclude) {
        for (int i = 0; i < array.length; i++) {
            if (i == exclude) continue;
            array[i] += value;
        }
    }

    static void sub(int[] array, int value, int exclude) {
        for (int i = 0; i < array.length; i++) {
            if (i == exclude) continue;
            array[i] -= value;
        }
    }

    static boolean isEqual(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] != array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
