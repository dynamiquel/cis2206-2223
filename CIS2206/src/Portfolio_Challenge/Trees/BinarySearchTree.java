package Portfolio_Challenge.Trees;

/**
 * Implements a Binary Search Tree
 */
public class BinarySearchTree implements BinaryTree {

    private TreeNode root;   // A pointer to the root of the tree
    private int size;        // The number of nodes in the tree

    /**
     * Creates a binary search tree
     */
    public BinarySearchTree() {
        // Initialize tree in O(1)
    }

    @Override
    public String toString() {
        // Implement in O(n)
        var sb = new StringBuilder(size * 20);

        nextNodeToString(sb, root);

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
        return size == 0;
    }

    @Override
    public boolean contains(String element) {
        // Implement in O(logn)
        return false;
    }

    /* BinaryTree Interface */

    /* Core functions */

    @Override
    public TreeNode root() {
        // Implement in O(1)
        return root;
    }

    @Override
    public TreeNode parent(TreeNode node) {
        // Implement in O(1)
        return node.getParent();
    }

    @Override
    public TreeNode left(TreeNode node) {
        // Implement in O(1)
        return node.getLeftChild();
    }

    @Override
    public TreeNode right(TreeNode node) {
        // Implement in O(1)
        return node.getRightChild();
    }

    @Override
    public TreeNode sibling(TreeNode node) {
        // Implement in O(1)

        // Check if has parent.
        var parent = node.getParent();
        if (parent != null) {
            // Get the child that isn't the given node.
            return parent.getLeftChild() == node ? parent.getRightChild() : parent.getLeftChild();
        }

        return null;
    }

    @Override
    public int numChildren(TreeNode node) {
        // Implement in O(1)
        // If a child is present, add 1.
        // Using the ternary operator since Java mean and doesn't allow boolean to integer casting.
        return (node.getLeftChild() != null ? 1 : 0) + (node.getRightChild() != null ? 1 : 0);
    }

    @Override
    public boolean isInternal(TreeNode node) {
        // Implement in O(1)
        return numChildren(node) > 0;
    }

    @Override
    public boolean isExternal(TreeNode node) {
        // Implement in O(1)
        return numChildren(node) == 0;
    }

    @Override
    public boolean isRoot(TreeNode node) {
        // Implement in O(1)
        return root == node;
    }

    /* Add element */

    @Override
    public TreeNode add(String element) {
        // Implement in O(logn)
        TreeNode newNode;

        if (root == null) {
            root = newNode = new TreeNode(element, null, null, null);
        } else {
            // Finds the lowest node that could possibly be a parent for the new element.
            var parentNode = getLowestNode(root, element);
            newNode = new TreeNode(element, parentNode, null, null);

            // Check whether the new node should be a left or a right child.
            // If equal, make it a right child.
            if (element.compareTo(parentNode.getElement()) >= 0)
                parentNode.setRightChild(newNode);
            else
                parentNode.setLeftChild(newNode);
        }

        size++;

        return newNode;
    }

    /* Get element */

    @Override
    public TreeNode get(String element) {
        // Implement in O(logn)
        if (root == null)
            return null;

        // Finds the lowest node with the specified element value.
        var lowestNode = getLowestNode(root, element);

        // If the elements match, return this node.
        // If they do not, then there is no node in this tree with this element.
        if (lowestNode.getElement() == element)
            return lowestNode;

        return null;
    }

    /* Remove element */

    @Override
    public String remove(String element){
        // Note: Implement in O(logn)
        if (root == null)
            return null;

        return null;
    }

    /**
     * Finds the lowest-level node with a value as close to the specified element as possible.
     * @param parent The node to check.
     * @param element The element value to match against.
     * @return It will return either the first node with the same value as the element (useful for get()),
     * or if one could not be found, it will return the suitable parent node for a future node with the specified
     * element (useful for add()).
     */
    private TreeNode getLowestNode(TreeNode parent, String element) {
        //
        //
        var comparison = element.compareTo(parent.getElement());

        if (comparison == 0)
            return parent;

        if (comparison > 0)
            return parent.getRightChild() != null ? getLowestNode(parent.getRightChild(), element) : parent;

        return parent.getLeftChild() != null ? getLowestNode(parent.getLeftChild(), element) : parent;
    }

    private void nextNodeToString(StringBuilder sb, TreeNode node) {
        if (node == null)
            return;

        sb.append(node.getElement() + ", " );

        nextNodeToString(sb, node.getLeftChild());
        nextNodeToString(sb, node.getRightChild());
    }
}
