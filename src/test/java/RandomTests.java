import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 13/02/2017.
 */
public class RandomTests {
    @Test
    public void maxFloat(){
        assertEquals(true, 0.1f < Float.MAX_VALUE);
    }
}
