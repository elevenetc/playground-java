package su.levenetc.playground.java.datastructures;


/**
 * Created by eleven on 30/01/2016.
 */
public class BST<K extends Comparable<? super K>, V> {

	private Node root;

	public void put(K key, V value) {
		if (key == null) throw new NullPointerException("Key must not be null.");

		Node parent = findParent(root, key);

		if (parent == null) {
			root = new Node(key, value, null);
		} else {
			if (key.compareTo(parent.key) > 0) {
				parent.right = new Node(key, value, parent);
			} else {
				parent.left = new Node(key, value, parent);
			}
		}
	}

	public void remove(K key) {
		Node toDel = findNode(root, key);
		if (toDel != null) {
			if (toDel.isLeaf()) {
				toDel.parent.removeChild(toDel);
			} else if (toDel.hasOnlyOneChild()) {
				if (toDel.left != null) {
					toDel.parent.replace(toDel, toDel.left);
				} else if (toDel.right != null) {
					toDel.parent.replace(toDel, toDel.right);
				}
			} else {
				Node minimum = findMinimum(toDel);
				toDel.parent.replace(toDel, minimum);
			}
		}
	}

	public V get(K key) {
		return find(key, root);
	}

	public Node getRoot() {
		return root;
	}

	public K findMinimum() {
		Node minimum = findMinimum(root);
		return minimum.key;
	}

	private Node findMinimum(Node node) {
		if (node == null) return null;
		if (node.left == null) return node;
		return findMinimum(node.left);
	}

	private Node findNode(Node node, K key) {
		if (node == null) return null;
		if (key.equals(node.key)) return node;

		if (node.left != null && key.compareTo(node.left.key) <= 0) {
			return findNode(node.left, key);
		}

		if (node.right != null && key.compareTo(node.right.key) >= 0) {
			return findNode(node.right, key);
		}

		return null;
	}

	private V find(K key, Node node) {
		if (node.key.equals(key)) {
			return node.value;
		} else {


			if (node.left != null) {

				if (key.equals(node.left.key)) {
					return node.left.value;
				} else if (key.compareTo(node.left.key) < 0) {
					return find(key, node.left);
				}

			}

			if (node.right != null) {

				if (key.equals(node.right.key)) {
					return node.right.value;
				} else if (key.compareTo(node.right.key) > 0) {
					return find(key, node.right);
				}

			}

			return null;
		}
	}

	private Node findParent(Node parent, K key) {
		if (parent == null) return null;
		if (parent.left == null && parent.right == null) return parent;

		if (parent.left != null) {
			if (key.compareTo(parent.left.key) < 0) {
				return findParent(parent.left, key);
			}
		}

		if (parent.right != null) {
			if (key.compareTo(parent.right.key) > 0) {
				return findParent(parent.right, key);
			}
		}

		return parent;

	}

	public class Node {
		Node parent;
		Node left;
		Node right;
		V value;
		K key;

		public Node(K key, V value, Node parent) {
			this.value = value;
			this.key = key;
			this.parent = parent;
		}

		public boolean isLeaf() {
			return left == null && right == null;
		}

		public void removeChild(Node node) {
			if (node == left) {
				left = null;
			} else if (node == right) {
				right = null;
			}
		}

		boolean hasOnlyOneChild() {
			return (left == null && right != null) || (left != null && right == null);
		}

		@Override public String toString() {
			return "Node{" +
					"key=" + key +
					", value=" + value +
					", isLeaf=" + isLeaf() +
					'}';
		}

		public void replace(Node someChild, Node newChild) {
			if (someChild == left) {
				left = newChild;
			} else if (someChild == right) {
				right = newChild;
			}
		}
	}

}
