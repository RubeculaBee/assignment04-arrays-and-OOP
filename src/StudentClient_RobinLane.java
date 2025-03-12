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

        Scanner input = new Scanner(System.in);

        Student[] students = initStudents(3);

        System.out.printf("[+] Creating %d students...\n", students.length);
        for(int i = 0; i < students.length; i++)
            addStudentInfo(students[i], i+1);

        System.out.printf("[+] The %d students created:\n", students.length);
        for(Student student : students)
            System.out.println(student);

        System.out.print("\n[-] Enter a student's full name to update the student: ");
        updateStudent(findStudent(students, input.nextLine()));

        System.out.printf("\n[+] The %d students updated:\n", students.length);
        for(Student student : students)
            System.out.println(student);
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
    static void addStudentInfo(Student student, int index)
    {
        Scanner input = new Scanner(System.in);

        System.out.printf("- Enter a name for student #%d: ", index);
        student.setName(input.nextLine());
        System.out.printf("- Enter a GPA for student #%d: ", index);
        student.setGpa(input.nextDouble());
        System.out.print("\n");
    }

    // Searches through a given student array. If the given student name is found in the array, return that student.
    static Student findStudent(Student[] students, String name)
    {
        for (Student student : students)
            if(student.getName().equalsIgnoreCase(name))
                return student;

        return null; // If the given name isn't found, return null.
    }

    // Takes a student and updates their name and gpa based on user input
    static void updateStudent(Student student)
    {
        if(student == null) // If given a null student, exit the method without doing anything
            return;

        Scanner input = new Scanner(System.in);

        System.out.print("[-] Enter new student name: ");
        student.setName(input.nextLine());
        System.out.print("[-] Enter new student gpa: ");
        student.setGpa(input.nextDouble());
    }
}
