package com.cognizant.digitalnurture.exercise2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(10, calc.add(7, 3));
    }

    @Test
    public void testSubtract() {
        assertEquals(4, calc.subtract(9, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(20, calc.multiply(4, 5));
    }

    @Test
    public void testDivide() {
        assertEquals(5, calc.divide(10, 2));
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.divide(5, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
