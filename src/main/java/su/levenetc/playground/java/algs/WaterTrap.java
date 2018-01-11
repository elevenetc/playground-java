package su.levenetc.playground.java.algs;

public class WaterTrap {

    public static int get1(int... height) {
        int result = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        right[right.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++)
            left[i] = Math.max(height[i], left[i - 1]);

        for (int i = height.length - 2; i >= 0; i--)
            right[i] = Math.max(height[i], right[i + 1]);

        for (int i = 0; i < height.length; i++) {
            int top = Math.min(left[i], right[i]);
            int bottom = height[i];
            result += top - bottom;
        }

        return result;
    }

    public static int get2(int... height) {

        int left = 0;
        int right = height.length - 1;
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) leftMax = height[left];
                else result += leftMax - height[left];
                left++;
            } else {
                if (height[right] >= rightMax) rightMax = height[right];
                else result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }
}
