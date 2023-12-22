package cs1102project2;

import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
        	System.out.println("Welcome to Course Enrollment and Grade Management System !!");
        	System.out.println("Please select an option to proceed:");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add Course
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();
                    scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter max capacity: ");
                    int maxCapacity = scanner.nextInt();

                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    System.out.println("Course added sucessfully!");
                    break;
                case 2:
                    // Enroll Student
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();

                    // Create a new Student object
                    Student student = new Student(studentName, studentId);

                    // Get course info
                    System.out.print("Enter course code to enroll in: ");
                    String enrollCourseCode = scanner.next();

                    // Enroll the student in a course
                    Course enrollCourse = findCourseByCode(enrollCourseCode);
                    if (enrollCourse != null) {
                        CourseManagement.enrollStudent(student, enrollCourse);
                    } else {
                        System.out.println("Course not found.");
                    }
                    System.out.println("Student enrolled sucessfully!");
                    break;
                case 3:
                    // Assign Grade
                    // Get student info
                    System.out.print("Enter student ID: ");
                    int assignStudentId = scanner.nextInt();

                    // Get course info
                    System.out.print("Enter course code to assign grade: ");
                    String assignCourseCode = scanner.next();

                    // Get grade info
                    System.out.print("Enter grade: ");
                    int grade = scanner.nextInt();

                    // Assign a grade
                    Student assignStudent = findStudentById(assignStudentId);
                    Course assignCourse = findCourseByCode(assignCourseCode);

                    if (assignStudent != null && assignCourse != null) {
                        CourseManagement.assignGrade(assignStudent, assignCourse, grade);
                    } else {
                        System.out.println("Student or course not found.");
                    }
                    System.out.println("Grade assigned sucessfully!");
                    break;
                case 4:
                    // Calculate Overall Grade
                    // Get student info
                    System.out.print("Enter student ID to calculate overall grade: ");
                    int overallStudentId = scanner.nextInt();

                    // Calculate overall grade
                    Student overallStudent = findStudentById(overallStudentId);
                    if (overallStudent != null) {
                        CourseManagement.calculateOverallGrade(overallStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    scanner.close(); // Close the Scanner before exiting
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to find a course by code
    private static Course findCourseByCode(String code) {
        for (Course course : CourseManagement.getCourses()) {
            if (course.getCourseCode().equals(code)) {
                return course;
            }
        }
        return null;
    }

    // Helper method to find a student by ID
    private static Student findStudentById(int id) {
        for (Course course : CourseManagement.getCourses()) {
            for (Student student : course.getEnrolledStudents()) {
                if (student.getId() == id) {
                    return student;
                }
            }
        }
        return null;
    }
}
