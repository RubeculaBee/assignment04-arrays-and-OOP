/*********************************************************************************
 *
 * File: GardeningPlanner_RobinLane.java
 * By: Robin Lane
 * Date: 03-10-2025
 *
 * Description: Asks the user for information about what a plant needs to grow,
 *              including its minimum and maximum temperatures and its minimum
 *              rainfall. Then, using information about average rainfall and
 *              temperatures over 12 months, the program tells the user the plants
 *              average growth and height for each month.
 *
 *********************************************************************************/
import java.util.Scanner;

public class GardeningPlanner_RobinLane
{
    static int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47}; // The average temperature for each month
    static int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4}; // The average rainfall for each month

    static int maxTemp; // Maximum temperature the plant can be in and still grow
    static int minTemp; // Minimum temperature the plant can be in and still grow
    static int minRain; // Minimum rainfall the plant needs to grow

    /* The following arrays will be the same length as the given avgTemp array, since the length of that array
       determines how many years of plant growth we will be tracking */
    static int[] plantGrowth = new int[avgTemp.length]; // How much the plant has grown each month
    static int[] plantHeight = new int[avgTemp.length]; // THe height of the plant for each month

    static int maxHeight = 0; // The largest height the plant reached in the year

    public static void main(String[] args)
    {
        displayWelcome();
        getInput();
        System.out.print("\n");

        getPlantGrowth();
        getPlantHeight();

        displayGrowthChart();
    }

    // Prints the welcome message to the screen
    static void displayWelcome()
    {
        System.out.println("-".repeat(89)); // prints 89 '-' (hyphens)
        System.out.println("Welcome to the CSC 215 Gardening Planner!");
        System.out.println("-".repeat(89));
    }

    // Gets information about the plant from the user
    static void getInput()
    {
        Scanner input = new Scanner(System.in);

        System.out.print("- Enter minimum temperature for plant: ");
        minTemp = input.nextInt();

        System.out.print("- Enter maximum temperature for plant: ");
        maxTemp = input.nextInt();

        System.out.print("- Enter minimum rainfall for plant: ");
        minRain = input.nextInt();

        System.out.println("-".repeat(89));
    }

    // Initialises each index of the plantGrowth array
    static void getPlantGrowth()
    {
        for(int i = 0; i < avgTemp.length; i++)
        {
            // If the temperature of the current month is within the minimum and maximum temperatures
            if(avgTemp[i] <= maxTemp && avgTemp[i] >= minTemp)
                // Then the growth of that month is the difference between that months rainfall and the minimum required
                plantGrowth[i] = avgRain[i] - minRain;
            else
                // Otherwise the growth is -1
                plantGrowth[i] = -1;
        }
    }

    // Initialises each index of the plantHeight array
    static void getPlantHeight()
    {
        int height = 0; // height starts at 0

        for(int i = 0; i < plantGrowth.length; i++)
        {
            // current height gets incremented by the current plantGrowth, but only if that sum is greater than 0
            height = Math.max(0, height + plantGrowth[i]);

            plantHeight[i] = height;

            maxHeight = Math.max(maxHeight, height); // if current height is largest, set maxHeight to current height
        }
    }

    // Prints a chart to the screen containing the index, month, temperature, rain, growth, and height of the plant.
    static void displayGrowthChart()
    {
        // Months of the year in order
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        System.out.println(("-".repeat(14) + " ").repeat(6)); // Prints 6 sets of 14 hyphens each seperated by a space
        // Each column is left aligned
        System.out.printf("%-14s %-14s %-14s %-14s %-14s %-14s\n", "INDEX", "MONTH", "TEMPERATURE", "RAINFALL", "PLANT GROWTH", "PLANT HEIGHT");

        for(int i=0; i<avgTemp.length; i++)
            // Format string for plant growth contains a + sign, so that the sign of the value is always printed
            // Format string for plant height has width 4 to make room for MAX label
            System.out.printf("%2d %11s %-14s %-14d %-14d %+-14d %-4d %-7s\n"
                    , i, " ", months[i], avgTemp[i], avgRain[i], plantGrowth[i], plantHeight[i], plantHeight[i] == maxHeight? "\033[103;30mMAX\033[0m" : "");

        System.out.println(("-".repeat(14) + " ").repeat(6));
    }
}
