package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

/**
 * Created by elevenetc on 01/08/15.
 */
public class LList<T> {

	private Node<T> first;
	private Node<T> last;
	private int size;

	public void add(T value) {

		Node<T> newNode = new Node<>(value);


		if (first == null && last == null) {
			newNode.next = newNode;
			first = last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}

		size++;
	}

	public boolean contains(T value) {
		if (size == 0) return false;

		Node<T> n = first;
		while (n != null) {

			if (n.value.equals(value)) {
				return true;
			}

			n = n.next;
		}

		return false;
	}

	public boolean remove(T value) {
		Out.pln("remove: " + value);
		if (size == 0) return false;
		if (size == 1 && first.value.equals(value)) {
			first = null;
			last = null;
			size--;
			return true;
		}

		Node<T> n = first;
		Node prev = null;
		while (n != null) {
			if (n.value.equals(value)) {
				if (prev != null) {
					prev.next = n.next;
				} else {
					first = n.next;
				}

				size--;
				return true;
			}
			prev = n;
			n = n.next;
		}
		return false;
	}

	public int getSize() {
		return size;
	}

	@Override public String toString() {

		Node n = first;
		StringBuilder sb = new StringBuilder();
		sb.append("SizeComponent: " + size + " [");
		while (n != null) {
			sb.append(n);
			if (n.next != null) sb.append(",");
			n = n.next;
		}
		sb.append("]");
		return sb.toString();
	}

	private static class Node<T> {

		private Node<T> next;
		private T value;

		public Node(T value) {
			this.value = value;
		}

		@Override public String toString() {
			return "Node(" + value.toString() + ")";
		}
	}
}
