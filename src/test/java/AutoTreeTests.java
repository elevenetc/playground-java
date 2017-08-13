import org.junit.Test;

import java.util.Deque;

import su.levenetc.playground.java.autocompletable.BranchBuilder;
import su.levenetc.playground.java.autocompletable.Completable;
import su.levenetc.playground.java.autocompletable.GraphModel;
import su.levenetc.playground.java.autocompletable.SingleNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.autocompletable.BranchBuilder.from;

public class AutoTreeTests {

    @Test
    public void testBasicStack() {
        Completable root = new BranchBuilder()
                .then("a")
                .then("b")
                .then("c")
                .isLast();
        GraphModel model = GraphModel.from(root);
        Deque<Completable> stack = model.stack();
        assertTrue(stack.isEmpty());

        model.complete("a").last();
        Completable last = model.last();
    }

    @Test
    public void test03() {
        BranchBuilder builder = new BranchBuilder();
        Completable tree = builder
                .then("aaa")
                .then("bbb")
                .thenOneOf("xxx", "yyy")
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
                .thenMultiple(FIELDS, "name", "age").dependOn(TABLES)
                .then("from")
                .thenOneOf(TABLES, "students", "teachers")
                .then("limit").isOptional()
                .then("value")
                .isLast();

        Completable insert = from("insert")
                .then("into")
                .thenMultiple(FIELDS, "name", "age")
                .then("into")
                .then("values")
                //TODO: add one value
                .thenMultiple(VALUES, "Maria", "32").dependOn(FIELDS)
                .isLast();

        Completable root = from(select, insert).isLast();

        GraphModel model = new GraphModel(root);

        model
                .completeAndNext("sel")
                .completeAndNext("wh")
                .completeAndNext("n")
                .completeAndNext("from")
                .complete("st");

        assertEquals("students", ((SingleNode) model.last()).getVariant());
        model.pop();
        assertEquals("from", ((SingleNode) model.last()).getVariant());
    }

    @Test
    public void testChangeOneOf() {
        int TABLES = 1;
        Completable root = from("from")
                .thenOneOf(TABLES, "users", "friends")
                .isLast();

        GraphModel cursor = new GraphModel(root);

        cursor = cursor.completeAndNext("fr").complete("us");
        assertEquals("users", ((SingleNode) cursor.last()).getVariant());

        cursor.change(TABLES).to("friends");

        assertEquals("friends", ((SingleNode) cursor.last()).getVariant());
    }
}
