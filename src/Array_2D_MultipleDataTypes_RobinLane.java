/*********************************************************************************
 *
 * File: Array_2D_MultipleDataTypes_RobinLane.java
 * By: Robin Lane
 * Date: 03-06-2025
 *
 * Description: Takes in a series of inputs from the user of different data types
 *              (int, char, string), then stores it all into a 2D array.
 *              Then prints a table of the data type of each value entered,
 *              followed by a table of each value entered.
 *
 *********************************************************************************/

import java.util.Arrays;
import java.util.Scanner;

public class Array_2D_MultipleDataTypes_RobinLane
{
    static Scanner input = new Scanner(System.in);
    //static Object[][] array2D = new Object[4][3]; // The array in which all input is stored

    public static void main(String[] args)
    {
        Object[][] array2D = getInput();
    }

    //Prompts the user for 4 sets of objects, and returns a 2D object array with those inputs.
    static Object[][] getInput()
    {
        Object[][] array2D = new Object[4][3]; //Initialise 2D array with 4 rows and 3 columns

        System.out.printf("%-36s", "Row 1 | Please enter 3 Integers:"); //Sets the first row of Integers
        for(int i = 0; i < array2D[0].length; i++)
            array2D[0][i] = input.nextInt();

        System.out.printf("%-36s", "Row 2 | Please enter 3 Characters:"); //Sets the second row of characters
        for(int i = 0; i < array2D[1].length; i++)
            array2D[1][i] = input.next().charAt(0);

        System.out.printf("%-36s", "Row 3 | Please enter 3 Strings:"); //Sets the third row of strings
        for(int i = 0; i < array2D[2].length; i++)
            array2D[2][i] = input.next();

        System.out.printf("%-36s", "Row 4 | 1 int, 1 char, 1 String:"); //Sets the last row of various types
        array2D[3][0] = input.nextInt();
        array2D[3][1] = input.next().charAt(0);
        array2D[3][2] = input.next();

        return array2D;
    }
}
