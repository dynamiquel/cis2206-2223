package Portfolio_Challenge.Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueTests {
    static Queue queue;

    @BeforeEach
    void BeforeEach() {
        queue = new LinkedList();
    }

    @Test
    void Enqueue() {
        queue.enqueue("one");

        assertEquals(1, queue.size());
    }

    @Test
    void EnqueueThree() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        assertEquals(3, queue.size());
    }

    @Test
    void GetFirst() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        assertEquals("one", queue.first());
        assertEquals(3, queue.size());
    }

    @Test
    void Dequeue() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        assertEquals("one", queue.dequeue());
        assertEquals(2, queue.size());
    }

    @Test
    void DequeueTwo() {
        queue.enqueue("one");
        queue.enqueue("two");
        queue.enqueue("three");

        assertEquals("one", queue.dequeue());
        assertEquals("two", queue.dequeue());
        assertEquals(1, queue.size());
    }
}
