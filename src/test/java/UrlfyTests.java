import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static su.levenetc.playground.java.algs.URLify.urlfy;
import static su.levenetc.playground.java.utils.Utils.charArray;

public class UrlfyTests {

    @Test
    public void test01() {
        assertArrayEquals(
                charArray('%', '2', '0', 'M', 'r', '%', '2', '0', 'J', 'o', 'h', 'n'),
                urlfy(' ', 'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', ' ', ' ', ' ')
        );
    }


}
