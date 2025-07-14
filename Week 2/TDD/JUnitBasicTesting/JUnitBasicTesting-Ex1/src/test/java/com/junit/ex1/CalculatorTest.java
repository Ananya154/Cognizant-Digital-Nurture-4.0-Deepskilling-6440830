package com.junit.ex1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    public void testAdd() {
        Calculator calc = new Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result); 
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        int result = calc.subtract(5, 2);
        assertEquals(3, result); 
    }
}
