import org.junit.Before;
import org.junit.Test;
import su.levenetc.playground.java.datastructures.FileSys;
import su.levenetc.playground.java.utils.Utils;

import static org.junit.Assert.assertEquals;

/**
 * Created by eugene.levenetc on 27/05/2017.
 */
public class FileSysTests {

    private FileSys fileSys;

    @Before
    public void before() {
        fileSys = new FileSys();
    }

    @Test
    public void test01() {
        fileSys.createFile("hello");
        fileSys.createFile("hello");
        fileSys.createFile("hello");
        assertEquals(Utils.set("hello", "hello(1)", "hello(2)"), fileSys.getFiles());
    }

    @Test
    public void test02() {
        fileSys.createFile("hello");
        fileSys.createFile("hello");
        fileSys.createFile("hello");
        fileSys.deleteFile("hello(1)");
        assertEquals(Utils.set("hello", "hello(2)"), fileSys.getFiles());
    }

    @Test
    public void test03() {
        fileSys.createFile("hello");
        fileSys.createFile("hello");
        fileSys.createFile("hello");
        fileSys.deleteFile("hello(1)");
        fileSys.rename("hello(2)", "xxx");
        assertEquals(Utils.set("hello", "xxx"), fileSys.getFiles());
    }
}
