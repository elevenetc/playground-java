import org.junit.Test;

import su.levenetc.playground.java.autocompletable.BranchBuilder;
import su.levenetc.playground.java.autocompletable.Completable;
import su.levenetc.playground.java.autocompletable.SingleNode;
import su.levenetc.playground.java.autocompletable.TreeCursor;

import static org.junit.Assert.assertEquals;
import static su.levenetc.playground.java.autocompletable.BranchBuilder.from;

public class AutoTreeTests {

    @Test
    public void test02() {
        BranchBuilder builder = new BranchBuilder();
        Completable root = builder.then("a").then("b").then("c").isLast();
    }

    @Test
    public void test03() {
        BranchBuilder builder = new BranchBuilder();
        Completable tree = builder
                .then("aaa")
                .then("bbb")
                .then("xxx", "yyy")
                .then("ccc")
                .isLast();

        Completable complete = tree.completeAndNext("a").completeAndNext("b").complete("x");
    }

    @Test
    public void test04() {

        final int FIELDS = 1;
        final int TABLES = 2;
        final int VALUES = 3;

        Completable select = from("select")
                .then("where")
                .then(FIELDS, "name", "age").dependOn(TABLES)
                .then("from")
                .then(TABLES, "students", "teachers")
                .then("limit").isOptional()
                .then("value")
                .isLast();

        Completable insert = from("insert")
                .then("into")
                .then(FIELDS, "name", "age")
                .then("into")
                .then("values")
                .then(VALUES, "Maria", "32").dependOn(FIELDS)
                .isLast();

        Completable root = from(select, insert).isLast();

        TreeCursor cursor = new TreeCursor(root);

        cursor
                .completeAndNext("sel")
                .completeAndNext("wh")
                .completeAndNext("n")
                .completeAndNext("from")
                .complete("st");

        assertEquals("students", ((SingleNode) cursor.current()).getVariant());
        cursor.pop();
        assertEquals("from", ((SingleNode) cursor.current()).getVariant());
    }
}
