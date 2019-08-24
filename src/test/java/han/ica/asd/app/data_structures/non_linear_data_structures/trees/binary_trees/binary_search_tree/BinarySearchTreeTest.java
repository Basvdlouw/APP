package han.ica.asd.app.data_structures.non_linear_data_structures.trees.binary_trees.binary_search_tree;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        binarySearchTree = new BinarySearchTree(8);
        binarySearchTree.insert(6);
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insert(7);
        binarySearchTree.insert(9);
        binarySearchTree.insert(11);
    }

    @Test
    void insert() {
        assertThrows(NullPointerException.class,()-> binarySearchTree.find(12));
        binarySearchTree.insert(12);
        assertEquals(12, binarySearchTree.find(12));
    }

    @Test
    void isEmpty() {
        assertFalse(binarySearchTree.isEmpty());
        assertTrue(new BinarySearchTree<Integer>().isEmpty());
    }

    @Test
    void findMin() {
        assertEquals(5, binarySearchTree.findMin());
    }

    @Test
    void findMax() {
        assertEquals(11, binarySearchTree.findMax());
    }

    @Test
    void delete() {
        binarySearchTree.delete(6);
        assertThrows(NullPointerException.class, ()-> binarySearchTree.find(6));
        assertEquals(7, binarySearchTree.find(7));
    }

    @Test
    void printTree() {
        binarySearchTree.printTree(binarySearchTree.root, "");
        assertEquals("+ 8\r\n" +
                "  + 6\r\n" +
                "   + 5\r\n" +
                "   + 7\r\n" +
                "  + 10\r\n" +
                "   + 9\r\n" +
                "   + 11", outContent.toString().trim());
    }

    @AfterAll
    static void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void find() {
        assertThrows(NullPointerException.class, ()-> binarySearchTree.find(30));
        assertEquals(7, binarySearchTree.find(7));
    }
}