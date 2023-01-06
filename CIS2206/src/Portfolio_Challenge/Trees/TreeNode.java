package Portfolio_Challenge.Trees;

/**
 * A TreeNode stores the element as well as pointers
 * to parent, left child and right child
 */
public class TreeNode {

    private String element;         // The element stored at this node
    private TreeNode parent;        // The parent node (if any)
    private TreeNode leftChild;     // The left child (if any)
    private TreeNode rightChild;    // The right child (if any)

    /**
     * Creates a tree node
     *
     * @param element    the element stored at this node
     * @param parent     a reference to the parent node (if any)
     * @param leftChild  a reference to the left child (if any)
     * @param rightChild a reference to the right child (if any)
     */
    public TreeNode(String element, TreeNode parent, TreeNode leftChild, TreeNode rightChild) {
        this.element = element;
        this.parent = parent;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
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
     * Returns the parent of this node.
     *
     * @return the parent of this node.
     */
    public TreeNode getParent() {
        return parent;
    }

    /**
     * Returns the left child of this node.
     *
     * @return the left child of this node.
     */
    public TreeNode getLeftChild() {
        return leftChild;
    }

    /**
     * Returns the right child of this node.
     *
     * @return the right child of this node.
     */
    public TreeNode getRightChild() {
        return rightChild;
    }

    /**
     * Sets the element (to this node).
     *
     * @param element the element (to this node).
     */
    public void setElement(String element) {
        this.element = element;
    }

    /**
     * Sets the parent (to this node).
     *
     * @param parent the parent (to this node).
     */
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    /**
     * Sets the left child (to this node).
     *
     * @param leftChild the left child (to this node).
     */
    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    /**
     * Sets the right child (to this node).
     *
     * @param rightChild the right child (to this node).
     */
    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

}
