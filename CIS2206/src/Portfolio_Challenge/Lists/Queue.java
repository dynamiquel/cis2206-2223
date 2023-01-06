package Portfolio_Challenge.Lists;

// See also: https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html

import Portfolio_Challenge.Collection;

/**
 * The Queue represents a first-in-first-out (FIFO) queue of objects.
 */
public interface Queue extends Collection {

    /**
     * Note: Implement in O(1)
     *
     * Inserts the specified element into this queue
     *
     * @param element the element to add
     */
    public boolean enqueue(String element);

    /**
     * Note: Implement in O(1)
     *
     * Retrieves, but does not remove, the head of this queue, or
     * returns null if this queue is empty.
     *
     * @return the object at the head of this queue, or
     * null if this queue is empty
     */
    public String first();

    /**
     * Note: Implement in O(1)
     *
     * Retrieves and removes the head of this queue, or returns null
     * if this queue is empty.
     *
     * @return the object previously at the head of this queue, or
     * null if this queue is empty
     */
    public String dequeue();

}
