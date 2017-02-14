import org.junit.Test;
import su.levenetc.playground.java.algs.Brackets;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 09/02/2017.
 */
public class RandomAlgs {
    @Test
    public void testBrackets() {
        assertEquals(true, Brackets.isValid("(())"));
        assertEquals(true, Brackets.isValid("5*(10+1)+(4/3)*(20)/(20*(50-4))"));
        assertEquals(false, Brackets.isValid("())"));
    }

}
