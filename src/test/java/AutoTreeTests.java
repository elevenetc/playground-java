import org.junit.Before;
import org.junit.Test;

import java.util.Deque;

import su.levenetc.playground.java.autocompletable.BranchBuilder;
import su.levenetc.playground.java.autocompletable.FlatModel;
import su.levenetc.playground.java.autocompletable.Node;
import su.levenetc.playground.java.autocompletable.SingleNode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static su.levenetc.playground.java.autocompletable.BranchBuilder.from;

public class AutoTreeTests {

    private static final String varInit = "init";
    private static final String varA = "aaa";
    private static final String varB = "bbb";
    private static final String varC = "ccc";

    private Node branchAbc;
    private FlatModel modelAbc;

    @Before
    public void before() {
        branchAbc = new BranchBuilder()
                .then(varA)
                .then(varB)
                .then(varC)
                .isLast();
        modelAbc = FlatModel.from(branchAbc);
    }

    @Test
    public void testBasicStack() {
        Node root = new BranchBuilder()
                .then("a")
                .then("b")
                .then("c")
                .isLast();
        FlatModel model = FlatModel.from(root);
        Deque<Node> stack = model.stack();
        assertTrue(stack.isEmpty());

        //model.append("a").last();
        Node last = model.last();
    }

    @Test
    public void test03() {
        BranchBuilder builder = new BranchBuilder();
        Node tree = builder
                .then("aaa")
                .then("bbb")
                .thenOneOf("xxx", "yyy")
                .then("ccc")
                .isLast();

        //Node complete = tree.completeAndNext("a").completeAndNext("b").complete("x");
    }

    @Test
    public void test04() {

        final int FIELDS = 1;
        final int TABLES = 2;
        final int VALUES = 3;

        Node select = from("select")
                .then("where")
                .thenMultiple(FIELDS, "name", "age").dependOn(TABLES)
                .then("from")
                .thenOneOf(TABLES, "students", "teachers")
                .then("limit").isOptional()
                .then("value")
                .isLast();

        Node insert = from("insert")
                .then("into")
                .thenMultiple(FIELDS, "name", "age")
                .then("into")
                .then("values")
                //TODO: add one value
                .thenMultiple(VALUES, "Maria", "32").dependOn(FIELDS)
                .isLast();

        Node root = from(select, insert).isLast();

        FlatModel model = new FlatModel(root);

        //model
                //.completeAndNext("sel")
                //.completeAndNext("wh")
                //.completeAndNext("n")
                //.completeAndNext("from")
                //.completeCurrent("st");

        assertEquals("students", ((SingleNode) model.last()).getVariant());
        model.pop();
        assertEquals("from", ((SingleNode) model.last()).getVariant());
    }

    @Test
    public void testChangeOneOf() {
        int TABLES = 1;
        Node root = from("from")
                .thenOneOf(TABLES, "users", "friends")
                .isLast();

        FlatModel cursor = new FlatModel(root);

        //cursor = cursor.completeAndNext("fr").completeCurrent("us");
        assertEquals("users", ((SingleNode) cursor.last()).getVariant());

        cursor.change(TABLES).to("friends");

        assertEquals("friends", ((SingleNode) cursor.last()).getVariant());
    }

    @Test
    public void testCompleteCurrent() {
//        Node last = modelAbc.append("a").last();
//        assertEquals(varA, ((SingleNode) last).getVariant());
    }

    @Test
    public void testCompleteAndNext() {
//        Node last = modelAbc.completeAndNext("a").last();
//        assertEquals(varB, ((SingleNode) last).getVariant());
    }

    @Test
    public void testLastAndRoot() {
        assertTrue(modelAbc.last() instanceof SingleNode);
        assertEquals(varA, ((SingleNode) modelAbc.last()).getVariant());
        assertEquals(varA, ((SingleNode) modelAbc.root()).getVariant());
    }

    @Test
    public void testBasicPop() {

        //modelAbc
                //.completeAndNext("a")
                //.completeAndNext("b")
                //.completeCurrent("c");

        assertEquals(varC, ((SingleNode) modelAbc.last()).getVariant());
        modelAbc.pop();
        assertEquals(varB, ((SingleNode) modelAbc.last()).getVariant());
        modelAbc.pop();
        assertEquals(varA, ((SingleNode) modelAbc.last()).getVariant());

    }
}
