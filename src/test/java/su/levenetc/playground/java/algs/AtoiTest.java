package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static su.levenetc.playground.java.algs.Atoi.parse;

public class AtoiTest {

    @Test
    public void test() {
        assertThat(parse("23")).isEqualTo(23);
        assertThat(parse("   -42")).isEqualTo(-42);
        assertThat(parse("4193 with words")).isEqualTo(4193);
        assertThat(parse("words and 987")).isEqualTo(0);
        assertThat(parse("-91283472332")).isEqualTo(-2147483648);
        assertThat(parse("2147483648")).isEqualTo(2147483647);
    }
}