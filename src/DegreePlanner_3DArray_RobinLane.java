/*********************************************************************
 *
 * File: DegreePlanner_3DArray_RobinLane.java
 * By: Robin Lane
 * Date: 03-14-2025
 *
 * Description: Defines 4 1D arrays of Strings (representing a students
 *              classes for each semester), Then loads all of those
 *              strings into a 3D array of Strings. It then prints each
 *              string to the console.
 *
 *********************************************************************/

public class DegreePlanner_3DArray_RobinLane
{
    public static void main(String[] args)
    {
        String[] semester01 = {"csc101", "csc102", "csc103", "csc104", "csc105", "csc106"};
        String[] semester02 = {"csc201", "csc202", "csc203", "csc204", "csc205", "csc206"};
        String[] semester03 = {"csc301", "csc302", "csc303", "csc304", "csc305", "csc306"};
        String[] semester04 = {"csc401", "csc402", "csc403", "csc404", "csc405", "csc406"};

        Object[][][] classes = load3DArray(semester01, semester02, semester03, semester04);

        display3DArray(classes, "Semester");
    }

    // Prints a given 3D array to the console with each line labeled with the given context
    static void display3DArray(Object[][][] array3D, String context)
    {
        // Get the largest size of each dimension, for use in the following print call
        int[] dim = getLargestDimensions3D(array3D);

        //Get the size of the array, for use in the following print call
        int size = getJagged3DArraySize(array3D);

        /* Tells the user information about the 3D array that is about to be printed,
           including the type of array, the length of each dimension of the array,
           and the total amount of items stored in the array */
        System.out.printf("Printing data... from one 3D %s[%d][%d][%d] array containing %d items:\n", (array3D.getClass().getSimpleName() + "\b".repeat(6)), dim[0], dim[1], dim[2], size);

        for(int i = 0; i < array3D.length; i++) // For each 2D array
        {
            System.out.printf(" - %s #%d: ", context, i + 1); // Label each row with context and index
            for (int j = 0; j < array3D[i].length; j++) // For each 1D array
                for(int k = 0; k < array3D[i][j].length; k++) // For each object
                    // Print the object, followed by a comma only if the current object isn't the last one in the 2D array
                    System.out.printf("%s%s ", array3D[i][j][k], ((j+1 == array3D[i].length) && (k+1 == array3D[i][j].length)) ? "" : ",");
            System.out.println(); // Go to next line for next 2D array
        }
    }

    // Gets the size of a 3D array, even if it is jagged
    static int getJagged3DArraySize(Object[][][] array3D)
    {
        int length = 0;

        for(Object[][] array2D : array3D)
            for(Object[] array : array2D)
                length += array.length;

        return length;
    }

    // Returns the largest size for each dimension in a 3D array
    static int[] getLargestDimensions3D(Object[][][] array3D)
    {
        int[] dimensions = new int[3];

        // The first dimension will always be the size of the 3D array
        dimensions[0] = array3D.length;

        for(Object[][] array2D : array3D) // For each 2D array
        {
            dimensions[1] = Math.max(array2D.length, dimensions[1]); // The second dimension will be the largest of each 2D array

            for(Object[] array : array2D) // For each 1D array
                dimensions[2] = Math.max(array.length, dimensions[2]); // The third dimension will be the largest of each 1D array
        }

        return dimensions;
    }

    // Takes some number of given arrays and returns a 3D array that stores the contents of the given arrays
    /* The length of the 3D array is equal to the number of arrays given.
       The length of each 2D array stored in the 3D array, as well as each 1D array stored in each 2D array,
       is proportional to the length of each given array. For example, if the method is given
       an array of size 6, than it will be split into a 2D array of size 3 storing 1D arrays each of size 2 */
    static Object[][][] load3DArray(Object[]... givenArrays)
    {
        // The amount of 2D arrays is set to the amount of given arrays
        Object[][][] array3D = new Object[givenArrays.length][][];

        // In order to make each sub array proportional, we need to keep track of the factors of each given array
        int[] factors;

        // Iterates through each 2D Array (and given array, as there are an equal number of them)
        for(int i = 0; i < array3D.length; i++)
        {
            //First get the first factor pair of the given arrays length
            factors = getFirstFactorPair(givenArrays[i].length);
            /* The dimensions of the current 2D array are the first factor pair of the current given
               array multiplied together (which equals the length of the given array, thus there is one
               index in the 2D array for each index in the given array)*/
            array3D[i] = new String[factors[1]][factors[0]];

            // Iterate through each index in the current 2D array
            for(int j = 0; j < array3D[i].length; j++)
                for(int k = 0; k < array3D[i][j].length; k++)
                    // The current index in the 2D array is set to the corresponding index in the given array
                    array3D[i][j][k] = givenArrays[i][(j*array3D[i][j].length)+k];
        }

        return array3D;
    }

    // Gets the first non-trivial factor pair of some number n
    // (a trivial factor pair is 1*n)
    static int[] getFirstFactorPair(int n)
    {
        int[] factors = new int[2];

        //starts at two to avoid checking 1 (n % 1 will always be true)
        /* If each checked number less than n does not divide n evenly, than that means the number is prime
           In this case, the lop than checks if n is divisible by n, which is always true. Thus, the method will
           return the trivial factor pair. This is intentional, as the only factors of a prime number are it's
           trivial factors. */
        for(int i = 2; i <= n; i++)
        {
            if(n % i == 0)
            {
                factors[0] = i; // the first factor is the smallest number that evenly divides n
                break;
            }
        }

        factors[1] = n/factors[0]; //the second factor is the number that, when multiplied with the first factor, equals n

        return factors;
    }
}
