import org.junit.Test;
import su.levenetc.playground.java.datastructures.LRUCache;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTests {
    @Test
    public void test01() {
        LRUCache lru = new LRUCache(3);
        lru.put(1, 1);
        lru.put(2, 2);
        lru.put(3, 3);
        assertThat(lru.recentlyUsed()).isEqualTo(3);
        lru.get(2);
        assertThat(lru.recentlyUsed()).isEqualTo(2);
        lru.put(4, 4);
        assertThat(lru.recentlyUsed()).isEqualTo(4);
        assertThat(lru.get(1)).isEqualTo(-1);
    }

    @Test
    public void test02() {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        assertThat(lru.get(1)).isEqualTo(1);
        lru.put(3, 3);
        assertThat(lru.get(2)).isEqualTo(-1);
        lru.put(4, 4);
        assertThat(lru.get(1)).isEqualTo(-1);
        assertThat(lru.get(3)).isEqualTo(3);
        assertThat(lru.get(4)).isEqualTo(4);
        lru.put(3, 3);
        assertThat(lru.recentlyUsed()).isEqualTo(3);
    }

    @Test
    public void test03() {
        LRUCache lru = new LRUCache(1);
        lru.put(2, 1);
        assertThat(lru.get(2)).isEqualTo(1);
    }
}