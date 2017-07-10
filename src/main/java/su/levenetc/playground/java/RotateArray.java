package su.levenetc.playground.java;

/**
 * Created by elevenetc on 01/05/15.
 */
public class RotateArray {

    public static int[] rotate(int shift, int... input) {

        if (shift == 0 || shift % input.length == 0) return input;

        if (shift > input.length) {
            shift = shift % input.length;
        }
        int[] result = new int[input.length];
        System.arraycopy(input, 0, result, shift, input.length - shift);
        System.arraycopy(input, input.length - shift, result, 0, shift);

        return result;
    }

}
