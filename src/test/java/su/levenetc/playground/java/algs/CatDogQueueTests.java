package su.levenetc.playground.java.algs;

import org.junit.Test;

import su.levenetc.playground.java.algs.stacks.CatDogQueue;
import su.levenetc.playground.java.algs.stacks.CatDogQueue.Cat;
import su.levenetc.playground.java.algs.stacks.CatDogQueue.Dog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CatDogQueueTests {
    @Test
    public void test() {

        Dog d0 = new Dog("d0");
        Dog d1 = new Dog("d1");
        Cat c0 = new Cat("c0");
        Cat c1 = new Cat("c1");
        Cat c2 = new Cat("c2");
        CatDogQueue queue = new CatDogQueue();

        assertTrue(queue.isEmpty());

        queue.enqueue(d0);
        queue.enqueue(c0);
        queue.enqueue(d1);
        queue.enqueue(c1);
        queue.enqueue(c2);

        assertEquals(d0, queue.dequeueAny());
        assertEquals(c0, queue.dequeueAny());
        assertEquals(d1, queue.dequeueAny());
        assertEquals(c1, queue.dequeueAny());
        assertEquals(c2, queue.dequeueAny());

        assertTrue(queue.isEmpty());
    }
}
