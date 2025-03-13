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

    static String[][][] load3DArray(String[]... arrays)
    {
        String[][][] array3D = new String[arrays.length][][];

        ArrayList<Integer> factors;

        for(int i = 0; i < array3D.length; i++)
        {
            factors = getSmallestFactors(arrays[i].length, 2);
            array3D[i] = new String[factors.get(1)][factors.get(0)];

            for(int j = 0; j < array3D[i].length; j++)
            {
                for(int k = 0; k < array3D[i][j].length; k++)
                {
                    array3D[i][j][k] = arrays[i][(j*array3D[i][j].length)+k];
                }
            }
        }

        return array3D;
    }

    static ArrayList<Integer> getSmallestFactors(int n, int numFactors)
    {
        ArrayList<Integer> factors = new ArrayList<>();

        for(int i = 2; i < n; i++)
        {
            if(n % i == 0)
                factors.add(i);

            if(factors.size() == numFactors)
                break;
        }

        return factors;
    }
}
