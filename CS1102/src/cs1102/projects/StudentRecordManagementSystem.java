package cs1102.projects;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Student Record Management System for a university. 
 * The system enables administrators to effectively manage student records,
 * including adding new students, updating student information, and viewing student details.
 */

public class StudentRecordManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to a University Student Record Management System!!");
            System.out.println("Please choose an action to proceed:");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Please enter the options from 1 to 4 to make your choice: ");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addNewStudent();
                        break;
                    case 2:
                        updateStudentInformation();
                        break;
                    case 3:
                        viewStudentDetails();
                        break;
                    case 4:
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the buffer
            }
        }
    }

    private static void addNewStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter student grade: ");
        double grade = scanner.nextDouble();
        scanner.nextLine();

        Student student = new Student(name, id, age, grade);
        StudentManagement.addStudent(student);

        System.out.println("Student added successfully.");
    }

    
    private static void updateStudentInformation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter new grade: ");
        double newGrade = scanner.nextDouble();

        StudentManagement.updateStudentInfo(id, newGrade);
    }

    private static void viewStudentDetails() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();

        StudentManagement.viewStudentDetails(id);
    }
}

