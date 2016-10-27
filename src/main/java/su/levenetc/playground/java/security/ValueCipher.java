package su.levenetc.playground.java.security;

import javax.crypto.*;
import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

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

    public int encrypt(int value) {
        final byte[] array = fromInt(value);
        final byte[] encryptedByteArray = encrypt(array, keyProvider.getKey(), alg);
        final int encryptedInt = fromByteArray(encryptedByteArray);
        return encryptedInt;
    }

    public int decrypt(int value) {
        final byte[] byteArray = fromInt(value);
        final byte[] decryptedByteArray = decrypt(byteArray, keyProvider.getKey(), alg);
        final int decryptedInt = fromByteArray(decryptedByteArray);
        return decryptedInt;
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
