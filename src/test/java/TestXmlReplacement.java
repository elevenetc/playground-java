import org.junit.Test;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 20/09/16.
 */
public class TestXmlReplacement {
    @Test
    public void replace() {
        String targetKey = "payment_failed_pin_not_set";
        String newValue = "new";
        String xml = "<k><string name=\"payment_failed_pin_not_set\">old</string></k>";
        String newReplacement = "<string name=\"" + targetKey + "\">" + newValue + "</string>";
        String regex = "((<string name=\"" + targetKey + ").*(</string>))";

        Out.pln("old:" + xml);
        Out.pln("new:" + xml.replaceFirst(regex, newReplacement));
    }
}