package su.levenetc.playground.java.utils;

public class View {

    public void onCreate() {
        Out.pln("onCreate");
    }

    public void onResume() {
        Out.pln("onResume");
    }

    public void onPause() {
        Out.pln("onPause");
    }

    public void onDestroy() {
        Out.pln("onDestroy");
    }
}
