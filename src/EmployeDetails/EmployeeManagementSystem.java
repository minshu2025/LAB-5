package EmployeDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Create a New Employee Record");
            System.out.println("2. Print Details of All Employees");
            System.out.println("3. Print Employees Who Joined in 2019");
            System.out.println("4. Print Details Based on ID");
            System.out.println("5. Modify Employee Name Based on ID");
            System.out.println("6. Remove an Employee Based on ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    printAllEmployees();
                    break;
                case 3:
                    printEmployeesJoinedIn2019();
                    break;
                case 4:
                    printEmployeeById();
                    break;
                case 5:
                    modifyEmployeeName();
                    break;
                case 6:
                    removeEmployeeById();
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
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        System.out.print("Enter Date of Joining (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();
        LocalDate dateOfJoining = LocalDate.parse(dateStr);
        
        employees.add(new Employee(id, name, department, dateOfJoining));
        System.out.println("Employee record created.");
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

    private static void printEmployeesJoinedIn2019() {
        System.out.println("--- Employees Who Joined in 2019 ---");
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getDateOfJoining().getYear() == 2019) {
                System.out.println(emp);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found who joined in 2019.");
        }
    }

    private static void printEmployeeById() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp);
                return;
            }
        }
        
        System.out.println("Employee with ID " + id + " not found.");
    }

    private static void modifyEmployeeName() {
        System.out.print("Enter Employee ID to modify: ");
        int id = scanner.nextInt();
        
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.next();
                emp.setName(newName);
                System.out.println("Employee name updated.");
                return;
            }
        }
        
        System.out.println("Employee with ID " + id + " not found.");
    }

    private static void removeEmployeeById() {
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == id) {
                employees.remove(i);
                System.out.println("Employee removed.");
                return;
            }
        }
        
        System.out.println("Employee with ID " + id + " not found.");
    }
}

