import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

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

    @Test
    public void testConversion(){
        int intValue = -860743914;
        final byte[] bytes = fromInt(intValue);
        final int convertedInt = fromByteArray(bytes);
        assertEquals(intValue, convertedInt);
    }

    private void testCipher(){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            if(cipher == null){

            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    private static int fromByteArray(byte[] array) {
        return ByteBuffer.wrap(array).getInt();
    }

    private static byte[] fromInt(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }
}
