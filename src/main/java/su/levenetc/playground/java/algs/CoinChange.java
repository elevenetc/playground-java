package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class CoinChange {

    public static int coinChange(int amount, int... coins) {
        if (amount < 1) return 0;
        return coinChange(coins, amount);
        //return coinChangeMem(coins, amount, new int[amount]);
    }

    private static int coinChangeMem(final int[] coins, final int rem, final int[] mem) {

        if (rem < 0) return -1;
        if (rem == 0) return 0;
        final int storeIndex = rem - 1;

        if (mem[storeIndex] != 0) {
            return mem[storeIndex];
        }

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChangeMem(coins, rem - coin, mem);
            if (res >= 0 && res < min)
                min = 1 + res;
        }

        int result = (min == Integer.MAX_VALUE) ? -1 : min;
        mem[storeIndex] = result;
        return result;
    }

    private static int coinChange(final int[] coins, final int rem) {

        if (rem < 0) return -1;
        if (rem == 0) return 0;

        int min = Integer.MAX_VALUE;
        for (int c = 0; c < coins.length; c++) {
            int coin = coins[c];
            int result = coinChange(coins, rem - coin);
            if (result >= 0 && result < min) {
                min = 1 + result;
            }
        }

        return (min == Integer.MAX_VALUE) ? -1 : min;
    }

}