package su.levenetc.algorithms.datastructures;

import java.util.Arrays;

/**
 * Created by elevenetc on 06/07/15.
 */
public class AList<T> {
	private int index;
	private Object[] array;

	public AList() {
		array = new Object[16];
	}

	public void add(T value) {
		array[index++] = value;
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T) array[index];
	}

	@SuppressWarnings("unchecked")
	public void delete(int index) {
		array[index] = null;
	}

	@SuppressWarnings("unchecked")
	public T pop() {
		T result = (T) array[--index];
		array[index] = null;
		return result;
	}

	@Override public String toString() {
		return "Index: " + index + " data: " + Arrays.toString(array);
	}
}
