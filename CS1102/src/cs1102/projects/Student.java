package cs1102.projects;
import java.util.ArrayList;

/**
 * Student class with private instance variables for 
 * storing student information such as name, ID, age, and grade.
 * this class is part of the student management program.
 */

class Student {
    private String name;
    private int id;
    private int age;
    private double grade;

    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    public static void addStudent(Student student) {
        studentList.add(student);
        totalStudents++; // increment students count
    }

    public static Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static void updateStudentInfo(int id, double newGrade) {
        Student student = findStudentById(id);
        if (student != null) {
            student.setGrade(newGrade);
            System.out.println("Student information updated successfully.");
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static void viewStudentDetails(int id) {
        Student student = findStudentById(id);
        if (student != null) {
            System.out.println("Student Details:");
            System.out.println("Name: " + student.getName());
            System.out.println("ID: " + student.getId());
            System.out.println("Age: " + student.getAge());
            System.out.println("Grade: " + student.getGrade());
        } else {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}

