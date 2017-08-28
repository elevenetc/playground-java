package su.levenetc.playground.java.algs;

public class MostWaterContainer {
    public static int[] get1(int... values) {
        int left = 0;
        int right = values.length - 1;
        int maxLeft = left;
        int maxRight = right;
        int maxVolume = 0;

        while (left < right) {
            int width = right - left;
            int leftValue = values[left];
            int rightValue = values[right];
            int height = Math.min(leftValue, rightValue);
            int volume = height * width;

            if (maxVolume < volume) {
                maxVolume = volume;
                maxLeft = left;
                maxRight = right;
            }

            if (left + 1 == right) break;

            int nextLeftValue = values[left + 1];
            int nextRightValue = values[right - 1];

            int leftSum = leftValue + nextLeftValue;
            int rightSum = rightValue + nextRightValue;

            if (leftSum < rightSum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{maxLeft, maxRight};
    }

    public static int[] get2(int... values) {

        int maxVolume = 0;
        int left = 0;
        int right = values.length - 1;
        int maxLeft = 0;
        int maxRight = 0;

        while (left < right) {
            int volume = (right - left) * Math.min(values[left], values[right]);
            if (volume > maxVolume) {
                maxVolume = volume;
                maxLeft = left;
                maxRight = right;
            }
            if (values[left] < values[right])
                left++;
            else
                right--;
        }

        return new int[]{maxLeft, maxRight};
    }
}
