package han.ica.asd.app.recursion.towers_of_hanoi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiskTest {

    @Test
    void getDiskNumber() {
        assertEquals(10, new Disk(10).getDiskNumber());
    }
}