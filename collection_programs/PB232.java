package collection_programs;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Problem Statement: Employee Management System
 * Implement an employee management system in Java using ArrayList and
 * a class. The system should have the following functionalities:
 * - Add an employee to the system
 * - Remove an employee from the system
 * - Update an employee's details
 * - Display all employees in the system
 */

public class PB232 {
    public static void main(String[] args) {
        EMS system = new EMS();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Display Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    system.add();
                    break;
                case 2:
                    system.remove();
                    break;
                case 3:
                    system.update();
                    break;
                case 4:
                    system.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}

class Employee {
    String name;
    int age;
    double salary;

    Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Salary: " + salary;
    }
}

class EMS {
    ArrayList<Employee> ae = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void add() {
        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter employee age: ");
        int age = sc.nextInt();

        System.out.print("Enter employee salary: ");
        double salary = sc.nextDouble();
        sc.nextLine();

        Employee e = new Employee(name, age, salary);
        ae.add(e);
        System.out.println("Employee added successfully.");
    }

    void remove() {
        System.out.print("Enter employee name to remove: ");
        String name = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < ae.size(); i++) {
            if (ae.get(i).name.equalsIgnoreCase(name)) {
                ae.remove(i);
                System.out.println("Employee removed successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    void update() {
        System.out.print("Enter employee name to update: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Employee e : ae) {
            if (e.name.equalsIgnoreCase(name)) {
                System.out.print("Enter new age: ");
                e.age = sc.nextInt();
                System.out.print("Enter new salary: ");
                e.salary = sc.nextDouble();
                sc.nextLine(); // clear buffer
                System.out.println("Employee updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    void display() {
        if (ae.isEmpty()) {
            System.out.println("No employees in the system.");
        } else {
            System.out.println("\nList of Employees:");
            for (Employee e : ae) {
                System.out.println(e);
            }
        }
    }
}
