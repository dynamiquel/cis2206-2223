package Portfolio_Challenge.Lists;

/**
 * A ListNode stores the element as well as pointers
 * to previous and next nodes.
 */
public class ListNode {
    private String element; // The element stored at this node
    private ListNode prev;  // A pointer to the previous node
    private ListNode next;  // A pointer to the next node

    /**
     * Creates a list node
     *
     * @param element the element stored at this node
     * @param prev    a pointer to the previous node
     * @param next    a pointer to the next node
     */
    public ListNode(String element, ListNode prev, ListNode next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /**
     * Returns the element stored at this node.
     *
     * @return the element stored at this node.
     */
    public String getElement() {
        return element;
    }

    /**
     * Returns the previous node (to this node).
     *
     * @return the previous node (to this node).
     */
    public ListNode getPrev() {
        return prev;
    }

    /**
     * Returns the next node (to this node).
     *
     * @return the next node (to this node).
     */
    public ListNode getNext() {
        return next;
    }

    /**
     * Sets the previous node (to this node).
     *
     * @param prev the previous node (to this node).
     */
    public void setPrev(ListNode prev) {
        this.prev = prev;
    }

    /**
     * Sets the next node (to this node).
     *
     * @param next the next node (to this node).
     */
    public void setNext(ListNode next) {
        this.next = next;
    }

}
