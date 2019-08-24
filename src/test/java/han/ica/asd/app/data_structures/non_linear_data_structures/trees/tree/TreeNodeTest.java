package han.ica.asd.app.data_structures.non_linear_data_structures.trees.tree;

import han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees.BinaryTree;
import han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees.BinaryTreeNode;
import han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees.BinaryTreePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class TreeNodeTest {

    private TreeNode<Integer> treeNode;

    @BeforeEach
    void setUp() {
        treeNode = new TreeNode<>(5);
        treeNode.addSibling(10);
        treeNode.addSibling(20);
        treeNode.addChild(30);
        treeNode.addChild(40);
        treeNode.getChild().addChild(50);
    }

    @Test
    void getValue() {
        assertEquals(5, treeNode.getValue());
    }

    @Test
    void getSibling() {
        assertEquals(20, treeNode.getSibling().getValue());
        assertEquals(10, treeNode.getSibling().getSibling().getValue());
    }

    @Test
    void getChild() {
        assertEquals(40, treeNode.getChild().getValue());
        assertEquals(30, treeNode.getChild().getSibling().getValue());
    }

    @Test
    void addSibling() {
        assertEquals(20, treeNode.getSibling().getValue());
        treeNode.addSibling(100);
        assertEquals(100, treeNode.getSibling().getValue());
        assertEquals(20, treeNode.getSibling().getSibling().getValue());
    }

    @Test
    void addChild() {
        assertEquals(40, treeNode.getChild().getValue());
        treeNode.addChild(100);
        assertEquals(100, treeNode.getChild().getValue());
        assertEquals(40, treeNode.getChild().getSibling().getValue());
    }

    @Test
    void removeChild() {
        assertEquals(40, treeNode.getChild().getValue());
        treeNode.removeChild();
        assertNull(treeNode.getChild());
    }

    @Test
    void removeSibling() {
        assertEquals(20, treeNode.getSibling().getValue());
        treeNode.removeSibling();
        assertNull(treeNode.getSibling());

    }
}