package han.ica.asd.app.data_structures.non_linear_data_structures.trees.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    @Test
    void constructor() {
        assertNull(new Tree().root);
        Tree tree =  new Tree(10);
        assertEquals(10, tree.root.getValue());
    }
}