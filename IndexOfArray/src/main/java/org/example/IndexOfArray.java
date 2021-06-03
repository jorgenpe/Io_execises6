package org.example;

/**
 * Hello world!
 *
 */
public class IndexOfArray
{
    private static int[] intArray;

    public static void clear(){

        intArray = new int[0];

    }

    public static int indexOfArray(int [] arrayInt, int number){

        intArray = arrayInt;
        if( intArray.length == 0){

            System.out.print("Array is empty\n");
            return -1;

        }

        for(int i = 0; i< intArray.length; i++) {

            if (intArray[i] == number) {

                System.out.println("Index position of number " + number + " is: " + i);
                return i;

            }
        }
        System.out.println();
        return -1;
    }



    public static boolean printArray(int [] arrayInt){

        intArray = arrayInt;
        if( intArray.length == 0){

            System.out.print("Array is empty");
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
