import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private double marks;

    // Constructor
    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    // Setter
    public void setMarks(double marks) {
        this.marks = marks;
    }

    // New Method: Get Grade
    public String getGrade() {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else
            return "F";
    }

    // Display Student Details
    public void displayStudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Marks      : " + marks);
        System.out.println("Grade      : " + getGrade());
        System.out.println("--------------------------");
    }
}

class StudentManagement {
    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {
        for (Student s : students) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        students.add(student);
        System.out.println("Student added successfully.");
    }

    // Display Students
    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayStudent();
        }
    }

    // Search Student
    public void searchStudent(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                System.out.println("Student Found:");
                student.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Delete Student
    public void deleteStudent(int id) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                students.remove(student);
                System.out.println("Student deleted successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }

    // Update Marks
    public void updateMarks(int id, double marks) {
        for (Student student : students) {
            if (student.getStudentId() == id) {
                student.setMarks(marks);
                System.out.println("Marks updated successfully.");
                return;
            }
        }

        System.out.println("Student not found.");
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Update Marks");
            System.out.println("6. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    sm.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    sm.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    id = sc.nextInt();

                    sm.searchStudent(id);
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    id = sc.nextInt();

                    sm.deleteStudent(id);
                    break;

                case 5:
                    System.out.print("Enter Student ID: ");
                    id = sc.nextInt();

                    System.out.print("Enter New Marks: ");
                    marks = sc.nextDouble();

                    sm.updateMarks(id, marks);
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}