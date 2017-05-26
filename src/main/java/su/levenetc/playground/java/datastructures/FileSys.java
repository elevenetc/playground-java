package su.levenetc.playground.java.datastructures;

import java.util.*;

/**
 * Created by eugene.levenetc on 27/05/2017.
 */
public class FileSys {

    static Map<String, Set<Integer>> filesCounter = new HashMap<>();
    static Set<String> files = new HashSet<>();

    public static String createFile(String name) {
        String result;
        if (files.contains(name)) {

            String rawName = getRawName(name);

            int coun = getMinCounter(rawName) + 1;

            result = rawName + "(" + coun + ")";
            addCounter(rawName, coun);
            files.add(result);

        } else {
            addCounter(getRawName(name), getCounter(name));
            files.add(name);
            result = name;
        }
        return result;
    }

    static int getMinCounter(String name) {
        Set<Integer> counter = filesCounter.get(name);
        Iterator<Integer> it = counter.iterator();
        int prev = -1;
        int cur = 0;
        while (it.hasNext()) {
            cur = it.next();
            if (prev == -1) {
                prev = cur;
                continue;
            }
            if (cur - prev > 1) {
                return prev;
            } else {
                prev = cur;
            }
        }
        return cur;
    }

    static void addCounter(String name, int counterId) {
        Set<Integer> counter;
        if (filesCounter.containsKey(name)) {
            counter = filesCounter.get(name);
        } else {
            counter = new TreeSet<>();
            filesCounter.put(name, counter);
        }
        counter.add(counterId);
    }

    static String getRawName(String name) {
        if (hasCounter(name)) {
            return name.split("\\(")[0];
        } else {
            return name;
        }
    }

    static int getCounter(String name) {
        if (hasCounter(name)) {
            String tmp = name.split("\\(")[1];
            return Integer.parseInt(tmp.substring(0, tmp.length() - 1));
        } else {
            return 0;
        }
    }

    static boolean hasCounter(String name) {
        return name.charAt(name.length() - 1) == ')';
    }
}
