package su.levenetc.playground.java.algs;

/**
 * Created by eugene.levenetc on 22/06/2017.
 */
public class RotateMatrix {
    public static int[][] rotate(int[][] m) {
        final int w = m.length - 1;
        final int layers = m.length / 2;

        int currentLayer = 0;
        int currentWidth = m.length - 1;

        while (currentLayer < layers) {


            for (int i = currentLayer; i < currentWidth; i++) {
                int leftTop = m[currentLayer][i];
                int rightTop = m[i][w - currentLayer];
                int rightBottom = m[w - currentLayer][w - i];
                int leftBottom = m[w - i][currentLayer];

                m[currentLayer][i] = leftBottom;
                m[i][w - currentLayer] = leftTop;
                m[w - currentLayer][w - i] = rightTop;
                m[w - i][currentLayer] = rightBottom;
            }

            currentWidth--;
            currentLayer++;
        }
        return m;
    }
}
