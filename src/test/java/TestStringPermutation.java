import org.junit.Test;
import su.levenetc.playground.java.algs.StringPermutation;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 24/04/2017.
 */
public class TestStringPermutation {

    @Test
    public void test01() {
        final String[] mutations = {"abc", "acb", "bac", "bca", "cab", "cba"};
        final Set<String> result = StringPermutation.permutate("abc");

        for (String mutation : mutations) assertTrue(result.contains(mutation));
        assertEquals(mutations.length, result.size());
    }

    @Test
    public void test02() {
        AssertUtils.assertContains(
                StringPermutation.permutate2(2, '-', '*'),
                "**", "-*", "*-"
        );
    }

}
