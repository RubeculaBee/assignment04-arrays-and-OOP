/**
 * Please implement class StudentClient by adding code to it.
 * Please DO NOT change the provided code. ONLY add more code.
 * 
 * Class:       StudentClient
 * File Name:   StudentClient.java
 *
 * @author Duc Ta
 */
import java.util.Scanner;
public class StudentClient_RobinLane {

    public static void main(String[] args) {

        // Please add code to complete this program

        Student[] students = initStudents(3);

        for(int i = 0; i < students.length; i++)
            getStudentInfo(students[i], i+1);
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

    // For a given student, set their name and gpa based on information given by the user
    // The integer 'index' is used solely by the prompt so that each student is referred to by a number
    static void getStudentInfo(Student student, int index)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("- Enter a name for student #%d: ", index);
        student.setName(input.nextLine());
        System.out.printf("- Enter a GPA for student #%d: ", index);
        student.setGpa(input.nextDouble());
        System.out.print("\n");
    }
}
