package su.levenetc.playground.java.lang;

import su.levenetc.playground.java.utils.Out;

import java.util.HashMap;

/**
 * Created by eugene.levenetc on 24/06/16.
 */
public class UpdateHashMap {
    public static void run() {
        HashMap<String, String> result = new HashMap<>();
        result.put("A", "0");
        result.put("B", "1");
        result.put("C", "2");

        Out.pln(result);

        for (String key : result.keySet())
            result.put(key, result.get(key) + "-changed");

        Out.pln(result);
    }


}
