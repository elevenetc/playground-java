package su.levenetc.playground.java.utils;

import java.util.HashMap;
import java.util.Map;

public class DistributionTester {
    private final int cases;
    private final int amountOfValues;
    private final Call callable;

    public DistributionTester(int cases, int amountOfValues, Call callable) {
        this.cases = cases;
        this.amountOfValues = amountOfValues;
        this.callable = callable;
    }

    public void assertMaxDistribution(float max) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < cases; i++) {
            int result = callable.call();

            if (map.containsKey(result)) {
                map.put(result, map.get(result) + 1);
            } else {
                map.put(result, 1);
            }
        }

        int average = cases / amountOfValues;
        int totalDiff = 0;
        int maxDiff = Integer.MIN_VALUE;
        int minOccur = Integer.MAX_VALUE;
        int maxOccur = Integer.MIN_VALUE;


        for (int value : map.keySet()) {
            int occur = map.get(value);
            int diff = Math.abs(occur - average);
            maxDiff = Math.max(diff, maxDiff);
            minOccur = Math.min(minOccur, occur);
            maxOccur = Math.max(maxOccur, occur);

            totalDiff += diff;
        }

        final int avgDiff = totalDiff / amountOfValues;
        final float distributionPer = avgDiff / (float) average;

        if (distributionPer > max) {

            StringBuilder sb = new StringBuilder();
            sb.append('\n');
            sb.append("average fix: ").append(average).append('\n');
            sb.append("max occur: ").append(maxOccur).append('\n');
            sb.append("min occur: ").append(minOccur).append('\n');
            sb.append("max diff from average: ").append(maxDiff).append('\n');
            sb.append("average diff: ").append(avgDiff);

            throw new RuntimeException("Distribution failed: should be less that " + max + " but was " + distributionPer + "\nDetails: " + sb.toString());
        }
    }

    public interface Call {
        int call();
    }
}
