package su.levenetc.playground.java.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eugene.levenetc on 08/04/2017.
 */
public class SumCombination {
    public static List<List<Integer>> combinations(int[] candidates, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        final List<Integer> current = new ArrayList<>();

        Arrays.sort(candidates);

        combinationSum(candidates, target, 0, current, result);

        return result;
    }

    private static void combinationSum(int[] candidates, int target, int from, List<Integer> curr, List<List<Integer>> result) {

        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<>(curr);
            result.add(temp);
            return;
        }

        for (int i = from; i < candidates.length; i++) {

            final int check = candidates[i];

            if (target < check)
                return;

            curr.add(check);
            combinationSum(candidates, target - check, i, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}
