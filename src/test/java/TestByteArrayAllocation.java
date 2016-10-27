import org.junit.Test;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class TestByteArrayAllocation {
    @Test
    public void testSuccessAllocation() {
        ByteBuffer.allocate(4).putInt(Integer.MAX_VALUE).array();
    }

    @Test(expected = BufferOverflowException.class)
    public void testFailAllocation() {
        ByteBuffer.allocate(2).putInt(Integer.MAX_VALUE).array();
    }
}
