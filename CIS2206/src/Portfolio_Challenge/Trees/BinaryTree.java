package Portfolio_Challenge.Trees;

import Portfolio_Challenge.Collection;

public interface BinaryTree extends Collection {

    /* Core functions */

    /**
     * Note: Implement in O(1)
     *
     * Returns the root of this tree or null if this tree is empty
     *
     * @return the root of this tree
     */
    public TreeNode root();

    /**
     * Note: Implement in O(1)
     *
     * Returns the parent node (if any) of the given node
     *
     * @param node the node whose parent is to be returned
     * @return the parent node (if any) of the given node
     */
    public TreeNode parent(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns the left child (if any) of the given node
     *
     * @param node the node whose left child is to be returned
     * @return the left node (if any) of the given node
     */
    public TreeNode left(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns the right child (if any) of the given node
     *
     * @param node the node whose right child is to be returned
     * @return the right node (if any) of the given node
     */
    public TreeNode right(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns the sibling (if any) of the given node
     *
     * @param node the node whose sibling is to be returned
     * @return the sibling (if any) of the given node
     */
    public TreeNode sibling(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns the number of children of the given node
     *
     * @param node the node whose number of children is to be returned
     * @return the number of children of the given node
     */
    public int numChildren(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns true if given node is internal (i.e. has children)
     *
     * @param node the node to be checked
     * @return true if given node is internal (i.e. has children)
     */
    public boolean isInternal(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns true if given node is external (i.e. has no children)
     *
     * @param node the node to be checked
     * @return true if given node is external (i.e. has no children)
     */
    public boolean isExternal(TreeNode node);

    /**
     * Note: Implement in O(1)
     *
     * Returns true if given node is the root of the tree
     *
     * @param node the node to be checked
     * @return true if given node is the root of the tree
     */
    public boolean isRoot(TreeNode node);

    /* Add element */

    /**
     * Note: Implement in O(logn)
     *
     * Inserts the specified element into the tree if not
     * already present in the tree (i.e. no duplicates)
     *
     * @param element element to be inserted
     * @return the node containing the inserted element
     */
    public TreeNode add(String element);

    /* Get element */

    /**
     * Note: Implement in O(logn)
     *
     * Returns the node containing the given element
     *
     * @param element element to find
     * @return the node containing the given element
     */
    public TreeNode get(String element);

    /* Remove element */

    /**
     * Note: Implement in O(logn)
     *
     * Removes the element from the tree
     *
     * @param element element to remove
     * @return recently removed element
     */
    public String remove(String element);

}