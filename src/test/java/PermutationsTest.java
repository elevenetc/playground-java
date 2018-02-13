import org.junit.Test;

import java.util.Set;

import su.levenetc.playground.java.algs.Permutations;
import utils.AssertUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.algs.Permutations.arePerms;
import static su.levenetc.playground.java.algs.Permutations.permutate2;
import static su.levenetc.playground.java.algs.Permutations.permutatePrefix;
import static su.levenetc.playground.java.algs.Permutations.permutateIterative;
import static su.levenetc.playground.java.algs.Permutations.permutateRecursive;
import static su.levenetc.playground.java.algs.Permutations.permutateWithSwap;

/**
 * Created by eugene.levenetc on 24/04/2017.
 */
public class PermutationsTest {

    @Test
    public void test01() {
        perms(
                "abc",
                "abc", "acb", "bac", "bca", "cab", "cba"
        );
        perms(
                "1234",
                "1234", "1243", "1324", "1342", "1423", "1432", "2134", "2143", "2314", "2341", "2413", "2431", "3124", "3142", "3214", "3241", "3412", "3421", "4123", "4132", "4213", "4231", "4312", "4321"
        );
    }

    @Test
    public void test03() {

    }

    private void perms(String input, String... mutations) {
        assertPermutations(mutations, permutateWithSwap(input));
        assertPermutations(mutations, permutateRecursive(input));
        assertPermutations(mutations, permutateIterative(input));
        assertPermutations(mutations, permutatePrefix(input));
    }

    @Test
    public void test02() {
        AssertUtils.assertContains(
                permutate2(2, '-', '*'),
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
