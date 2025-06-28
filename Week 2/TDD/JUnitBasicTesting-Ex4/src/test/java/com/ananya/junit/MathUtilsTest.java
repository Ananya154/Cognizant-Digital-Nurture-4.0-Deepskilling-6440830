package com.ananya.junit;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {

    private MathUtils math;

    @Before
    public void setUp() {
        math = new MathUtils();  
        System.out.println("Setup completed");
    }

    @After
    public void tearDown() {
        System.out.println("Test completed");
    }

    @Test
    public void testAddition() {
        int result = math.add(5, 3);  
    }

    @Test
    public void testSubtraction() {
        int result = math.subtract(10, 4);
        assertEquals(6, result);
    }
}
