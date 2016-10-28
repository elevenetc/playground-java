import org.junit.Before;
import org.junit.Test;
import su.levenetc.playground.java.security.ValueCipher;
import su.levenetc.playground.java.utils.StringUtils;

import javax.crypto.spec.SecretKeySpec;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class TestCipher {
    
    private ValueCipher valueCipher;

    @Before
    public void before() {
        final String password = StringUtils.getRandomString(16);
        valueCipher = new ValueCipher(() -> new SecretKeySpec(password.getBytes(), "AES"), "AES/ECB/PKCS5Padding");
    }

    @Test
    public void testByteArray() {
        final byte[] input = {1, 2, 3, 4};
        final byte[] encrypted = valueCipher.encrypt(input);
        final byte[] decrypted = valueCipher.decrypt(encrypted);
        assertArrayEquals(input, decrypted);
    }

    @Test
    public void testString() {
        final String input = "hello";
        final String encrypted = valueCipher.encrypt(input);
        final String decrypted = valueCipher.decrypt(encrypted);
        assertEquals(input, decrypted);
    }
}
