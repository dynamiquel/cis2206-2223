package Portfolio_Challenge.Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StackTests {
    static Stack stack;

    @BeforeEach
    void BeforeEach() {
        stack = new LinkedList();
    }

    @Test
    void Push() {
        stack.push("one");

        assertEquals(1, stack.size());
    }

    @Test
    void PushThree() {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals(3, stack.size());
    }

    @Test
    void GetTop() {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("three", stack.top());
        assertEquals(3, stack.size());
    }

    @Test
    void Pop() {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("three", stack.pop());
        assertEquals(2, stack.size());
    }

    @Test
    void PopTwo() {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("three", stack.pop());
        assertEquals("two", stack.pop());
        assertEquals(1, stack.size());
    }

    @Test
    void PopAll() {
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals("three", stack.pop());
        assertEquals("two", stack.pop());
        assertEquals("one", stack.pop());
        assertEquals(0, stack.size());
    }
}
