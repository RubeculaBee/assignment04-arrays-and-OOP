/*********************************************************************************
 *
 * File: Array_2D_SingleDataType_RobinLane.java
 * By: Robin Lane
 * Date: 03-05-2025
 *
 * Description: Initialises two 2D arrays of characters. One array is standard,
 *              one is jagged. Each array contains the capital english letters
 *              from A-Z. When run the program will print the contents of both
 *              arrays to the console with the desired spacing and formatting.
 *
 *********************************************************************************/


public class Array_2D_SingleDataType_RobinLane
{
    static char[][] alphabetNormal = new char[7][7]; //Standard array with 7 rows, each row with 7 columns
    static char[][] alphabetJagged = new char[7][]; //Jagged array with 7 rows, each row with varied columns

    public static void main(String[] args)
    {
        initArrays();

        print2DCharArray(alphabetNormal);
        System.out.print("\n");
        print2DCharArray(alphabetJagged);
    }

    // Method initializes both 2D arrays. Seperated into its own method for readability
    static void initArrays()
    {
        //Initialised using the shorthand method
        //Spaces used as padding to keep the array uniform
        alphabetNormal = new char[][]
                {
                        {'A', 'B', 'C', 'D', 'E', 'F', 'G'},
                        {' ', ' ', ' ', 'H', 'I', 'J', 'K'},
                        {' ', ' ', 'L', 'M', 'N', 'O', 'P'},
                        {' ', ' ', ' ', ' ', 'Q', 'R', 'S'},
                        {' ', ' ', ' ', ' ', 'T', 'U', 'V'},
                        {' ', ' ', ' ', ' ', ' ', 'W', 'X'},
                        {' ', ' ', ' ', ' ', ' ', 'Y', 'Z'},
                };

        //Initialised using the multistep method
        //Sub-arrays of different length makes this 2D array jagged
        alphabetJagged[0] = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        alphabetJagged[1] = new char[] {'H', 'I', 'J', 'K'};
        alphabetJagged[2] = new char[] {'L', 'M', 'N', 'O', 'P'};
        alphabetJagged[3] = new char[] {'Q', 'R', 'S'};
        alphabetJagged[4] = new char[] {'T', 'U', 'V'};
        alphabetJagged[5] = new char[] {'W', 'X'};
        alphabetJagged[6] = new char[] {'Y', 'Z'};
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
