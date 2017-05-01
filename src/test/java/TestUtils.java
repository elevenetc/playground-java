import org.junit.Test;
import su.levenetc.playground.java.datastructures.Node;
import su.levenetc.playground.java.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by eugene.levenetc on 14/04/2017.
 */
public class TestUtils {

    @Test
    public void isLetter(){
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
}
