package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 23/06/2017.
 */
public class CoinChange {

    public static int coinChange(int amount, int... coins) {
        if (amount < 1) return 0;
//        final int[] mem = new int[amount];
//        return coinChange(coins, amount);
        final Map<Integer, Integer> mem = new HashMap<>();
//        final int result = coinChangeMem(coins, amount, mem);
        final int result = coinChangeMem2(amount, coins, mem);
        return result;
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

    private static int coinChangeMem2(int total, int[] coins, Map<Integer, Integer> mem) {

        if (total < 0) return -1;
        if (total == 0) return 0;
        if (mem.containsKey(total)) return mem.get(total);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            final int coin = coins[i];
            if (coin > total) continue;
            int currentCoinResult = coinChangeMem2(total - coin, coins, mem);
            if (currentCoinResult < result) result = currentCoinResult;
        }

        result = result == Integer.MAX_VALUE ? -1 : result + 1;
        mem.put(total, result);
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