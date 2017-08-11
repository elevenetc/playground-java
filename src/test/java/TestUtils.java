import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import su.levenetc.playground.java.datastructures.Node;
import su.levenetc.playground.java.utils.StringUtils;
import su.levenetc.playground.java.utils.Utils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 14/04/2017.
 */
public class TestUtils {

    @Test
    public void isLetter() {
        assertTrue(StringUtils.isLetter('L'));
        assertTrue(StringUtils.isLetter('a'));
        assertFalse(StringUtils.isLetter('.'));
        assertFalse(StringUtils.isLetter('='));
    }

    @Test
    public void isCapital() {
        assertTrue(StringUtils.isCapital('A'));
        assertTrue(StringUtils.isCapital('Z'));
        assertFalse(StringUtils.isCapital('x'));
        assertFalse(StringUtils.isCapital('g'));
        assertFalse(StringUtils.isCapital('.'));
    }

    @Test
    public void testAssertions() {
        List<Set<Node>> sets = new ArrayList<>();
        sets.add(Node.nodesSet(1, 2, 3));
        AssertUtils.assertContains(sets, new Node(1), new Node(2), new Node(3));
    }

    @Test
    public void testRange() {
        assertArrayEquals(Utils.array(1, 2, 3), Utils.range(1, 3));
        assertArrayEquals(Utils.array(1, 2, 3), Utils.range(1, 3, 1));
        assertArrayEquals(Utils.array(1, 2, 3, 4), Utils.range(1, 4));
        assertArrayEquals(Utils.array(0, 5, 10, 15), Utils.range(0, 15, 5));
    }

    @Test
    public void testIsCompletable() {
        assertTrue(Utils.isCompletable("hello", "he"));
        assertTrue(Utils.isCompletable("hello", "h"));
        assertTrue(Utils.isCompletable("hello", "hello"));
        assertFalse(Utils.isCompletable("hello", "zo"));
        assertFalse(Utils.isCompletable("hello", "hez"));
        assertFalse(Utils.isCompletable("hello", "helloz"));
    }
}
