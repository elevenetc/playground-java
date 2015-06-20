package su.levenetc.algorithms;

import java.util.Arrays;

/**
 * Created by elevenetc on 01/05/15.
 */
public class RotateArray {

	private int[] input;
	private int k;

	public RotateArray(int[] input, int k) {
		this.input = input;
		this.k = k;
	}

	public RotateArray(int[] input) {
		this.input = input;
	}

	public static void testWholeRotation(int[] input, int[] rotated) {

		int k = rotated.length - 1;
		for (int i = 0; i < input.length; i++) {
			if (input[i] != rotated[k]) {
				throw new RuntimeException("At i=" + i + " input[i]=" + input[i] + " but at k=" + k + " rotated[k]=" + rotated[k] + ". Must be equal!");
			}
			k--;
		}

		System.out.print("\nTest passed! \ninput: " + Arrays.toString(input) + "\nrotated: " + Arrays.toString(rotated) + "\n");
	}

	public static void testPartRotation(int[] input, int shift, int[] rotated) {

	}

	public void rotateWithIntermidiateArray() {

	}

	public int[] rotateWhole() {
		int[] result = new int[input.length];

		for (int i = 0; i < input.length; i++) {
			result[i] = input[input.length - i - 1];
		}

		return result;
	}


}
