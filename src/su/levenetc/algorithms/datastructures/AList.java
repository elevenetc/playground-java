package su.levenetc.algorithms.datastructures;

import su.levenetc.algorithms.utils.Out;

import java.util.Arrays;

/**
 * Created by elevenetc on 06/07/15.
 */
public class AList<T> {

	private static final int DEFAULT_SIZE = 16;
	private T[] array;
	private int size;

	public AList(int size) {
		array = (T[]) new Object[size];
	}

	public AList() {
		array = (T[]) new Object[DEFAULT_SIZE];
	}

	/**
	 * O(1)
	 */
	public void add(T value) {
		checkAndIncreaseSize();
		array[size++] = value;
		Out.pln("Element added: " + value);
	}

	/**
	 * O(1)
	 */
	public void set(int index, T value) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(
					"Current size: " + size + " try to add at " + index
			);
		}
		array[index] = value;
	}

	/**
	 * O(1)
	 */
	public T get(int index) {
		//TODO: check param
		return array[index];
	}

	/**
	 * O(n)
	 */
	public T remove(int index) {
		//TODO: check param
		T result = array[index];
		shiftToRight(index);
		this.size--;
		Out.pln("removed: " + result);
		return result;
	}

	public T remove(T value) {
		int index = indexOf(value);
		return remove(index);
	}

	/**
	 * O(n)
	 */
	public boolean contains(T value) {
		return indexOf(value) != -1;
	}

	public int indexOf(T value) {
		for (int i = 0; i < size + 1; i++) {
			if (value == null) {
				if (array[i] == null) return i;
			} else {
				if (value.equals(array[i])) return i;
			}
		}
		return -1;
	}

	@Override public String toString() {
		return "Size:" + getSize() + " data:" + Arrays.toString(array);
	}

	private void checkAndIncreaseSize() {
		if (array.length == size) {
			T[] newArray = (T[]) new Object[array.length * 2];
			for (int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
			Out.pln("size increased. New size:" + array.length);
		}

	}

	private void shiftToRight(int index) {
		if (index + 1 == size) {
			array[index] = null;
			return;
		}
		for (int i = index + 1; i < size + 1; i++) {
			array[i - 1] = array[i];
		}
	}

	public int getSize() {
		return size;
	}
}
