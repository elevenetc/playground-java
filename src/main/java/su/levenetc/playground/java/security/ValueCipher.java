package su.levenetc.playground.java.security;


import javax.crypto.*;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static java.util.Base64.getDecoder;
import static java.util.Base64.getEncoder;

/**
 * Created by eugene.levenetc on 27/10/2016.
 */
public class ValueCipher {

    private KeyProvider keyProvider;
    private String alg;

    public ValueCipher(KeyProvider keyProvider, String alg) {
        this.keyProvider = keyProvider;
        this.alg = alg;
    }

    public byte[] encrypt(byte[] value) {
        return encrypt(value, keyProvider.getKey(), alg);
    }

    public byte[] decrypt(byte[] value) {
        return decrypt(value, keyProvider.getKey(), alg);
    }

    public String encrypt(String value) {
        final byte[] encrypted = encrypt(getEncoder().encode(value.getBytes()), keyProvider.getKey(), alg);
        return getEncoder().encodeToString(encrypted);
    }

    public String decrypt(String value) {
        final byte[] decoded = getDecoder().decode(value);
        final byte[] decrypted = decrypt(decoded, keyProvider.getKey(), alg);
        return new String(getDecoder().decode(decrypted));
    }

    private static byte[] encrypt(byte[] value, SecretKey secret, String cipherAlg) {
        try {
            Cipher cipher = Cipher.getInstance(cipherAlg);
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            return cipher.doFinal(value);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException | InvalidKeyException | BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] decrypt(byte[] value, SecretKey secret, String cipherAlg) {
        try {
            Cipher cipher = Cipher.getInstance(cipherAlg);
            cipher.init(Cipher.DECRYPT_MODE, secret);
            return cipher.doFinal(value);
        } catch (NoSuchPaddingException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException | IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }
    }

    private static int fromByteArray(byte[] array) {
        return ByteBuffer.wrap(array).getInt();
    }

    private static byte[] fromInt(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    public interface KeyProvider {
        SecretKey getKey();
    }
}
