package com.cognizant.digitalnurture.exercise4;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc;

    @BeforeEach
    void setUp() {
        // Arrange
        calc = new Calculator();
        System.out.println("Setting up Calculator instance...");
    }

    @AfterEach
    void tearDown() {
        calc = null;
        System.out.println("Cleaning up Calculator instance...");
    }

    @Test
    void testAddition() {
        // Act
        int result = calc.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    void testSubtraction() {
        // Act
        int result = calc.subtract(10, 4);

        // Assert
        assertEquals(6, result);
    }
}
