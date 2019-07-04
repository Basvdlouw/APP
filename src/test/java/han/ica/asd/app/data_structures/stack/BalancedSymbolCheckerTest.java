package han.ica.asd.app.data_structures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedSymbolCheckerTest {

    @Test
    void isBalancedSuccess() {
        char[] symbolArr = new char[]{'(', '{', '[', ']', '}', ')'};
        assertTrue(BalancedSymbolChecker.isBalanced(symbolArr));
    }

    @Test
    void isBalancedStackNotEmpty() {
        char[] symbolArr = new char[]{'{', '[', ']', '}', ')'};
        assertFalse(BalancedSymbolChecker.isBalanced(symbolArr));
    }

    @Test
    void isBalancedPairsNotMatching() {
        char[] symbolArr = new char[]{'(', '{', '[', ']', '}', '}'};
        assertFalse(BalancedSymbolChecker.isBalanced(symbolArr));
    }
}