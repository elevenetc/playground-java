package su.levenetc.playground.java.algs;

import su.levenetc.playground.java.utils.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eleven on 07/02/2016.
 * http://www.careercup.com/question?id=5203402797613056
 */
public class SquareDuplicates {
	public static void run() {
		int[] arraySquares = new int[]{3, 1, 4, 5, 19, 6};
		Integer[] array = new Integer[]{14, 9, 19, 22, 36, 8, 0, 64, 25};

		Out.pln(find(arraySquares, Arrays.asList(array)));
	}

	private static List<Integer> find(int[] squares, List<Integer> array) {

		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < squares.length; i++) {
			squares[i] = squares[i] * squares[i];
			if(array.contains(squares[i])) result.add(squares[i]);
		}

//		for (int i = 0; i < squares.length; i++) {
//			if (array.contains(squares[i])) result.add(squares[i]);
//		}

		return result;
	}


}
