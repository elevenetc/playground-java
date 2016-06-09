package su.levenetc.playground.java.lang;

/**
 * Created by eugene.levenetc on 09/06/16.
 */
public class MixGeneric {
    public static void run() {
        new ImplBase();
    }

    private static class ImplBase extends CustomBase<A, B> {

        @Override
        ZeroHolder create(int index) {
            if (index == 0) return createA();
            else if (index == 1) return createB();
            return super.create(index);
        }

        @Override
        A createA() {
            return null;
        }

        @Override
        B createB() {
            return null;
        }
    }

    private static class A extends ZeroHolder {

    }

    private static class B extends ZeroHolder {

    }

    ///

    private abstract static class CustomBase<AHolder extends ZeroHolder, BHolder extends ZeroHolder> extends Base<ZeroHolder> {

        @Override
        ZeroHolder create(int index) {
            return null;
        }

        @Override
        void pass(ZeroHolder holder) {

        }

        abstract AHolder createA();

        abstract BHolder createB();
    }

    private static class ZeroHolder extends BaseHolder {

    }

    ///

    private abstract static class Base<H extends BaseHolder> {
        abstract H create(int index);

        abstract void pass(H h);
    }

    private static class BaseHolder {
        public int getId() {
            return 0;
        }
    }
}