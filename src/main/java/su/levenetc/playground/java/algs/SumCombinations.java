package su.levenetc.playground.java.algs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.sort;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class SumCombinations {
    public static Set<List<Integer>> combinations(int sum, int... candidates) {
        Set<List<Integer>> result = new HashSet<>();
        sort(candidates);
        combinations(candidates, sum, 0, new LinkedList<>(), result);
        return result;
    }

    private static void combinations(
            int[] candidates,
            int sum,
            int from,
            List<Integer> combination,
            Set<List<Integer>> result
    ) {

        if (sum == 0) {
            List<Integer> list = new LinkedList<>();
            list.addAll(combination);
            result.add(list);
            return;
        }

        for (int ic = from; ic < candidates.length; ic++) {

            int c = candidates[ic];

            if (c > sum) return;

            combination.add(c);
            combinations(candidates, sum - c, ic, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
