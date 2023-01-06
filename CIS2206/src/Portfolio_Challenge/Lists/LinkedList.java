package Portfolio_Challenge.Lists;

// See also: https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html

/**
 * Doubly-linked list implementation
 */
public class LinkedList implements List, Stack, Queue {

    private ListNode header;    // A pointer to header (sentinel node)
    private ListNode trailer;   // A pointer to trailer (sentinel node)
    private int size;           // The number of elements in the list

    /**
     * Creates a doubly linked list
     */
    public LinkedList() {
        // Initialize linked list in O(1)
        // Nothing is required to initialise the linked list.
    }

    @Override
    public String toString() {
        // Implement in O(n)
        var sb = new StringBuilder(size * 20);

        // Start at the header node.
        var nextNode = header;

        // Keep going until the end of the linked list has been reached.
        while (nextNode != null) {
            sb.append(nextNode.getElement() + ", ");
            nextNode = nextNode.getNext();
        }

        return sb.toString();
    }

    /* Collection Interface */

    @Override
    public int size() {
        // Implement in O(1)
        return size;
    }

    @Override
    public boolean isEmpty() {
        // Implement in O(1)
        return size > 0;
    }

    @Override
    public boolean contains(String element) {
        // Implement in O(n)
        // Start at the header node.
        var nextNode = header;

        // Keep going until the end of the linked list has been reached.
        while (nextNode != null) {
            if (nextNode.getElement() == element)
                return true;

            nextNode = nextNode.getNext();
        }

        return false;
    }

    /* List Interface */

    /* Add element */

    @Override
    public boolean addFirst(String element) {
        // Implement in O(1)

        // If no header assigned yet, make this the new header.
        if (header == null) {
            initialiseFirstNode(element);
        }
        // Add the new node before the current header and reestablish the current header.
        else {
            var newHeader = new ListNode(element, null, header);
            header.setPrev(newHeader);
            header = newHeader;
            size++;
        }

        return true;
    }

    @Override
    public boolean addLast(String element) {
        // Implement in O(1)
        // If no header assigned yet, make this the new header.
        if (header == null) {
            initialiseFirstNode(element);
        }
        // Add the new node after the current trailer and reestablish the current trailer.
        else {
            var newTrailer = new ListNode(element, trailer, null);
            trailer.setNext(newTrailer);
            trailer = newTrailer;
            size++;
        }

        return true;
    }

    @Override
    public boolean add(int index, String element) {
        // Implement in O(n)
        if (index < 0 || index > size)
            return false;

        // If index is 0 then the header will be changed.
        if (index == 0)
            return addFirst(element);

        // If index is the size of the list then the trailer will be changed.
        if (index == size)
            return addLast(element);

        ListNode node = header;
        for (int i = 1; i < index; i++) {
            if (i == index) {
                var nextNode = node.getNext();
                var newNode = new ListNode(element, node, nextNode);

                if (nextNode != null)
                    nextNode.setPrev(newNode);

                node.setNext(newNode);
                size++;
                return true;
            }

            // Iterate to the next node.
            node = node.getNext();
        }

        // Should never get here.
        return false;
    }

    /* Get element */

    @Override
    public String first() {
        // Implement in O(1)
        if (header == null)
            return null;

        return header.getElement();
    }

    @Override
    public String last() {
        // Implement in O(1)
        if (trailer == null)
            return null;

        return trailer.getElement();
    }

    @Override
    public String get(int index) {
        // Implement in O(n)
        // Out of bounds.
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        ListNode node = header;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return node.getElement();
            }

            // Iterate to the next node.
            node = node.getNext();
        }

        return null;
    }

    /* Remove element */

    @Override
    public String removeFirst() {
        // Implement in O(1)
        if (header != null) {
            // Store the element so it can be returned later.
            var element = header.getElement();
            removeNode(header);
            return element;
        }

        return null;
    }

    @Override
    public String removeLast() {
        // Implement in O(1)
        if (trailer != null) {
            // Store the element so it can be returned later.
            var element = trailer.getElement();
            removeNode(trailer);
            return element;
        }

        return null;
    }

    @Override
    public boolean remove(String element) {
        // Implement in O(n)
        ListNode nextNode = header;
        while (nextNode != null) {
            if (nextNode.getElement() == element) {
                removeNode(nextNode);
                return true;
            }

            nextNode = nextNode.getNext();
        }

        return false;
    }

    @Override
    public String remove(int index) {
        // Implement in O(n)
        ListNode nextNode = header;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                removeNode(nextNode);
                return nextNode.getElement();
            }

            // Iterate to the next node.
            nextNode = nextNode.getNext();
        }

        return null;
    }

    /* Stack Interface */

    @Override
    public String push(String element) {
        // Implement in O(1)
        addLast(element);
        return trailer.getElement();
    }

    @Override
    public String top() {
        // Implement in O(1)
        if (trailer == null)
            return null;

        return trailer.getElement();
    }

    @Override
    public String pop() {
        // Implement in O(1)
        return removeLast();
    }

    /* Queue Interface */

    @Override
    public boolean enqueue(String element) {
        // Implement in O(1)
        return addLast(element);
    }

    @Override
    public String dequeue() {
        // Implement in O(1)
        return removeFirst();
    }

    private void initialiseFirstNode(String element) {
        // O(1)
        // If no header assigned yet, make this the new header.
        if (header == null) {
            header = new ListNode(element, null, null);
            trailer = header;
            size = 1;
        }
    }

    private void removeNode(ListNode currentNode) {
        var prevNode = currentNode.getPrev();
        var nextNextNode = currentNode.getNext();

        // If there is a previous node, notify it that it has a new next node.
        // Otherwise, it means the current node is the header and the header needs to be
        // reestablished.
        if (prevNode != null)
            prevNode.setNext(nextNextNode);
        else
            header = nextNextNode;

        // If there is a next node, notify it that it has a new previous node.
        // Otherwise, it means the current node is the trailer and the trailer needs to be
        // reestablished.
        if (nextNextNode != null)
            nextNextNode.setPrev(prevNode);
        else
            trailer = prevNode;

        size--;
    }
}
