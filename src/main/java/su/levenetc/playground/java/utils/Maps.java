package su.levenetc.playground.java.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by eugene.levenetc on 15/09/16.
 */
public class Maps {
    public static <K, V extends Comparable> V findMaxValue(HashMap<K, V> hashMap) {
        Iterator<Map.Entry<K, V>> iterator = hashMap.entrySet().iterator();
        V result = null;
        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            V value = entry.getValue();
            if (result == null) {
                result = value;
            } else {
                int compare = result.compareTo(value);
                if (compare < 0) {
                    result = value;
                }
            }
        }
        return result;

    }
}
