package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by eugene.levenetc on 18/05/2017.
 */
public class CircularWalk {
    public static int find(int points, int from, int to, int r0, int g, int seed, int p) {
        int steps[] = new int[points];
        Node[] nodes = new Node[points];
        steps[0] = r0;

        for (int i = 0; i < points; i++) {

            Node node = nodes[i];
            if (node == null) {
                node = new Node(i);
                nodes[i] = node;
            }

            int stepsAmount;
            if (i == 0) stepsAmount = r0;
            else stepsAmount = (steps[i - 1] * g + seed) % p;
            steps[i] = stepsAmount;

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

        return findSteps(nodes, from, to);
    }

    static int findSteps(Node[] nodes, int from, int to) {
        int result = 0;
        final Node node = nodes[from];

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[nodes.length];
        visited[from] = true;
        queue.add(node);

        while (!queue.isEmpty()) {

            final Node poll = queue.poll();
            boolean wasStep = false;

            if (!poll.left.isEmpty()) {

                for (Node child : poll.left) {
                    if (child.value == to) {
                        return ++result;
                    }

                    if (!visited[child.value]) {
                        visited[child.value] = true;

                        queue.add(child);
                    }
                }

                wasStep = true;
            }

            if (!poll.right.isEmpty()) {

                for (Node child : poll.right) {
                    if (child.value == to) {
                        return ++result;
                    }

                    if (!visited[child.value]) {
                        visited[child.value] = true;
                        queue.add(child);
                    }
                }
                wasStep = true;
            }

            if (wasStep) {
                result++;
            }
        }
        return 0;
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
