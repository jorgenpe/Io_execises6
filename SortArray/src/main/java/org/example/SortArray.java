package org.example;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class SortArray
{
    public static boolean sortArray(String[] stringArray){
        boolean index = true;
        String[] temp;
        if(stringArray.length == 0){

            System.out.println(" The array is empty ");
            return false;
        }
        toString(stringArray, index);
        index = false;
        Arrays.sort(stringArray);
        toString(stringArray, index);


        return true;
    }

    private static void toString(String[] stringArray, boolean index){
        if(index){
            System.out.print("String array: [");
        }else{
            System.out.print("Sort string array: [");
        }

        for(int i = 0; i< stringArray.length; i++){
            if(i < stringArray.length-1){

                System.out.print(stringArray[i] + ", ");

            }else{
                System.out.print(stringArray[i]);
            }


        }

        System.out.print("]");
        System.out.println();

    }
}
