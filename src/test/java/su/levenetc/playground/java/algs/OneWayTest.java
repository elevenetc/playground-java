package su.levenetc.playground.java.algs;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static su.levenetc.playground.java.algs.OneWay.check;

public class OneWayTest {

    @Test
    public void test() {
        Assertions.assertThat(check("aaa", "bbb")).isFalse();
        Assertions.assertThat(check("aaa", "aab")).isTrue();
        Assertions.assertThat(check("aaaa", "aa")).isFalse();
        Assertions.assertThat(check("aaa", "aa")).isTrue();

        Assertions.assertThat(check("pale", "ple")).isTrue();
        Assertions.assertThat(check("pales", "pale")).isTrue();
        Assertions.assertThat(check("pale", "bale")).isTrue();
        Assertions.assertThat(check("pale", "bake")).isFalse();
    }
}