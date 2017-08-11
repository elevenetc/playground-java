package su.levenetc.playground.java.navigator;

public class NavigatorSample {

    public static void run() {
        Aaa aaa = new Aaa();
        Bbb bbb = new Bbb();

        //used inside screen
        Navigator.navigateFrom(aaa).toHelp();
        Navigator.navigateFrom(bbb).toMenu();
    }

    //Generated from flow description
    static class Navigator {
        static NavigatorAaa navigateFrom(Aaa inst) {
            return new NavigatorAaa();
        }

        static NavigatorBbb navigateFrom(Bbb inst) {
            return new NavigatorBbb();
        }
    }

    //Generated from flow description
    static class NavigatorAaa {
        void toHelp() {

        }
    }

    //Generated from flow description
    static class NavigatorBbb {
        void toMenu() {

        }
    }

    //Annotated screen
    static class Aaa {

    }

    //Annotated screen
    static class Bbb {

    }
}
