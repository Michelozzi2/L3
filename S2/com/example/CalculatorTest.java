package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @DisplayName("Test add method")
    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));

    }

    @Test
    void testDiv() {

    }

    @Test
    void testProd() {
        assertEquals(20, calculator.prod(10, 2));

    }

    @Test
    void testName() {
        
    }

    @DisplayName("Test prod method with zero")
    @Test
    void testProdZero() {
        assertEquals(0, calculator.prod(0, 2));
        assertEquals(0, calculator.prod(10, 1));
    }
}
