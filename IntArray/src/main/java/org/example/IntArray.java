package org.example;

/**
 * Hello world!
 *
 */
public class IntArray
{
    private static int[] intArray = new int[0];

    public static void clear(){

        intArray = new int[0];

    }

    public static boolean printArray(int [] arrayInt){

        intArray = arrayInt;
        if( intArray.length == 0){

            System.out.println("Array is empty");
            return false;

        }

        for(int i = 0; i< intArray.length; i++){

            System.out.print(intArray[i]);

            if(i < intArray.length -1){

                System.out.print( " , ");
            }
        }
        System.out.println();
        return true;
    }
}
