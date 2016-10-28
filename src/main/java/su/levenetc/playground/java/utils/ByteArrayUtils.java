package su.levenetc.playground.java.utils;

import java.nio.ByteBuffer;

/**
 * Created by eugene.levenetc on 28/10/2016.
 */
public class ByteArrayUtils {
    public static byte[] merge(byte[]... arrays) {
        int size = 0;
        for (byte[] array : arrays) {
            size += array.length;
        }
        ByteBuffer buffer = ByteBuffer.allocate(size);
        for (byte[] array : arrays) {
            buffer.put(array);
        }
        return buffer.array();
    }
}
