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

    public static void fill(ByteBuffer byteBuffer, byte[]... arrays) {
        int cursor = 0;
        final int limit = byteBuffer.limit();
        for (byte[] array : arrays) {
            if (array.length == 0) continue;
            if (cursor >= limit) {
                return;
            } else {

                int length = array.length;

                if (cursor + length > limit) {
                    int extra = cursor + length - limit;
                    length -= extra;
                }

                byteBuffer.put(array, 0, length);
                cursor = cursor + array.length;
            }

        }
    }
}
