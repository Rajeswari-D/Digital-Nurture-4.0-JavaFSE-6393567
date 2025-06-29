package com.cognizant.digitalnurture.exercise3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    Assertions assertions = new Assertions();

    @Test
    public void testAssertEquals() {
        assertEquals(7, assertions.add(3, 4));
    }

    @Test
    public void testAssertTrue() {
        assertTrue(assertions.isGreater(10, 5));
    }

    @Test
    public void testAssertFalse() {
        assertFalse(assertions.isGreater(3, 8));
    }

    @Test
    public void testAssertNull() {
        assertNull(assertions.getNull());
    }

    @Test
    public void testAssertNotNull() {
        assertNotNull(assertions.getObject());
    }
}
