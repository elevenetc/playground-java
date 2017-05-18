package su.levenetc.playground.java.algs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eugene.levenetc on 17/05/2017.
 */
public class MaxKillPerTime {

    static Map<Integer, Integer> killMap = new HashMap<>();

    public static int getMaxMonsters(float damage, int hitTimes, int[] healths) {

        if ((int) damage == 0) return 0;
        if (healths.length == 0) return 0;
        if (hitTimes == 0) return 0;

        int killedMonsters = 0;
        killMap.clear();
        for (int i = 0; i < healths.length; i++) {
            int h = healths[i];
            int hitsToKill;
            if (h <= damage) {
                hitsToKill = 1;
            } else if ((int) (h % damage) == 0) {
                hitsToKill = (int) (h / damage);
            } else {
                hitsToKill = (int) (h / damage + 1);
            }
            add(hitsToKill);
        }

        int hitsCounter = 1;
        while (hitTimes > 0) {
            if (!killMap.containsKey(hitsCounter)) {
                hitsCounter++;
                continue;
            }
            int killed = killMap.get(hitsCounter);

            for (int i = 0; i < killed; i++) {
                killedMonsters++;
                hitTimes -= hitsCounter;
                if (hitTimes == 0) {
                    return killedMonsters;
                } else if (hitTimes < 0) {
                    return --killedMonsters;
                }
            }

            hitsCounter++;
        }

        return killedMonsters;
    }

    static void add(int hitsToKill) {
        if (!killMap.containsKey(hitsToKill)) {
            killMap.put(hitsToKill, 1);
        } else {
            killMap.put(hitsToKill, killMap.get(hitsToKill) + 1);
        }
    }
}
