/*********************************************************************************
 *
 * File: Array_2D_SingleDataType_RobinLane.java
 * By: Robin Lane
 * Date: 03-04-2025
 *
 * Description: Initialises two 2D arrays of characters. One array is standard,
 *              one is jagged. Each array contains the capital english letters
 *              from A-Z. When run the program will print the contents of both
 *              arrays to the console with the desired spacing and formatting.
 *
 *********************************************************************************/


public class Array_2D_SingleDataType_RobinLane
{
    static char[][] alphabetNormal; //Standard array with 7 rows, each row with 7 columns
    static char[][] alphabetJagged; //Jagged array with 7 rows, each row with varied columns

    public static void main(String[] args)
    {
        initArrays();
    }

    // Method initializes both 2D arrays. Seperated into its own method for readability
    static void initArrays()
    {
        alphabetNormal = new char[][] //Spaces used as padding to keep the array uniform
                {
                        {'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                        {' ', ' ', ' ', 'H', 'I', 'J', 'K'},
                        {' ', ' ', 'L', 'M', 'N', 'O', 'P'},
                        {' ', ' ', ' ', ' ', 'Q', 'R', 'S'},
                        {' ', ' ', ' ', ' ', 'T', 'U', 'V'},
                        {' ', ' ', ' ', ' ', ' ', 'W', 'X'},
                        {' ', ' ', ' ', ' ', ' ', 'Y', 'Z'},
                };

        alphabetJagged = new char[][] //Sub-arrays of different length makes this 2D array jagged
                {
                        {'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                        {'H', 'I', 'J', 'K'},
                        {'L', 'M', 'N', 'O', 'P'},
                        {'Q', 'R', 'S'},
                        {'T', 'U', 'V'},
                        {'W', 'X'},
                        {'Y', 'Z'},
                };
    }

    // Takes a 2D array and prints it's content to the screen with 3-width spacing between each entry
    static void print2DCharArray(char[][] charArray2D)
    {
        String[] stringArray = new String[charArray2D.length];

        System.out.println("Displaying contents in any 2D arrays:");

        for(int i = 0; i < charArray2D.length; i++) // Loops through the 2D array, converting each sub-array to a string
        {
            stringArray[i] = charArrayToString(charArray2D[i]);
        }

        for (String str : stringArray) // Loops through each string and prints it to screen, centered right.
        {
            System.out.printf("%28s\n",str);
        }
    }

    /* Takes an array of characters and returns a string of those characters with an amount of
       spaces between each letter equal to spaceWidth */
    static String charArrayToString(char[] charArray)
    {
        String formattedString = "";

        for(char c : charArray)
        {
            formattedString += c;
            formattedString += "   "; // Each character in the formatted string is seperated by 3 spaces.
        }

        return formattedString;
    }
}
