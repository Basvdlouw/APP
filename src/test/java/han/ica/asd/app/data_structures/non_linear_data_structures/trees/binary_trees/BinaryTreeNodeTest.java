package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeNodeTest {

    private BinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = new BinaryTreeNode(10);
    }

    @Test
    void addLeft() {
        root.addLeft(20);
        assertEquals(20, root.left.key);
    }

    @Test
    void addRight() {
        root.addRight(20);
        assertEquals(20, root.right.key);
    }

    @Test
    void setLeft() {
        root.addLeft(20);
        assertEquals(20, root.left.key);
        root.setLeft(new BinaryTreeNode(30));
        assertEquals(30, root.left.key);
    }

    @Test
    void setRight() {
        root.addRight(20);
        assertEquals(20, root.right.key);
        root.setRight(new BinaryTreeNode(30));
        assertEquals(30, root.right.key);
    }
}