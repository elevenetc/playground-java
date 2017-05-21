package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by eugene.levenetc on 18/05/2017.
 */
public class CircularWalk {

    public static int find(int from, int to, int[] dists) {
        return find(dists.length, from, to, 0, 0, 0, 0, dists);
    }

    public static int find(int points, int from, int to, int r0, int g, int seed, int p, int[] dists) {
        if (from == to) return 0;
        int steps[] = new int[points];
        Node[] nodes = new Node[points];
        steps[0] = r0;
        if (buildGraph(points, r0, g, seed, p, steps, nodes, from, dists)) {
            return findSteps(nodes, from, to);
        } else {
            return -1;
        }
    }

    private static boolean buildGraph(int points, int r0, int g, int seed, int p, int[] steps, Node[] nodes, int from, int[] dists) {
        for (int i = 0; i < points; i++) {

            Node node = nodes[i];
            if (node == null) {
                node = new Node(i);
                nodes[i] = node;
            }

            int stepsAmount;
            if (dists == null) {
                if (i == 0) stepsAmount = r0;
                else stepsAmount = (steps[i - 1] * g + seed) % p;
            } else {
                stepsAmount = dists[i];
            }

            steps[i] = stepsAmount;


            if (i == from && stepsAmount == 0) return false;
            if (stepsAmount == 0) continue;

            if (stepsAmount > points - 1) {
                stepsAmount = points - 1;
            }

            int rightStepIndex = i;
            int leftStepIndex = i;

            while (stepsAmount > 0) {

                Node child;

                ///right
                rightStepIndex++;

                if (rightStepIndex == points) {
                    rightStepIndex = 0;
                }

                child = nodes[rightStepIndex];
                if (child == null) {
                    nodes[rightStepIndex] = new Node(rightStepIndex);
                    child = nodes[rightStepIndex];
                }

                node.right.add(child);

                ///left
                leftStepIndex--;

                if (leftStepIndex < 0) {
                    leftStepIndex = points - 1;
                }

                child = nodes[leftStepIndex];
                if (child == null) {
                    nodes[leftStepIndex] = new Node(leftStepIndex);
                    child = nodes[leftStepIndex];
                }

                node.left.add(child);

                stepsAmount--;
            }
        }
        return true;
    }

    static int findSteps(Node[] nodes, int from, int to) {
        final Node node = nodes[from];

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes.length];
        int[] distances = new int[nodes.length];
        visited[from] = true;
        distances[from] = 0;
        queue.add(node);

        while (!queue.isEmpty()) {

            final Node poll = queue.poll();

            if (willFindOnLeft(node, node.left, to)) {
                return distances[poll.value] + 1;
            }

            if (willFindOnRight(node, node.right, to)) {
                return distances[poll.value] + 1;
            }

            if (!poll.left.isEmpty()) {

                for (Node child : poll.left) {
                    if (child.value == to) {
                        return distances[poll.value] + 1;
                    }

                    if (!visited[child.value]) {
                        visited[child.value] = true;
                        distances[child.value] = distances[poll.value] + 1;

                        queue.add(child);
                    }
                }
            }

            if (!poll.right.isEmpty()) {

                for (Node child : poll.right) {
                    if (child.value == to) {
                        return distances[poll.value] + 1;
                    }

                    if (!visited[child.value]) {
                        visited[child.value] = true;
                        distances[child.value] = distances[poll.value] + 1;
                        queue.add(child);
                    }
                }
            }
        }
        return -1;
    }

    static boolean willFindOnRight(Node node, List<Node> children, int to) {
        if (children.isEmpty()) return false;
        if (node.value + children.size() >= to) {
            return true;
        } else {
            return false;
        }
    }

    static boolean willFindOnLeft(Node node, List<Node> children, int to) {
        if (children.isEmpty()) return false;
        if (node.value + children.size() >= to) {
            return true;
        } else {
            return false;
        }
    }

    static boolean isInRightZone(int from, int steps, int target, int total) {
        return false;
    }

    static class Node {
        List<Node> left = new ArrayList<>();
        List<Node> right = new ArrayList<>();
        int value;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
