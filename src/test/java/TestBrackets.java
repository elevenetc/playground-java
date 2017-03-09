import org.junit.Test;
import su.levenetc.playground.java.datastructures.Brackets;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 09/03/2017.
 */
public class TestBrackets {

    @Test
    public void testBalance() {
        Brackets brackets = new Brackets();
        assertEquals(true, brackets.add('{'));
        assertEquals(true, brackets.add('{'));
        assertEquals(true, brackets.add('('));
        assertEquals(true, brackets.add(')'));
        assertEquals(true, brackets.add('}'));
        assertEquals(true, brackets.add('}'));
        assertEquals(true, brackets.isEmpty());
    }
}