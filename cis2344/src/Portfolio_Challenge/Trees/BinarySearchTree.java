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
        return null;
    }

    /* Collection Interface */

    @Override
    public int size() {
        // Implement in O(1)
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // Implement in O(1)
        return false;
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
        return null;
    }

    @Override
    public TreeNode parent(TreeNode node) {
        // Implement in O(1)
        return null;
    }

    @Override
    public TreeNode left(TreeNode node) {
        // Implement in O(1)
        return null;
    }

    @Override
    public TreeNode right(TreeNode node) {
        // Implement in O(1)
        return null;
    }

    @Override
    public TreeNode sibling(TreeNode node) {
        // Implement in O(1)
        return null;
    }

    @Override
    public int numChildren(TreeNode node) {
        // Implement in O(1)
        return 0;
    }

    @Override
    public boolean isInternal(TreeNode node) {
        // Implement in O(1)
        return false;
    }

    @Override
    public boolean isExternal(TreeNode node) {
        // Implement in O(1)
        return false;
    }

    @Override
    public boolean isRoot(TreeNode node) {
        // Implement in O(1)
        return false;
    }

    /* Add element */

    @Override
    public TreeNode add(String element) {
        // Implement in O(logn)
        return null;
    }

    /* Get element */

    @Override
    public TreeNode get(String element) {
        // Implement in O(logn)
        return null;
    }

    /* Remove element */

    @Override
    public String remove(String element){
        // Note: Implement in O(logn)
        return null;
    }

}
