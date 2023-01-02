package Portfolio_Challenge.Trees;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTests {
    static BinaryTree binaryTree;

    @BeforeEach
    void BeforeEach() {
        binaryTree = new BinarySearchTree();
    }

    @Test
    void PrintTree() {
        System.out.println(binaryTree);
    }

    @Test
    void InitialiseTree() {
        assertEquals(0, binaryTree.size());
        assertNull(binaryTree.get("5"));
    }

    @Test
    void Add() {
        var node = binaryTree.add("001");

        assertEquals(1, binaryTree.size());
        assertNotNull(node);
        assertEquals(node, binaryTree.get("001"));
    }

    @Test
    void AddSet() {
        var node = binaryTree.add("010");
        var nodeLeftChild = binaryTree.add("005");
        var nodeRightChild = binaryTree.add("020");

        assertEquals(3, binaryTree.size());
        assertNotNull(node);
        assertNotNull(nodeLeftChild);
        assertNotNull(nodeRightChild);
        assertEquals(node, binaryTree.get("010"));
        assertEquals(nodeLeftChild, binaryTree.get(nodeLeftChild.getElement()));
        assertEquals(nodeRightChild, binaryTree.get("020"));
    }

    @Test
    void GetParent() {
        var node = binaryTree.add("010");
        var nodeLeftChild = binaryTree.add("005");
        var nodeRightChild = binaryTree.add("020");

        assertNull(node.getParent());
        assertNull(binaryTree.parent(node));

        assertEquals(node, nodeLeftChild.getParent());
        assertEquals(node, binaryTree.parent(nodeLeftChild));

        assertEquals(node, nodeRightChild.getParent());
        assertEquals(node, binaryTree.parent(nodeRightChild));
    }

    @Test
    void GetSibling() {
        var node = binaryTree.add("010");
        var nodeLeftChild = binaryTree.add("005");
        var nodeRightChild = binaryTree.add("020");

        assertNull(binaryTree.sibling(node));
        assertEquals(nodeRightChild, binaryTree.sibling(nodeLeftChild));
        assertEquals(nodeLeftChild, binaryTree.sibling(nodeRightChild));
    }

    @Test
    void ChildNum() {
        var node = binaryTree.add("010");
        var nodeLeftChild = binaryTree.add("005");
        var nodeRightChild = binaryTree.add("020");

        assertEquals(2, binaryTree.numChildren(node));
        assertEquals(0, binaryTree.numChildren(nodeLeftChild));
        assertEquals(0, binaryTree.numChildren(nodeRightChild));
    }

    @Test
    void IsExternalOrInternal() {
        var node = binaryTree.add("010");
        var nodeLeftChild = binaryTree.add("005");
        var nodeRightChild = binaryTree.add("020");

        assertTrue(binaryTree.isInternal(node));
        assertFalse(binaryTree.isExternal(node));
        assertTrue(binaryTree.isExternal(nodeLeftChild));
        assertFalse(binaryTree.isInternal(nodeLeftChild));
        assertTrue(binaryTree.isExternal(nodeRightChild));
        assertFalse(binaryTree.isInternal(nodeRightChild));
    }

    @Test
    void AddAlot() {
        var node = binaryTree.add("010");
        var nodeLeftChild = binaryTree.add("005");
        var nodeRightChild = binaryTree.add("020");
        var nodeLeftRightChild = binaryTree.add("007");
        var nodeRightLeftChild = binaryTree.add("015");
        var nodeRightLeftRightChild = binaryTree.add("016");
        var nodeRightRightChild = binaryTree.add("100");

        assertEquals(7, binaryTree.size());
        assertEquals(node, binaryTree.get(node.getElement()));
        assertEquals(nodeLeftChild, binaryTree.get(nodeLeftChild.getElement()));
        assertEquals(nodeRightChild, binaryTree.get(nodeRightChild.getElement()));
        assertEquals(nodeLeftRightChild, binaryTree.get(node.getLeftChild().getRightChild().getElement()));
        assertEquals(nodeRightLeftChild, binaryTree.get(nodeRightLeftChild.getElement()));
        assertEquals(nodeRightLeftRightChild, binaryTree.get(nodeRightLeftRightChild.getElement()));
        assertEquals(nodeRightRightChild.getElement(), binaryTree.get(nodeRightChild.getRightChild().getElement()).getElement());
    }
}
