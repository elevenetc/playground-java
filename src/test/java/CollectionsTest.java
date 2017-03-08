import org.junit.Test;
import su.levenetc.playground.java.utils.MathUtils;
import su.levenetc.playground.java.utils.Out;

import java.util.*;

/**
 * Created by eugene.levenetc on 16/02/2017.
 */
public class CollectionsTest {
    @Test
    public void treeSet() {
        TreeSet<Float> treeSet = new TreeSet<>();
        treeSet.add(10f);
        treeSet.add(11f);
        treeSet.add(13f);
        treeSet.add(0f);


        final Float[] floats = treeSet.toArray(new Float[treeSet.size()]);
        Out.pln(treeSet.toString());
    }

    @Test
    public void treeMap() {
        TreeMap<Integer, Object> map = new TreeMap<>();
        map.put(0, "0");
        map.put(10, "10");
        map.put(-1, "-1");

        TreeMap<Integer, Object> iterate = new TreeMap<>();
        final Set<Integer> set = iterate.keySet();
        for (Integer integer : set) {

        }

        for (int i = 0; i < set.size(); i++) {

        }


        HashMap<Integer, Float> anglesSet = new HashMap<>();
        final Set<Map.Entry<Integer, Float>> entrySet = anglesSet.entrySet();
        for (Map.Entry<Integer, Float> entry : entrySet) {

        }

        Out.pln(map.toString());
    }

    @Test
    public void array2d() {
        int[][] array2d = new int[10][2];
        array2d[0][0] = 100;
        array2d[0][1] = 20;

        final int[] point = array2d[0];

        TreeMap<Integer, int[]> pointsMap = new TreeMap<>();
        pointsMap.put(0, point);

        final double v1 = Math.atan2(10, 10);
        final float v = (float) (v1 * 180f) / (float) Math.PI;
    }

    @Test
    public void xxx() {
        final int[][] points = new int[2][2];
        points[0][0] = 1;
        points[0][1] = 1;
        points[1][0] = 2;
        points[1][1] = 2;
        final int i = visiblePoints(points);
    }

    public int visiblePoints(int[][] points) {

        int[] xxx = new int[]{1, 2, 3};
        final int l = xxx.length;

        int result = 1;

        int checkAngle = 45;
        List<Double> anglesSet = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double angle = MathUtils.getAngle(x, y, 1, 0);
            anglesSet.add(angle);
        }

        Collections.sort(anglesSet, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return (int) (o1 - o2);
            }
        });

        Double[] angles = anglesSet.toArray(new Double[anglesSet.size()]);

        for (int i = 0; i < angles.length - 1; i++) {
            double startAngle = angles[i];
            int inside = 1;
            for (int k = i + 1; k < angles.length; k++) {
                if (angles[k] - startAngle <= checkAngle) {
                    inside++;
                } else {
                    break;
                }
            }

            if (inside > result) {
                result = inside;
            }
        }

        return result;
    }

}
