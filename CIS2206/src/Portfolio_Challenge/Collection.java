package Portfolio_Challenge;

// See also: https://docs.oracle.com/javase/8/docs/api/java/util/Collection.html

/**
 * A Collection represents a group of objects, known as its elements.
 */
public interface Collection {

    /**
     * Note: Implement in O(1)
     *
     * Returns the number of elements in this collection.
     *
     * @return the number of elements in this collection
     */
    public int size();

    /**
     * Note: Implement in O(1)
     *
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    public boolean isEmpty();

    /**
     * Note: Implement in O(n) for Lists and O(logn) for Trees
     *
     * Returns true if this collection contains the specified element.
     *
     * @param element element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     */
    public boolean contains(String element);

}
