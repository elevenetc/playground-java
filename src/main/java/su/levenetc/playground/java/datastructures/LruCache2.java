package su.levenetc.playground.java.datastructures;

import java.util.LinkedHashMap;
import java.util.Map;

import su.levenetc.playground.java.Main;

public class LruCache2 {

    private int maxSize;
    private int currentSize;
    private SizeOf sizeOf;

    private LinkedHashMap<String, Object> cache = new LinkedHashMap<String, Object>() {
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Object> eldest) {
            boolean outOfMemory = currentSize > maxSize;
            if (outOfMemory) {
                currentSize -= sizeOf.size(eldest.getValue());
            }
            return outOfMemory;
        }
    };

    public LruCache2(int maxSize, SizeOf sizeOf) {
        this.maxSize = maxSize;
        this.sizeOf = sizeOf;
    }

    public void put(String key, Object value) {
        currentSize += sizeOf.size(value);
        cache.put(key, value);
    }

    public Object get(String key) {
        if (!cache.containsValue(key)) {
            return cache.get(key);
        } else {
            return cache.get(key);
        }
    }

    public boolean contains(String key) {
        return cache.containsKey(key);
    }

    public void delete(String key) {
        if (cache.containsValue(key)) {
            Object value = cache.remove(key);
            currentSize -= sizeOf.size(value);
        }
    }

    public interface SizeOf {
        int size(Object object);
    }
}
