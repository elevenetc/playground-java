package su.levenetc.playground.java.algs;

public class MaxProfit {
    static int get(int... prices) {

        int maxProfit = 0;
        int buy = prices[0];

        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            int profit = price - buy;
            if (profit > maxProfit) {
                maxProfit = profit;
            } else if (buy > price) {
                buy = price;
            }
        }

        return maxProfit;
    }

}
