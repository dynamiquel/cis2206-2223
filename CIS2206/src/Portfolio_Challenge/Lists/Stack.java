package Portfolio_Challenge.Lists;

// See also: https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html

import Portfolio_Challenge.Collection;

/**
 * The Stack represents a last-in-first-out (LIFO) stack of objects.
 */
public interface Stack extends Collection {

    /**
     * Note: Implement in O(1).
     * Note: Implement the top of the stack at the end of the list.
     * <p>
     * Pushes an item onto the top of this stack.
     *
     * @param element the item to be pushed onto this stack.
     */
    public String push(String element);

    /**
     * Note: Implement in O(1).
     * Note: Implement the top of the stack at the end of the list.
     * <p>
     * Returns the object at the top of this stack without
     * removing it from the stack.
     *
     * @return the object at the top of this stack, or
     * null if this stack is empty
     */
    public String top();

    /**
     * Note: Implement in O(1).
     * Note: Implement the top of the stack at the end of the list.
     * <p>
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @return the object previously at the top of this stack, or
     * null if this stack is empty
     */
    public String pop();

}
