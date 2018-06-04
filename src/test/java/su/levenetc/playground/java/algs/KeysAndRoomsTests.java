package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static su.levenetc.playground.java.algs.KeysAndRooms.isAllVisitable;
import static su.levenetc.playground.java.utils.Utils.list;

public class KeysAndRoomsTests {
    @Test
    public void test01() {
        assertThat(isAllVisitable(list(list(1), list(2), list(3), list(0)))).isTrue();
    }

    @Test
    public void test02() {
        assertThat(isAllVisitable(list(list(1, 3), list(3, 0, 1), list(2), list(0)))).isFalse();
    }
}
