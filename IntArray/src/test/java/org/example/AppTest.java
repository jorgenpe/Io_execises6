package org.example;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

/**
 * Unit test for simple IntArray.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void intArray(){
        int[] testArray = {12, 25 , 1, 13, 126};
        boolean result = IntArray.printArray(testArray);

        assertTrue(result);

        testArray = new int[0];

        result = IntArray.printArray(testArray);
        assertFalse(result);
    }

}
