package su.levenetc.playground.java.algs;

import java.nio.ByteBuffer;

public class BitAlgs {

    static int rotate(int value, int shift) {
        if (shift == 0) return value;
        shift = shift % 32;
        if (shift > 0) {
            return rotateRight(value, shift);
        } else {
            return rotateLeft(value, shift * -1);
        }
    }

    static int rotateLeft(int value, int shift) {
        int right = value << shift;
        int left = value >>> (32 - shift);
        return right | left;
    }

    static int rotateRight(int value, int shift) {
        int left = value >>> shift;
        int right = value << (32 - shift);
        return right + left;
    }

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
