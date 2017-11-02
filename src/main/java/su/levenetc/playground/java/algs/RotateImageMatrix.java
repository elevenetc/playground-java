package su.levenetc.playground.java.algs;

public class RotateImageMatrix {

    static int[][] rotate90(int[][] img) {
        int center = img.length / 2 - 1;
        int layer = 0;
        while (layer <= center) {
            rotateLayer(img, layer);
            layer++;
        }
        return img;
    }

    private static void rotateLayer(int[][] img, final int layer) {
        int lastIndex = img.length - 1;
        int left = layer;
        int right = lastIndex - layer;
        while (left < right) {
            rotateCell(img, left, layer);
            left++;
        }
    }

    public static int[][] rotateCell(int[][] img, int col, int row) {
        int lastIndex = img.length - 1;

        int topLeft = img[row][col];
        int topRight = img[col][lastIndex - row];
        int bottomRight = img[lastIndex - row][lastIndex - col];
        int bottomLeft = img[lastIndex - col][row];

        img[col][lastIndex - row] = topLeft;
        img[lastIndex - row][lastIndex - col] = topRight;
        img[lastIndex - col][row] = bottomRight;
        img[row][col] = bottomLeft;

        return img;
    }
}
