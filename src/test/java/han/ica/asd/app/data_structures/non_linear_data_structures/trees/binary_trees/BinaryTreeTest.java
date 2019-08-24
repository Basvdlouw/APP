package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    private BinaryTree tree;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        tree = new BinaryTree(1);
        tree.root.addLeft(2);
        tree.root.addRight(3);
        tree.root.left.addLeft(4);
        tree.root.left.addRight(5);
        tree.root.right.addLeft(6);
        tree.root.right.addRight(7);
    }


    @Test
    void getLeafCount() {
        BinaryTree noLeafTree = new BinaryTree();
        assertEquals(0, noLeafTree.getLeafCount());
        assertEquals(4, tree.getLeafCount());
    }

    @Test
    void printPostorder() {
        tree.printPostorder();
        assertEquals("4 5 2 6 7 3 1 ", outContent.toString());
    }

    @Test
    void printInorder() {
        tree.printInorder();
        assertEquals("4 2 5 1 6 3 7 ", outContent.toString());
    }

    @Test
    void printPreorder() {
        tree.printPreorder();
        assertEquals("1 2 4 5 3 6 7 ", outContent.toString());
    }

    @AfterAll
    static void restoreStream() {
        System.setOut(originalOut);
    }
}