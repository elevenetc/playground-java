package su.levenetc.playground.java.datastructures;

import su.levenetc.playground.java.utils.Out;

import java.util.*;

/**
 * Created by eleven on 30/01/2016.
 */
public class TestBST {

	private static HashMap<Integer, List<BST.Node>> depthMap = new HashMap<>();

	public static void run() {
		BST<Integer, String> bst = new BST<>();
		bst.put(0, "A");
		bst.put(-1, "B");
		bst.put(1, "C");
		bst.put(-2, "D");
		bst.put(2, "E");

//		printBst(bst);
//		findMinimum(bst);
//		bst.remove(2);
//		printBst(bst);

//		testFind(bst);
		traverse(bst);
	}

	private static boolean isBST(BST<Integer, String>.Node node, int min, int max) {
		if (node == null) return true;
		if (node.key > max && node.key < min) {
			return false;
		} else {
			return isBST(node.left, min, node.left.key) && isBST(node.right, node.right.key, max);
		}
	}

	private static void findMinimum(BST<Integer, String> bst) {
		Integer minimum = bst.findMinimum();
		Out.pln("Minumu:" + minimum);
	}

	private static void testFind(BST<Integer, String> bst) {
		testFind(0, bst);
		testFind(-1, bst);
		testFind(1, bst);
		testFind(-3, bst);
	}

	private static void traverse(BST<Integer, String> bst) {
		Out.pln("Traverse PreOrder:");
		traversePreOrder(bst.getRoot());

		Out.pln("Traverse inOrder:");
		traverseInOrder(bst.getRoot());

		Out.pln("Traverse PostOrder:");
		traversePostOrder(bst.getRoot());

		Out.pln("Traverse Level:");
		traverseLevel(bst);
	}

	private static <K extends Comparable<? super K>, V> void testFind(K key, BST<K, V> bst) {
		Out.pln("find key:" + key + " found:" + bst.get(key));
	}

	private static void traversePreOrder(BST.Node node) {
		if (node == null) return;
		Out.pln(node);
		traverseInOrder(node.left);
		traverseInOrder(node.right);
	}

	private static void traverseLevel(BST<Integer, String> bst) {
		Queue<BST.Node> queue = new LinkedList<>();

		BST<Integer, String>.Node node = bst.getRoot();
		queue.add(node);

		while (!queue.isEmpty()) {

			BST.Node polled = queue.poll();
			Out.p(polled.value);

			if (polled.left != null) {
				queue.add(polled.left);
			}

			if (polled.right != null) {
				queue.add(polled.right);
			}
		}
	}

	private static void traversePostOrder(BST.Node node) {
		if (node == null) return;
		traverseInOrder(node.left);
		traverseInOrder(node.right);
		Out.pln(node);
	}

	private static void traverseInOrder(BST.Node node) {
		if (node == null) return;
		traverseInOrder(node.left);
		Out.pln(node);
		traverseInOrder(node.right);
	}

	private static void printBst(BST bst) {
		depthMap.clear();
		createDepthMap(bst.getRoot(), 0);
		Iterator<Map.Entry<Integer, List<BST.Node>>> iterator = depthMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, List<BST.Node>> next = iterator.next();

			List<BST.Node> nodes = next.getValue();
			Out.p("level: " + next.getKey() + " ");
			for (BST.Node node : nodes) {
				Out.p(node);
			}
			Out.newLine();
		}
	}

	private static void createDepthMap(BST.Node node, int depth) {
		if (node == null) return;
		List<BST.Node> nodes = depthMap.get(depth);
		if (nodes == null) {
			nodes = new ArrayList<>();
			depthMap.put(depth, nodes);
		}
		nodes.add(node);

		depth++;
		createDepthMap(node.left, depth);
		createDepthMap(node.right, depth);
	}
}
