public class Array_2D_SingleDataType_RobinLane
{
    public static void main(String[] args)
    {
        char[][] alphabetNormal; //Standard array with 7 rows, each row with 7 columns
        char[][] alphabetJagged; //Jagged array with 7 rows, each row with varied columns

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
}
