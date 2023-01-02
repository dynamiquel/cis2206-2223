package Portfolio_Challenge.Lists;

// See also: https://docs.oracle.com/javase/8/docs/api/java/util/List.html

import Portfolio_Challenge.Collection;

/**
 * The List represents an ordered collection (or sequence) of objects.
 */
public interface List extends Collection {

    /* Add element */

    /**
     * Note: Implement in O(1)
     *
     * Inserts the specified element at the beginning of this list
     *
     * @param element element to be inserted
     */
    public boolean addFirst(String element);

    /**
     * Note: Implement in O(1)
     *
     * Inserts the specified element at the end of this list
     *
     * @param element element to be inserted
     */
    public boolean addLast(String element);

    /**
     * Note: Implement in O(n)
     *
     * Inserts the specified element at the specified position in this list,
     * if it is within valid range.
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @return true if element was added to the list
     */
    public boolean add(int index, String element);

    /* Get element */

    /**
     * Note: Implement in O(1)
     *
     * Returns the element at the beginning of this list or null
     * for an empty list.
     *
     * @return the element at the beginning of this list
     */
    public String first();

    /**
     * Note: Implement in O(1)
     *
     * Returns the element at the end of this list or null
     * for an empty list.
     *
     * @return the element at the end of this list
     */
    public String last();

    /**
     * Note: Implement in O(n)
     *
     * Returns the element at the specified position in this list, if
     * it is within valid range, or null otherwise.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public String get(int index);

    /* Remove element */

    /**
     * Note: Implement in O(1)
     *
     * Removes the element at the beginning of this list
     *
     * @return the element previously at the beginning of this list
     */
    public String removeFirst();

    /**
     * Note: Implement in O(1)
     *
     * Removes the element at the end of this list
     *
     * @return the element previously at the end of this list
     */
    public String removeLast();

    /**
     * Note: Implement in O(n)
     *
     * Removes the first occurrence of the specified element from
     * this list, if it is present
     *
     * @param element element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    public boolean remove(String element);

    /**
     * Note: Implement in O(n)
     *
     * Removes the element at the specified position in this list, if
     * it is within valid range (return null otherwise).
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    public String remove(int index);

}
