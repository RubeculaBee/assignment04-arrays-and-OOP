/*********************************************************************************
 *
 * File: Semester.java
 * By: Robin Lane
 * Date: 03-16-2025
 *
 * Description: This class represents a semester of course that a student will
 *              take. It stores an array of courses as an attribute, and will be able
 *              to set and get those courses as behaviours.
 *
 *********************************************************************************/

public class Semester
{
    private String[] courses;   // Stores each course taken in this semester
    static int numSemesters = 0; // Counts how many semesters have been defined
    private final int INDEX; // Stores the number that corresponds to this semester (can not be changed)

    // Semester can be constructed with a size, but undefined courses
    public Semester(int numCourses)
    {
        numSemesters++;
        this.INDEX = numSemesters;
        this.courses = new String[numCourses];
    }

    // Semester can be constructed from an array of course
    public Semester(String[] courses)
    {
        numSemesters++;
        this.INDEX = numSemesters;
        this.courses = courses;
    }

    // Returns the array of courses
    public String[] getCourses()
    {
        return this.courses;
    }

    // Returns a specific course
    public String getCourse(int courseNum)
    {
        return this.courses[courseNum];
    }

    // Initialises the array of courses.
    public void setCourses(String[] courses)
    {
        this.courses = courses;
    }

    // Initialises a specific course.
    public void setCourse(int courseNum, String course)
    {
        this.courses[courseNum] = course;
    }

    @Override
    public String toString()
    {
        // Start each print with the semester's index
        String courses = String.format(" - Semester #%d:", this.INDEX);

        // Add each course, seperated by a space and a comma
        for(String course: this.courses)
            courses += String.format(" %s,", course);

        // Remove the last unnecessary comma
        courses += "\b";

        return courses;
    }
}
