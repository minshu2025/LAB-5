import java.util.ArrayList;

class Employee {
    private int id;
    private String name;
    private String department;

    // Default constructor
    public Employee() {
        this.id = 0;
        this.name = "#";
        this.department = "#";
    }

    // Constructor with parameters
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    // Getters (accessors)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    // Setters (mutators)
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id + ", Name: " + name + ", Department: " + department;
    }
}

