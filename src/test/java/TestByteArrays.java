import org.junit.Test;
import su.levenetc.playground.java.utils.ByteArrayUtils;

import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class TestByteArrays {

    @Test
    public void testSuccessAllocation() {
        ByteBuffer.allocate(4).putInt(Integer.MAX_VALUE).array();
    }

    @Test(expected = BufferOverflowException.class)
    public void testFailAllocation() {
        ByteBuffer.allocate(2).putInt(Integer.MAX_VALUE).array();
    }

    @Test
    public void testConversion() {
        int intValue = -860743914;
        final byte[] bytes = fromInt(intValue);
        final int convertedInt = fromByteArray(bytes);
        assertEquals(intValue, convertedInt);
    }

    @Test
    public void testLargerBuffer() {
        byte[] input = new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put(Arrays.copyOfRange(input, 0, buffer.limit()));
        final byte[] array = buffer.array();
    }

    @Test
    public void testSmallBuffer() {
        byte[] input = new byte[]{0, 1, 2};
        ByteBuffer buffer = ByteBuffer.allocate(5);
        buffer.put(Arrays.copyOfRange(input, 0, buffer.limit()));
        final byte[] array = buffer.array();
    }

    @Test
    public void testMerge() {
        byte[] array0 = new byte[]{};
        byte[] array1 = new byte[]{1};
        byte[] array2 = new byte[]{2, 3};
        byte[] array3 = new byte[]{4, 5, 6};
        final byte[] merged = ByteArrayUtils.merge(array0, array1, array2, array3);
        assertArrayEquals(new byte[]{1, 2, 3, 4, 5, 6, }, merged);
    }


    private static int fromByteArray(byte[] array) {
        return ByteBuffer.wrap(array).getInt();
    }

    private static byte[] fromInt(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }
}
