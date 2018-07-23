package su.levenetc.playground.java.algs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static su.levenetc.playground.java.algs.LCS.lcs;
import static su.levenetc.playground.java.algs.LCS.lcsMatrix;

public class LCSTest {

    @Test
    public void lcsMapTest() {
        assertThat(lcs("abc", "ac")).isEqualTo("ac");
        assertThat(lcs("abc", "abc")).isEqualTo("abc");
        assertThat(lcs("abc", "a")).isEqualTo("a");
        assertThat(lcs("123a234234b234241c123", "9090a00bc09090")).isEqualTo("abc");
    }

    @Test
    public void lcsMatrixTest() {
        assertThat(lcsMatrix("abc", "ac")).isEqualTo("ac");
        assertThat(lcsMatrix("abc", "abc")).isEqualTo("abc");
        assertThat(lcsMatrix("abc", "a")).isEqualTo("a");
        assertThat(lcsMatrix("123a234234b234241c123", "9090a00bc09090")).isEqualTo("abc");
    }
}