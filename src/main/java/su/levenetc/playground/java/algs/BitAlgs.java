package su.levenetc.playground.java.algs;

import java.nio.ByteBuffer;

public class BitAlgs {

    public static byte[] intToByte(int i) {
        return new byte[]{
                (byte) (i >>> 24),
                (byte) ((i << 8) >>> 24),
                (byte) ((i << 16) >>> 24),
                (byte) ((i << 24) >>> 24)
        };
    }

    public static int byteToInt(byte[] bytes) {
        return bytes[3] & 0xFF
                | (bytes[2] & 0xFF) << 8
                | (bytes[1] & 0xFF) << 16
                | (bytes[0] & 0xFF) << 24;
    }


    public static byte[] floatToByte(float value) {
        return ByteBuffer.allocate(4).putFloat(value).array();
    }

    public static float byteToFloat(byte[] array) {
        return ByteBuffer.wrap(array).getFloat();
    }

    public static int bitCountIterative(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }

    public static int setBit(int value, int bit) {
        return value | (1 << bit);
    }

    static boolean getBit(int value, int bit) {
        return value == ((1 << bit) | value);
    }

    static int deleteBit(int value, int bit) {
        return value & ~(1 << bit);
    }
}
