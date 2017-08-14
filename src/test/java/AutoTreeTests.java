import org.junit.Before;
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

    private static final String varInit = "init";
    private static final String varA = "aaa";
    private static final String varB = "bbb";
    private static final String varC = "ccc";

    private Completable branchAbc;
    private GraphModel modelAbc;

    @Before
    public void before() {
        branchAbc = new BranchBuilder()
                .then(varA)
                .then(varB)
                .then(varC)
                .isLast();
        modelAbc = GraphModel.from(branchAbc);
    }

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

        model.completeCurrent("a").last();
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
                .completeCurrent("st");

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

        cursor = cursor.completeAndNext("fr").completeCurrent("us");
        assertEquals("users", ((SingleNode) cursor.last()).getVariant());

        cursor.change(TABLES).to("friends");

        assertEquals("friends", ((SingleNode) cursor.last()).getVariant());
    }

    @Test
    public void testCompleteCurrent() {
        Completable last = modelAbc.completeCurrent("a").last();
        assertEquals(varA, ((SingleNode) last).getVariant());
    }

    @Test
    public void testCompleteAndNext() {
        Completable last = modelAbc.completeAndNext("a").last();
        assertEquals(varB, ((SingleNode) last).getVariant());
    }

    @Test
    public void testLastAndRoot() {
        assertTrue(modelAbc.last() instanceof SingleNode);
        assertEquals(varA, ((SingleNode) modelAbc.last()).getVariant());
        assertEquals(varA, ((SingleNode) modelAbc.root()).getVariant());
    }

    @Test
    public void testBasicPop() {

        modelAbc
                .completeAndNext("a")
                .completeAndNext("b")
                .completeCurrent("c");

        assertEquals(varC, ((SingleNode) modelAbc.last()).getVariant());
        modelAbc.pop();
        assertEquals(varB, ((SingleNode) modelAbc.last()).getVariant());
        modelAbc.pop();
        assertEquals(varA, ((SingleNode) modelAbc.last()).getVariant());

    }
}
