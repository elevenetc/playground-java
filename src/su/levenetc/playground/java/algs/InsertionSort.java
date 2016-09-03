package su.levenetc.playground.java.algs;

/**
 * Created by eleven on 03/09/2016.
 */
public class InsertionSort implements SortAlgorithm {

	@Override public int[] sort(int[] data) {

		for (int i = 1; i < data.length; i++) {

			int position = i;
			int current = data[position];

			while (position > 0 && data[position - 1] > current) {
				data[position] = data[position - 1];
				position--;
			}

			data[position] = current;
		}

		return data;
	}
}
