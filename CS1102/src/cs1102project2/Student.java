package cs1102project2;
import java.util.ArrayList;
import java.util.List;

/**
 * Student class with private instance variables for 
 * storing student information such as name, ID, age, and grade.
 * this class is part of the student management program.
 */

class Student {
    private String name;
    private int id;
    private List<Course> enrolledCourses;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    public void assignGrade(Course course, int grade) {
        course.setGrade(this, grade);
    }
}

/**
 * The Course class with private instance variables to store course information 
 * such as course code, name, and maximum capacity.
 * public getter methods for accessing course information.
 * static variables to keep track of the total number of enrolled students across all instances of the Course class.
 *  method to retrieve the total number of enrolled students.
 */

class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private static int totalEnrolledStudents = 0;

    private List<Student> enrolledStudents;
    private List<Integer> grades;

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.grades = new ArrayList<>();
    }

    //getters
    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
        } else {
            System.out.println("Course is full. Cannot enroll more students.");
        }
    }

    //grade setter
    public void setGrade(Student student, int grade) {
        int studentIndex = enrolledStudents.indexOf(student);
        if (studentIndex != -1) {
            if (studentIndex < grades.size()) {
                // Update existing grade
                grades.set(studentIndex, grade);
            } else {
                // Add a new grade if the list is not large enough
                grades.add(grade);
            }
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

}

/**
 * The CourseManagement class with private static variables to store 
 * a list of courses and the overall course grades for each student.
 * static methods to add new courses, enroll students, assign grades, 
 * and calculate overall course grades for each student.
 * addCourse method accept parameters for course information and create a new Course object. 
 * then add the course to the list of courses.
 */

class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Integer> overallGrades = new ArrayList<>();

    public static void addCourse(String courseCode, String courseName, int maxCapacity) {
        Course newCourse = new Course(courseCode, courseName, maxCapacity);
        courses.add(newCourse);
        overallGrades.add(0); // Initialize overall grade for this course
    }

    public static void enrollStudent(Student student, Course course) {
        course.enrollStudent(student);
        student.enrollCourse(course);
    }

    public static void assignGrade(Student student, Course course, int grade) {
        course.setGrade(student, grade);
    }

    public static void calculateOverallGrade(Student student) {
        int studentIndex = -1;

        // Find the index of the student in the list of courses
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getEnrolledStudents().contains(student)) {
                studentIndex = i;
                break;
            }
        }

        if (studentIndex != -1) {
            List<Integer> grades = courses.get(studentIndex).getGrades();

            // Check if the student is enrolled in any courses
            if (!grades.isEmpty()) {
                System.out.println("Grades for " + student.getName() + ":");
                
                // Display grades for each course
                for (int i = 0; i < courses.size(); i++) {
                    Course course = courses.get(i);
                    int grade = grades.get(i);
                    System.out.println(course.getCourseName() + ": " + grade);
                }

                // Calculate the total grade for the student across all courses
                int totalGrade = grades.stream().mapToInt(Integer::intValue).sum();
                
                // Calculate the overall grade for the student
                int overallGrade = totalGrade / grades.size();
                overallGrades.set(studentIndex, overallGrade);

                System.out.println("Overall grade for " + student.getName() + ": " + overallGrade);
            } else {
                System.out.println("Student " + student.getName() + " is not enrolled in any courses.");
            }
        } else {
            System.out.println("Student is not enrolled in any courses.");
        }
    }


    public static List<Course> getCourses() {
        return courses;
    }
}

