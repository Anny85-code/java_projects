package gui.project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A GUI application for a Student Management System. 
 * The application provides a user-friendly interface for 
 * administrators to interact with student records, 
 * course enrollment, and grades. 
 * The GUI should is implemented with Java's GUI frameworks 'Swing'. 
 * Event handling mechanisms are employed to respond to user interactions, 
 * and the interface updates dynamically to reflect changes in student records.
 */

public class StudentEnrollmentManagementSystem extends JFrame {
    private List<Student> students;
    private List<Course> courses;
    private DefaultTableModel studentTableModel;
    private JComboBox<String> studentComboBox;
    private JComboBox<String> courseComboBox;
    private JComboBox<String> gradeComboBox;

    public StudentEnrollmentManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        studentTableModel = new DefaultTableModel();
        studentComboBox = new JComboBox<>();
        courseComboBox = new JComboBox<>();
        gradeComboBox = new JComboBox<>();
        
        initializeUI();
    }

    // the ui method for the main display
    private void initializeUI() {
        setTitle("Student Management System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // the menu bar or the navbar with some menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu studentMenu = new JMenu("Student");
        JMenuItem addStudentItem = new JMenuItem("Add Student");
        JMenuItem updateStudentItem = new JMenuItem("Update Student");
        JMenuItem viewStudentItem = new JMenuItem("View Student Details");
        

        JMenu gradeMenu = new JMenu("Assign Grade");
        JMenuItem assignGradeItem = new JMenuItem("Click to select Grade");

        gradeMenu.add(assignGradeItem);
        gradeMenu.add(gradeComboBox);
       // action event for the grade functionality
        assignGradeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAssignGradeDialog();
            }
        });

      //action event to add student
        addStudentItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 showAddStudentDialog();
            }
        });

        // action event to update student
        updateStudentItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	showUpdateStudentDialog();
            }
        });

        //action event to view student
        viewStudentItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	showViewStudentDetailsDialog();
            }
        });

        studentMenu.add(addStudentItem);
        studentMenu.add(updateStudentItem);
        studentMenu.add(viewStudentItem);

        JMenu courseMenu = new JMenu("Course");
        JMenuItem enrollStudentItem = new JMenuItem("Enroll Student");
        enrollStudentItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEnrollStudentDialog();
            }
        });
        
       //combobox for graade dropdown
        gradeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignGrade();
            }
        });

        courseMenu.add(enrollStudentItem);

        menuBar.add(studentMenu);
        menuBar.add(courseMenu);
        menuBar.add(gradeMenu);
        setJMenuBar(menuBar);

        //panel to display the students and courses avaialable
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 2, 10, 10));

        mainPanel.add(new JLabel("Available Students:"));
        mainPanel.add(studentComboBox);

        mainPanel.add(new JLabel("Available Courses:"));
        mainPanel.add(courseComboBox);
        

        getContentPane().add(mainPanel, BorderLayout.NORTH);
        getContentPane().add(new JScrollPane(new JTable(studentTableModel)), BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //methods for all event actions
    private void showAddStudentDialog() {
        String newStudentName = JOptionPane.showInputDialog(this, "Enter the new student's name:");
        if (newStudentName != null && !newStudentName.trim().isEmpty()) {
            addStudent(newStudentName);
        }
    }
    
    private void showUpdateStudentDialog() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        if (selectedStudent != null) {
            String updatedStudentName = JOptionPane.showInputDialog(this, "Update student name:", selectedStudent);
            if (updatedStudentName != null && !updatedStudentName.trim().isEmpty()) {
                updateStudent(selectedStudent, updatedStudentName);
            }
        } else {
            showSelectionErrorDialog();
        }
    }
    
    private void showAssignGradeDialog() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        String selectedCourse = (String) courseComboBox.getSelectedItem();

        if (selectedStudent != null && selectedCourse != null) {
            // Display a dialog to input the grade
            String selectedGrade = (String) JOptionPane.showInputDialog(
                    this,
                    "Assign a Grade for " + selectedStudent + " in " + selectedCourse + ":",
                    "Assign Grade",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"A", "B", "C", "D", "F"},
                    "A");

            if (selectedGrade != null) {
                Student student = getStudentByName(selectedStudent);
                if (student.getEnrolledCourse() != null && student.getEnrolledCourse().equals(selectedCourse)) {
                    student.setGrade(selectedCourse, selectedGrade);
                    updateStudentTable();
                    JOptionPane.showMessageDialog(this, "Grade assigned successfully.");
                }
            }
        } else {
            showSelectionErrorDialog();
        }
    }


    private void updateStudent(String oldName, String newName) {
        Student student = getStudentByName(oldName);
        if (student != null) {
            student.setName(newName);
            studentComboBox.removeItem(oldName);
            studentComboBox.addItem(newName);
            updateStudentTable();
        }
    }
    
    private void addStudent(String name) {
        Student newStudent = new Student(name);
        students.add(newStudent);
        studentComboBox.addItem(newStudent.getName());
        updateStudentTable();
    }

    private void showEnrollStudentDialog() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        String selectedCourse = (String) courseComboBox.getSelectedItem();

        if (selectedStudent != null && selectedCourse != null) {
            Student student = getStudentByName(selectedStudent);
            if (student.getEnrolledCourse() == null) {
                student.enroll(selectedCourse);
                updateStudentTable();
                JOptionPane.showMessageDialog(this, selectedStudent + " has been enrolled in " + selectedCourse);
            } else {
                JOptionPane.showMessageDialog(this, selectedStudent + " is already enrolled in a course.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showSelectionErrorDialog();
        }
    }
    
    private void showViewStudentDetailsDialog() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        if (selectedStudent != null) {
            Student student = getStudentByName(selectedStudent);
            if (student != null) {
                String details = "Name: " + student.getName() + "\n";
                details += "Enrolled Course: " + (student.getEnrolledCourse() != null ? student.getEnrolledCourse() : "Not Enrolled") + "\n";
                details += "Grade: " + (student.getGrade() != null ? student.getGrade() : "N/A");
                JOptionPane.showMessageDialog(this, details, "Student Details", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            showSelectionErrorDialog();
        }
    }

    private Student getStudentByName(String name) {
        for (Student student : students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }
    
    private void assignGrade() {
        String selectedStudent = (String) studentComboBox.getSelectedItem();
        if (selectedStudent != null) {
            Student student = getStudentByName(selectedStudent);
            if (student != null) {
                String selectedCourse = (String) courseComboBox.getSelectedItem();
                if (selectedCourse != null && student.getEnrolledCourse() != null && student.getEnrolledCourse().equals(selectedCourse)) {
                    String selectedGrade = (String) gradeComboBox.getSelectedItem();
                    if (selectedGrade != null) {
                        student.setGrade(selectedCourse, selectedGrade);
                        updateStudentTable();
                        JOptionPane.showMessageDialog(this, "Grade assigned successfully.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Please select a grade.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid course selection.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            showSelectionErrorDialog();
        }
    }


    private void updateStudentTable() {
        Vector<Vector<String>> dataVector = new Vector<>();
        for (Student student : students) {
            Vector<String> row = new Vector<>();
            row.add(student.getName());
            row.add(student.getEnrolledCourse() != null ? student.getEnrolledCourse() : "");
            row.add(student.getGrade() != null ? student.getGrade() : ""); // Handle null grade
            dataVector.add(row);
        }

        Vector<String> columnIdentifiers = new Vector<>();
        columnIdentifiers.add("Name");
        columnIdentifiers.add("Enrolled Course");
        columnIdentifiers.add("Grade");

        studentTableModel.setDataVector(dataVector, columnIdentifiers);
    }


    private void showSelectionErrorDialog() {
        JOptionPane.showMessageDialog(this, "Please select a student and a course.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // the student class
    private static class Student {
        private String name;
        private String enrolledCourse;
        private String grade;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
        
        public void setName(String name) {
            this.name = name;
        }

        public void enroll(String course) {
            this.enrolledCourse = course;
        }

        public String getEnrolledCourse() {
            return enrolledCourse;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String enrolledCourse, String grade) {
            if (this.enrolledCourse != null && this.enrolledCourse.equals(enrolledCourse)) {
                this.grade = grade;
            }
        }
    }

    private static class Course {
        private String name;

        public Course(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
    
    // the main method
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	StudentEnrollmentManagementSystem gui = new StudentEnrollmentManagementSystem();
            gui.setupTestData(); // Add test data for students and courses
        });
    }

    //testdata to make a list
    private void setupTestData() {
        // Add test data for students
        students.add(new Student("John Doe"));
        students.add(new Student("Jane Smith"));
        students.add(new Student("Bob Johnson"));

        // Add test data for courses
        courses.add(new Course("Math 101"));
        courses.add(new Course("History 202"));
        courses.add(new Course("Programming 303"));

        // Populate the student and course combo boxes
        for (Student student : students) {
            studentComboBox.addItem(student.getName());
        }

        for (Course course : courses) {
            courseComboBox.addItem(course.getName());
        }
    }
}

