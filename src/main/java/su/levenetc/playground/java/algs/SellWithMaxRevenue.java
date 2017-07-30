package su.levenetc.playground.java.algs;

public class SellWithMaxRevenue {

    public static int sellOnce1(int[] prices) {
        int max = -1;
        for (int i = 0; i < prices.length - 1; i++) {
            final int buy = prices[i];
            for (int k = i + 1; k < prices.length; k++) {
                final int sell = prices[k];
                if (sell > buy) {
                    max = Math.max(max, sell - buy);
                }
            }
        }
        return max;
    }

    public static int sellOnce2(int[] prices) {
        int min = prices[0];
        int max = 0;

        for (int p : prices) {
            max = Math.max(max, p - min);
            min = Math.min(min, p);
        }

        return max;
    }

    public static int sellMultipleTimes(int[] prices) {

        if (prices.length <= 1) return -1;

        int buyIndex = 0;
        int current = 1;
        int result = 0;

        while (current < prices.length) {

            boolean isLast = current == prices.length - 1;

            if (prices[current] < prices[buyIndex]) {
                buyIndex = current;
                current++;
            } else if (prices[current] > prices[buyIndex]) {
                if (!isLast) {
                    final int future = prices[current + 1];
                    if (future < prices[current]) {
                        result += prices[current] - prices[buyIndex];
                        buyIndex = current + 1;
                        current = current + 2;
                    } else {
                        current++;
                    }
                } else {
                    result += prices[current] - prices[buyIndex];
                    break;
                }
            }
        }

        return result;
    }
}