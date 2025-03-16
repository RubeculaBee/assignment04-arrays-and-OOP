/*********************************************************************************
 *
 * File: DegreePlanner_OOP_RobinLane.java
 * By: Robin Lane
 * Date: 03-16-2025
 *
 * Description: Defines 4 1D arrays of Strings (representing a students
 *              classes for each semester), Then loads all of those
 *              strings into a 1D array of Semester objects. It then prints each
 *              string to the console.
 *
 *********************************************************************************/

public class DegreePlanner_OOP_RobinLane
{
    public static void main(String[] args)
    {
        String[] semester01 = {"csc101", "csc102", "csc103", "csc104", "csc105", "csc106"};
        String[] semester02 = {"csc201", "csc202", "csc203", "csc204", "csc205", "csc206"};
        String[] semester03 = {"csc301", "csc302", "csc303", "csc304", "csc305", "csc306"};
        String[] semester04 = {"csc401", "csc402", "csc403", "csc404", "csc405", "csc406"};

        Semester[] semesters = initSemesterArray(semester01, semester02, semester03, semester04);

        displaySemesterArray(semesters);
    }

    // Returns an array of Semester objects, each constructed using a given String array
    static Semester[] initSemesterArray(String[]... stringSemesters)
    {
        Semester[] semesters = new Semester[stringSemesters.length];

        for(int i = 0; i < stringSemesters.length; i++)
            semesters[i] = new Semester(stringSemesters[i]);

        return semesters;
    }

    // Prints an array of Semester objects
    static void displaySemesterArray(Semester[] semesters)
    {
        System.out.printf("Printing data... from one 1D Semester[] array containing %d items:\n", semesters.length);
        for(Semester semester : semesters)
            System.out.println(semester);
    }
}
