package han.ica.asd.app.recursion.towers_of_hanoi;

import han.ica.asd.app.data_structures.stack.HANStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TowersOfHanoiTest {

    private HANStack<Disk> stackOne;
    private HANStack<Disk> stackTwo;
    private HANStack<Disk> stackThree;

    @BeforeEach
    void setUp() {
        stackOne = new HANStack<>();
        stackTwo = new HANStack<>();
        stackThree = new HANStack<>();
    }

    @Test
    void solvePuzzleUsingStackWithFiveDisks() {
        TowersOfHanoi.solvePuzzleUsingStack(stackOne, stackTwo, stackThree, 5);
        assertTrue(stackOne.isEmpty());
        assertTrue(stackTwo.isEmpty());
        assertEquals(5, stackThree.size());
    }

    @Test
    void solvePuzzleUsingStackWithDefaultAmountOfDisks() {
        TowersOfHanoi.solvePuzzleUsingStack(stackOne, stackTwo, stackThree);
        assertTrue(stackOne.isEmpty());
        assertTrue(stackTwo.isEmpty());
        assertEquals(TowersOfHanoi.DEFAULT_AMOUNT_OF_DISKS, stackThree.size());
    }
}