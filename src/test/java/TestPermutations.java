import org.junit.Test;

import java.util.Set;

import su.levenetc.playground.java.algs.Permutations;
import utils.AssertUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.Permutations.arePerms;

/**
 * Created by eugene.levenetc on 24/04/2017.
 */
public class TestPermutations {

    @Test
    public void test01() {
        final String[] mutations = {"abc", "acb", "bac", "bca", "cab", "cba"};

        String input = "abc";
        assertPermutations(mutations, Permutations.permutateWithSwap(input));
        assertPermutations(mutations, Permutations.permutate4(input));
    }

    @Test
    public void test03() {
        final String[] mutations = {"1234", "1243", "1324", "1342", "1423", "1432", "2134", "2143", "2314", "2341", "2413", "2431", "3124", "3142", "3214", "3241", "3412", "3421", "4123", "4132", "4213", "4231", "4312", "4321"};
        String input = "1234";
        assertPermutations(mutations, Permutations.permutateWithSwap(input));
        assertPermutations(mutations, Permutations.permutate4(input));
    }

    @Test
    public void test02() {
        AssertUtils.assertContains(
                Permutations.permutate2(2, '-', '*'),
                "**", "-*", "*-"
        );
    }

    @Test
    public void permutateBin() {
        Permutations.permutateBin(10);
    }

    @Test
    public void arePermsTests() {
        assertTrue(arePerms("abc", "bca"));
        assertTrue(arePerms("abc", "abc"));
        assertTrue(arePerms("abc", "cba"));
        assertFalse(arePerms("abc", "cb"));
        assertFalse(arePerms("abc", "cbA"));
    }

    private void assertPermutations(String[] mutations, Set<String> result) {
        for (String mutation : mutations) assertTrue(result.contains(mutation));
        assertEquals(mutations.length, result.size());
    }


}
