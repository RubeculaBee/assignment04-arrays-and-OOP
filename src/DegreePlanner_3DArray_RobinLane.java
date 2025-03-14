/*********************************************************************
 *
 * File: DegreePlanner_3DArray_RobinLane.java
 * By: Robin Lane
 * Date: 03-13-2025
 *
 * Description: Defines 4 1D arrays of Strings (representing a students
 *              classes for each semester), Then loads all of those
 *              strings into a 3D array of Strings. It then prints each
 *              string to the console.
 *
 *********************************************************************/

import java.util.ArrayList;
import java.util.Arrays;

public class DegreePlanner_3DArray_RobinLane
{
    public static void main(String[] args)
    {
        String[] semester01 = {"csc101", "csc102", "csc103", "csc104", "csc105", "csc106"};
        String[] semester02 = {"csc201", "csc202", "csc203", "csc204", "csc205", "csc206"};
        String[] semester03 = {"csc301", "csc302", "csc303", "csc304", "csc305", "csc306"};
        String[] semester04 = {"csc401", "csc402", "csc403", "csc404", "csc405", "csc406"};

        String[][][] classes = load3DArray(semester01, semester02, semester03, semester04);
    }

    // Takes some number of given arrays and returns a 3D array that stores the contents of the given arrays
    /* The length of the 3D array is equal to the number of arrays given.
       The length of each 2D array stored in the 3D array, as well as each 1D array stored in each 2D array,
       is proportional to the length of each given array. For example, if the method is given
       an array of size 6, than it will be split into a 2D array of size 3 storing 1D arrays each of size 2 */
    static String[][][] load3DArray(String[]... givenArrays)
    {
        // The amount of 2D arrays is set to the amount of given arrays
        String[][][] array3D = new String[givenArrays.length][][];

        // In order to make each sub array proportional, we need to keep track of the factors of each given array
        ArrayList<Integer> factors;

        // Iterates through each 2D Array (and given array, as there are an equal number of them)
        for(int i = 0; i < array3D.length; i++)
        {
            //First get the first two factors of the given arrays length
            factors = getSmallestFactors(givenArrays[i].length, 2);
            /* The dimensions of the current 2D array are the first two factors of the current given
               array multiplied together (which equals the length of the given array, thus there is one
               index in the 2D array for each index in the given array)*/
            array3D[i] = new String[factors.get(1)][factors.get(0)];

            // Iterate through each index in the current 2D array
            for(int j = 0; j < array3D[i].length; j++)
                for(int k = 0; k < array3D[i][j].length; k++)
                    // The current index in the 2D array is set to the corresponding index in the given array
                    array3D[i][j][k] = givenArrays[i][(j*array3D[i][j].length)+k];
        }

        return array3D;
    }

    // Takes some number n, and returns the first 'numFactors' amount of factors of n
    static ArrayList<Integer> getSmallestFactors(int n, int numFactors)
    {
        ArrayList<Integer> factors = new ArrayList<>(); // variably sized list of factors

        // Loop starts at 2 and ends just before n to avoid tracking the trivial factors of 1 and itself
        for(int i = 2; i < n; i++) // For each number between 1 and n (exclusive)
        {
            if(n % i == 0) // If n is divisible by that number, store it
                factors.add(i);

            if(factors.size() == numFactors) // Once you've stored the requested number of factors, stop counting
                break;
        }

        return factors;
    }
}
