package su.levenetc.playground.java.utils;

public class ColorUtils {

    public static int translate(int from, int to, float ratio) {

        if (ratio == 0) return from;
        else if (ratio == 1) return to;

        int f = brightness(from, ratio);
        int t = brightness(to, 1 - ratio);
        return blend(f, t);
    }

    /**
     * @param brightness 0.0 - 1.0
     */
    public static int brightness(int color, float brightness) {
        int r = ((color & 0xff0000) >> 16);
        int g = ((color & 0xff00) >> 8);
        int b = (color & 0xff);

        r *= brightness;
        g *= brightness;
        b *= brightness;

        return r << 16 | g << 8 | b;
    }

    public static int blend(int... c) {
        return blend(1, c);
    }

    /**
     * @param ratio 1 - fully blended, 0 - not blended at all
     */
    public static int blend(float ratio, int... colors) {

        int red = 0;
        int green = 0;
        int blue = 0;

        for (int i = 0; i < colors.length; i++) {
            int rgb = colors[i];
            int r = ((rgb & 0xff0000) >> 16);
            int g = ((rgb & 0xff00) >> 8);
            int b = (rgb & 0xff);
            red += (r * ratio);
            green += (g * ratio);
            blue += (b * ratio);
        }

        return red << 16 | green << 8 | blue;
    }

    /**
     * @param alpha 0 - 255
     */
    public static int setAlpha(int rgb, int alpha) {
        return rgb | (alpha << 24);
    }
}
