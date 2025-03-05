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

    /* Takes an array of characters and returns a string of those characters with an amount of
       spaces between each letter equal to spaceWidth */
    static String charArrayToString(char[] charArray, int spaceWidth)
    {
        String formattedString = "";

        for(char c : charArray)
        {
            formattedString += c;
            formattedString += " ".repeat(spaceWidth);
        }

        return formattedString;
    }
}
