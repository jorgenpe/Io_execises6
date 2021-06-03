package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void indexOfArray(){

        int [] testArray = { 5, 10 ,6 , 67, 0};
        int testInt = 0;
        int result = IndexOfArray.indexOfArray(testArray, testInt);
        int expected = 4;

        assertEquals(expected, result);

        testInt = 11;
        result = IndexOfArray.indexOfArray(testArray, testInt);
        expected = -1;
        assertEquals(expected, result);
        testArray = new int[0];

        result = IndexOfArray.indexOfArray(testArray, testInt);
        assertEquals(expected, result);

    }
}
