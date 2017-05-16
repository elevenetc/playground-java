package su.levenetc.playground.java.algs;

import java.util.Arrays;

/**
 * Created by eugene.levenetc on 17/05/2017.
 */
public class MaxKillPerTime {
    public static int getMaxMonsters(int hit, int time, int[] healths) {
        int result = 0;
        Arrays.sort(healths);
        for (int i = 0; i < healths.length; i++) {
            while (healths[i] > 0 && time > 0) {
                healths[i] -= hit;
                time--;

                if (healths[i] <= 0) {
                    result++;
                    break;
                }
            }
            if (time == 0) break;
        }
        return result;
    }
}
