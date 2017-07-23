package su.levenetc.playground.java.algs;

public class SellWithMaxRevenue {
    public static int get(int[] prices) {
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
}
