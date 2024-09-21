import java.util.Scanner;

public class StudentManagementSystem {
    private static Student[] students = new Student[10];
    private static int studentCount = 0; // Track the number of students
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Create a New Student");
            System.out.println("2. Print Details of All Students");
            System.out.println("3. Print Details Based on ID");
            System.out.println("4. Modify Student Name Based on ID");
            System.out.println("5. Remove a Student Based on ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    printAllStudents();
                    break;
                case 3:
                    printStudentById();
                    break;
                case 4:
                    modifyStudentName();
                    break;
                case 5:
                    removeStudentById();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void createStudent() {
        if (studentCount >= 10) {
            System.out.println("Cannot add more students. Maximum limit reached.");
            return;
        }
        
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        
        students[studentCount] = new Student(id, name);
        studentCount++;
        System.out.println("Student created.");
    }

    private static void printAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("--- All Students ---");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(students[i]);
        }
    }

    private static void printStudentById() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                System.out.println(students[i]);
                return;
            }
        }
        
        System.out.println("Student with ID " + id + " not found.");
    }

    private static void modifyStudentName() {
        System.out.print("Enter Student ID to modify: ");
        int id = scanner.nextInt();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.next();
                students[i].setName(newName);
                System.out.println("Student name updated.");
                return;
            }
        }
        
        System.out.println("Student with ID " + id + " not found.");
    }

    private static void removeStudentById() {
        System.out.print("Enter Student ID to remove: ");
        int id = scanner.nextInt();
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                // Shift students to fill the gap
                for (int j = i; j < studentCount - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[studentCount - 1] = null; // Clear last entry
                studentCount--;
                System.out.println("Student removed.");
                return;
            }
        }
        
        System.out.println("Student with ID " + id + " not found.");
    }
}

