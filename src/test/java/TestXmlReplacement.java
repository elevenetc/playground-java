import org.junit.Test;
import su.levenetc.playground.java.utils.Out;

/**
 * Created by eugene.levenetc on 20/09/16.
 */
public class TestXmlReplacement {
    @Test
    public void replace() {
        final String xml = "<k><string name=\"payment_failed_pin_not_set\">old</string></k>";
        final String key = "payment_failed_pin_not_set";
        final String newValue = "new";

        Out.pln("old:" + xml);
        Out.pln("new:" + replaceKey(xml, key, newValue));
    }

    private static String replaceKey(String xml, String key, String newValue) {
        String newReplacement = "<string name=\"" + key + "\">" + newValue + "</string>";
        String regex = "((<string name=\"" + key + ").*(</string>))";
        return xml.replaceFirst(regex, newReplacement);
    }
}