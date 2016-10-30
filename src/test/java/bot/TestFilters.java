package bot;

import org.junit.Test;
import su.levenetc.playground.java.bot.services.filters.Filters;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 30/10/2016.
 */
public class TestFilters {
    @Test
    public void testAnyString() throws Exception {
        assertEquals(true, Filters.kindOfString("hello").test("hello "));
        assertEquals(true, Filters.kindOfString("hello").test(" hello "));
        assertEquals(true, Filters.kindOfString("hello").test(" hello! "));
        assertEquals(false, Filters.kindOfString("hello").test(" hello? "));
    }
}
