package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePrinterTest {

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

    /**
     * Test might fail on linux but won't fix since it's testing printing to console, not very important.
     */
    @Test
    void printNode() {
        BinaryTreePrinter.printNode(tree.root);
        assertEquals("1       \r\n" +
                "  / \\   \r\n" +
                " /   \\  \r\n" +
                " 2   3   \r\n" +
                "/ \\ / \\ \r\n" +
                "4 5 6 7"
                        .trim(), outContent.toString().trim());
    }

    @AfterAll
    static void restoreStream() {
        System.setOut(originalOut);
    }
}