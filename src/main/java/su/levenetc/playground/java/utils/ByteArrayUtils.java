package su.levenetc.playground.java.utils;

import java.nio.ByteBuffer;

/**
 * Created by eugene.levenetc on 28/10/2016.
 */
public class ByteArrayUtils {

    /**
     * Only for tests purposes
     *
     * @param values should be byte values
     * @return
     */
    public static byte[] array(int... values) {
        byte[] result = new byte[values.length];
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            result[i] = (byte) value;
        }
        return result;
    }

    public static boolean areLastBytesEqual(byte[] source, byte[] last) {
        if (source.length == 0) return false;
        if (last.length == 0) return true;
        if (source.length < last.length) return false;
        int sourceIndex = source.length - 1;
        for (int i = last.length - 1; i >= 0; i--) {
            if (last[i] != source[sourceIndex]) return false;
            sourceIndex--;
        }
        return true;
    }

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
