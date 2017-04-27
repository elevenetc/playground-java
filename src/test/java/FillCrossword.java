import org.junit.Test;
import su.levenetc.playground.java.datastructures.Crossword.Graph;
import su.levenetc.playground.java.datastructures.Crossword.PlaceHolder;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 27/04/2017.
 */
public class FillCrossword {
    @Test
    public void fillCrossword01() {
        Graph graph = new Graph();
        PlaceHolder ph2 = new PlaceHolder(2);
        PlaceHolder ph3 = new PlaceHolder(3);
        graph.set(ph2, ph3);
        ph2.setCross(ph3.getLetter(0), 0);
        graph.fill("abc", "ab");

        assertEquals("ab", ph2.toString());
        assertEquals("abc", ph3.toString());
    }
}
