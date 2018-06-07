package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static su.levenetc.playground.java.algs.BackSpaceStrings.equal;

public class BackSpaceStringsTest {
    @Test
    public void test() {
        assertThat(equal("a#b", "b")).isTrue();
        assertThat(equal("ab#c", "ad#c")).isTrue();
    }
}