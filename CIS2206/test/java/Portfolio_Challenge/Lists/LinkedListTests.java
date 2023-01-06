package Portfolio_Challenge.Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTests {
    static List list;

    @BeforeEach
    void BeforeEach() {
        list = new LinkedList();
    }

    @Test
    void InitialiseList() {
        assertEquals(0, list.size());
        assertNull(list.first());
        assertNull(list.last());
    }

    @Test
    void AddNodeToList() {
        list.add(0, "one");

        assertEquals("one", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void AddNodeAfterNode() {
        list.add(0, "one");
        list.add(1, "two");

        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void AddNodeBeforeNode() {
        list.add(0, "one");
        list.add(0, "two");

        assertEquals("two", list.get(0));
        assertEquals("one", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void AddFirst() {
        list.addFirst("one");

        assertEquals("one", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void AddFirstThree() {
        list.addFirst("one");
        list.addFirst("two");
        list.addFirst("three");

        assertEquals("one", list.get(2));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(0));
        assertEquals(3, list.size());
    }

    @Test
    void AddFirst100() {
        for (int i = 0; i < 100; i++) {
            list.addFirst(Integer.toString(i));
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.toString(i), list.get(99 - i));
        }
    }

    @Test
    void AddLast() {
        list.addLast("one");

        assertEquals("one", list.get(0));
        assertEquals(1, list.size());
    }

    @Test
    void AddLastThree() {
        list.addLast("one");
        list.addLast("two");
        list.addLast("three");

        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void AddLast100() {
        for (int i = 0; i < 100; i++) {
            list.addLast(Integer.toString(i));
        }

        for (int i = 0; i < 100; i++) {
            assertEquals(Integer.toString(i), list.get(i));
        }
    }

    @Test
    void RemoveNonEdgeNodeByIndex() {
        list.addFirst("one");
        list.addLast("three");
        list.addFirst("two");

        assertEquals("one", list.remove(1));
        assertEquals(2, list.size());
    }

    @Test
    void RemoveNodeByElement() {
        list.addFirst("one");
        list.addLast("three");
        list.addFirst("two");

        assertTrue(list.remove("two"));
        assertFalse(list.contains("two"));
        assertEquals(2, list.size());
    }

    @Test
    void RemoveFirst() {
        list.addFirst("one");
        list.addLast("three");
        list.addFirst("two");

        assertEquals("two", list.removeFirst());
        assertEquals(2, list.size());
    }

    @Test
    void RemoveLast() {
        list.addFirst("one");
        list.addLast("three");
        list.addFirst("two");

        assertEquals("three", list.removeLast());
        assertEquals(2, list.size());
    }

    @Test
    void RemoveAll() {
        list.addFirst("one");
        list.addLast("three");
        list.addFirst("two");

        list.removeFirst();
        list.removeFirst();
        list.removeFirst();

        assertEquals(0, list.size());
        assertNull(list.first());
        assertNull(list.last());

        // An exception is expected.
        boolean exception = false;
        try {
            list.get(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = true;
        }
        
        assertTrue(exception);
    }
}
