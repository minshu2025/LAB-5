import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Create New Employee Record");
            System.out.println("2. Update Employee Name by ID");
            System.out.println("3. Print All Employees");
            System.out.println("4. Print Department-Specific Employees");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    updateEmployeeName();
                    break;
                case 3:
                    printAllEmployees();
                    break;
                case 4:
                    printDepartmentSpecificEmployees();
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

    private static void createEmployee() {
        System.out.print("Enter Employee ID (or -1 for default): ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String name = "#";
        String department = "#";

        if (id != -1) {
            System.out.print("Enter Employee Name: ");
            name = scanner.nextLine();
            System.out.print("Enter Employee Department: ");
            department = scanner.nextLine();
            employees.add(new Employee(id, name, department));
        } else {
            employees.add(new Employee());
        }

        System.out.println("Employee record created.");
    }

    private static void updateEmployeeName() {
        System.out.print("Enter Employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                emp.setName(newName);
                System.out.println("Employee name updated.");
                return;
            }
        }

        System.out.println("Employee with ID " + id + " not found.");
    }

    private static void printAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        System.out.println("--- All Employees ---");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }

    private static void printDepartmentSpecificEmployees() {
        System.out.print("Enter Department to filter: ");
        String department = scanner.nextLine();
        boolean found = false;

        System.out.println("--- Employees in Department: " + department + " ---");
        for (Employee emp : employees) {
            if (emp.getDepartment().equalsIgnoreCase(department)) {
                System.out.println(emp);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No employees found in the " + department + " department.");
        }
    }
}

