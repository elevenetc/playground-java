import su.levenetc.playground.java.algs.InsertionSort;
import su.levenetc.playground.java.algs.SortAlgorithm;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by eleven on 03/09/2016.
 */
public class SortAlgorithmsTest {

	@org.junit.Test
	public void testInsertionAlgorithm() throws Exception {

		InsertionSort algorithm = new InsertionSort();

		testLong(algorithm);
		testBasic(algorithm);
		testOne(algorithm);
		testZero(algorithm);
	}

	private void testLong(SortAlgorithm algorithm) {
		assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5}, algorithm.sort(new int[]{4, 1, 3, 5, 0, 2}));
	}

	private void testBasic(SortAlgorithm algorithm) {
		assertArrayEquals(new int[]{0, 1}, algorithm.sort(new int[]{1, 0}));
	}

	private void testOne(SortAlgorithm algorithm) {
		assertArrayEquals(new int[]{0}, algorithm.sort(new int[]{0}));
	}

	private void testZero(SortAlgorithm algorithm) {
		assertArrayEquals(new int[]{}, algorithm.sort(new int[]{}));
	}

}