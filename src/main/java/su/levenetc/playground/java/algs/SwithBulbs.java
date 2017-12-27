package su.levenetc.playground.java.algs;

import java.util.ArrayList;

public class SwithBulbs {
    public static int bulbs(ArrayList<Integer> bulbs) {
        int result = 0;
        int state = 1;
        for (int i = 0; i < bulbs.size(); i++) {
            int b = bulbs.get(i);
            if (b != state) {
                result++;
                state = state == 1 ? 0 : 1;
            }
        }
        return result;
    }
}
