/**
 * Please implement class StudentClient by adding code to it.
 * Please DO NOT change the provided code. ONLY add more code.
 * 
 * Class:       StudentClient
 * File Name:   StudentClient.java
 *
 * @author Duc Ta
 */
public class StudentClient_RobinLane {

    public static void main(String[] args) {

        // Please add code to complete this program

        Student[] students = initStudents(3);
    }

    // Initialises and returns an array of students of the specified size, each student having no data.
    static Student[] initStudents(int size)
    {
        Student[] students = new Student[size]; // Initialise empty array of size 3

        for(int i = 0; i < students.length; i++)
        {
            students[i] = new Student(); // for each index in the student array, create new empty student
        }

        return students;
    }
}
