package han.ica.asd.app.data_structures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedSymbolCheckerTest {

    @Test
    void isBalanced() {
        char[] symbolArr1 = new char[]{'{', '[', ']', '}', ')'};
        assertFalse(BalancedSymbolChecker.isBalanced(symbolArr1));
        char[] symbolArr2 = new char[]{'(', '{', '[', ']', '}', ')'};
        assertTrue(BalancedSymbolChecker.isBalanced(symbolArr2));
    }
}