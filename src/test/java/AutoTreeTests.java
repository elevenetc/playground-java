import org.junit.Test;

import java.util.List;

import su.levenetc.playground.java.datastructures.AutoTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static su.levenetc.playground.java.datastructures.AutoTree.array;
import static su.levenetc.playground.java.datastructures.AutoTree.branch;
import static su.levenetc.playground.java.datastructures.AutoTree.or;

public class AutoTreeTests {
    @Test
    public void test01() {
        final List<AutoTree> roots = or(
                branch("select")
                        .then("user")
                        .then(array("name", "age"))
                        .then("where"),
                branch("delete from")
        );

        AutoTree selectRoot = roots.get(0);
        assertNotNull(selectRoot.isCompletable("se"));
        assertNull(selectRoot.isCompletable("x"));

        AutoTree user = selectRoot.next();
        assertNotNull(user.isCompletable("us"));

        AutoTree fields = user.next();
        assertNotNull(fields.isCompletable("n"));
        assertNotNull(fields.isCompletable("age"));
    }

    @Test
    public void test02() {

        AutoTree tree = branch("select")
                .then("user")
                .then(array("name", "age"))
                .then("where");

        assertEquals(
                "where",
                tree.autocomplete("sel").autocomplete("us").autocomplete("na").name()
        );

        assertEquals(
                "where",
                tree.autocomplete("sel").autocomplete("user").autocomplete("ag").name()
        );
    }
}
