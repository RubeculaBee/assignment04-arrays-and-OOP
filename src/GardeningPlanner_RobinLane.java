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
    static Scanner input = new Scanner(System.in);

    static int[] avgTemp = {46, 48, 49, 50, 51, 53, 54, 55, 56, 55, 51, 47}; // The average temperature for each month
    static int[] avgRain = {5, 3, 3, 1, 1, 0, 0, 0, 0, 1, 3, 4}; // The average rainfall for each month

    static int maxTemp; // Maximum temperature the plant can be in and still grow
    static int minTemp; // Minimum temperature the plant can be in and still grow
    static int minRain; // Minimum rainfall the plant need sto grow

    public static void main(String[] args)
    {
        displayWelcome();
        getInput();
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
        System.out.print("- Enter minimum temperature for plant: ");
        minTemp = input.nextInt();

        System.out.print("- Enter maximum temperature for plant: ");
        maxTemp = input.nextInt();

        System.out.print("- Enter minimum rainfall for plant: ");
        minRain = input.nextInt();

        System.out.println("-".repeat(89));
    }
}
