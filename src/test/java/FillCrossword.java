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
}
