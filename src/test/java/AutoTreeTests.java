import org.junit.Test;

import su.levenetc.playground.java.autocompletable.BranchBuilder;
import su.levenetc.playground.java.autocompletable.Completable;
import su.levenetc.playground.java.autocompletable.SingleNode;

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

        Completable select = from("select")
                .then("where")
                .then("name", "age")
                .then("from")
                .then("students", "teachers")
                .isLast();
        Completable insert = from("insert")
                .then("into")
                .then("name", "age")
                .then("into")
                .then("values")
                .then("data")
                .isLast();

        Completable root = from(select, insert).isLast();

        Completable students = root
                .completeAndNext("sel")
                .completeAndNext("wh")
                .completeAndNext("n")
                .completeAndNext("from")
                .complete("st");

        assertEquals("students", ((SingleNode) students).getVariant());
    }
}
