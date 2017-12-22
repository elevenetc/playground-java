package su.levenetc.playground.java.algs.graphs;

import java.util.LinkedHashSet;
import java.util.Set;

import su.levenetc.playground.java.utils.Out;

public class PrintAllGraphPaths {
    public static void printPaths(GNode start, GNode destination) {
        printPath(new LinkedHashSet<>(), start, destination);
    }

    private static void printPath(Set<GNode> visited, GNode current, GNode destination) {
        if (visited.contains(current)) return;

        if (destination.equals(current)) {
            for (GNode v : visited) Out.p(v.value + " ");
            Out.p(destination.value);
            Out.pln();
            return;
        }

        visited.add(current);

        for (GNode child : current.children)
            printPath(visited, child, destination);

        visited.remove(current);
    }
}
