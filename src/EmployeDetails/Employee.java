package EmployeDetails;

import java.time.LocalDate;

class Employee {
    private int id;
    private String name;
    private String department;
    private LocalDate dateOfJoining;

    // Default constructor
    public Employee() {
        this.id = 0;
        this.name = "#";
        this.department = "#";
        this.dateOfJoining = LocalDate.now(); // Defaults to current date
    }

    // Constructor with parameters
    public Employee(int id, String name, String department, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.dateOfJoining = dateOfJoining;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Department: " + department + ", Date of Joining: " + dateOfJoining;
    }
}

