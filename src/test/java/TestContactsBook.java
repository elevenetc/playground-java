import org.junit.Test;
import su.levenetc.playground.java.datastructures.ContactsBook;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 09/03/2017.
 */
public class TestContactsBook {
    @Test
    public void testAddAndFind() {
        ContactsBook cb = new ContactsBook();
        cb.add("ab");
        cb.add("abc");
        cb.add("a");
        cb.add("x");
        cb.add("xffx");
        cb.add("xff");
        cb.add("sdfh");
        assertEquals(2, cb.find("ab"));
        assertEquals(2, cb.find("xf"));
        assertEquals(3, cb.find("x"));
        assertEquals(1, cb.find("sdfh"));
        assertEquals(0, cb.find("mm"));
    }
}