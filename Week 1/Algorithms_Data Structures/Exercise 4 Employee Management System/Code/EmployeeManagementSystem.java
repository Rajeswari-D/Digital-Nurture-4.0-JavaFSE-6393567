import java.util.Scanner;

class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: Rs " + salary);
    }
}

public class EmployeeManagementSystem {
    private static final int MAX_EMPLOYEES = 100;
    private static Employee[] employees = new Employee[MAX_EMPLOYEES];
    private static int count = 0;

    // Add employee
    public static void addEmployee(Employee e) {
        if (count < MAX_EMPLOYEES) {
            employees[count++] = e;
            System.out.println("Employee added.");
        } else {
            System.out.println("Cannot add more employees. Array is full.");
        }
    }

    // Search employee by ID
    public static Employee searchById(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    // Traverse all employees
    public static void listAll() {
        if (count == 0) {
            System.out.println("No employees to display.");
        }
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    // Delete employee by ID
    public static boolean deleteById(String id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId.equals(id)) {
                // Shift left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                return true;
            }
        }
        return false;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. List All Employees");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Position: ");
                    String pos = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    addEmployee(new Employee(id, name, pos, sal));
                    break;

                case 2:
                    System.out.print("Enter Employee ID to search: ");
                    String searchId = sc.nextLine();
                    Employee emp = searchById(searchId);
                    if (emp != null) emp.display();
                    else System.out.println("Employee not found.");
                    break;

                case 3:
                    listAll();
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    String delId = sc.nextLine();
                    if (deleteById(delId)) System.out.println("Employee deleted.");
                    else System.out.println("Employee not found.");
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
