import org.junit.Test;
import su.levenetc.playground.java.datastructures.Crossword.Graph;
import su.levenetc.playground.java.datastructures.Crossword.PlaceHolder;

import static org.junit.Assert.*;
import static su.levenetc.playground.java.utils.MathUtils.ints;

/**
 * Created by eugene.levenetc on 27/04/2017.
 */
public class FillCrossword {

    @Test
    public void fillCrossword01() {
        Graph graph = new Graph();
        PlaceHolder phAB = new PlaceHolder(2);
        PlaceHolder phABC = new PlaceHolder(3);


        graph.set(phAB, phABC);
        graph.cross(phAB.getLetter(0), phABC.getLetter(0));

        graph.fill("abc", "ab");

        assertEquals("ab", phAB.toString());
        assertEquals("abc", phABC.toString());
    }

    @Test
    public void fillCrossword02() {
        Graph graph = new Graph();
        PlaceHolder phABC = new PlaceHolder(3);
        PlaceHolder phAB = new PlaceHolder(2);
        PlaceHolder phZC = new PlaceHolder(2);


        graph.set(phABC, phAB, phZC);
        graph.cross(phABC.getLetter(0), phAB.getLetter(0));
        graph.cross(phABC.getLetter(2), phZC.getLetter(1));

        graph.fill("abc", "ab", "zc");

        assertEquals("abc", phABC.toString());
        assertEquals("ab", phAB.toString());
        assertEquals("zc", phZC.toString());
    }

    @Test
    public void fillCrossword03() {
        Graph graph = new Graph();
        String[] words = new String[]{
                "---",
                "-++",
                "-++"
        };
        graph.set(words);
        graph.fill("abc", "abc");
    }

    @Test
    public void testIntersection() {
        assertArrayEquals(ints(2, 2), new PlaceHolder(0, 2, 3, true)
                .intersection(new PlaceHolder(2, 0, 4, false)));

        assertArrayEquals(ints(1, 1), new PlaceHolder(0, 1, 3, true)
                .intersection(new PlaceHolder(1, 0, 3, false)));

        assertNull(new PlaceHolder(0, 10, 3, true)
                .intersection(new PlaceHolder(2, 0, 4, false)));
    }

    @Test
    public void testLetterGetter01() {
        final PlaceHolder ph = new PlaceHolder(0, 2, 3, true);
        ph.set("abc");
        assertEquals('c', ph.getLetter(2, 2).getChar());
        assertEquals('b', ph.getLetter(1, 2).getChar());
    }

    @Test
    public void testLetterGetter02() {
        final PlaceHolder ph = new PlaceHolder(3, 3, 3, false);
        ph.set("abc");
        assertEquals('a', ph.getLetter(3, 3).getChar());
        assertEquals('b', ph.getLetter(3, 4).getChar());
        assertEquals('c', ph.getLetter(3, 5).getChar());
        assertNull(ph.getLetter(3, 6));
    }
}
