import org.junit.Test;
import su.levenetc.playground.java.security.ValueCipher;
import su.levenetc.playground.java.utils.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class TestCipher {
    @Test
    public void testInt() {
        final String password = StringUtils.getRandomString(16);
        final ValueCipher valueCipher = new ValueCipher(new ValueCipher.KeyProvider() {
            @Override
            public SecretKey getKey() {
                return new SecretKeySpec(password.getBytes(), "AES");
            }
        }, "AES/CBC/PKCS5Padding");
        final int input = 100;
        final int encrypted = valueCipher.encrypt(input);
        final int decrypted = valueCipher.decrypt(encrypted);
    }
}
