package collection_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


/*
 * Write a Java program that creates an ArrayList to store a list of students
and their grades. The program should provide the following functionality:
Add a student: The program should prompt the user for a student name
and their grade, and add the student to the ArrayList.
Remove a student: The program should prompt the user for a student
name and remove the corresponding entry from the ArrayList.
Search for a student: The program should prompt the user for a student
name and output their corresponding grade. If the student name is not
found in the ArrayList, the program should output an error message.
Sort students by name: The program should sort the ArrayList by student
name in ascending order.
Sort students by grade: The program should sort the ArrayList by student
grade in descending order.
To accomplish these tasks, you can use the following Collections class
methods:
addAll(collection, elements): Adds all elements from one collection to 
another. sort(list): Sorts the elements in a list in natural order.
sort(list, comparator): Sorts the elements in a list using a custom
comparator. reverse(list): Reverses the order of the elements in a list.
You can also use the following ArrayList methods:
add(element): Adds an element to the end of the ArrayList.
remove(element): Removes the first occurrence of an element from the
ArrayList. get(index): Returns the element at the specified index in the
ArrayList. size(): Returns the number of elements in the ArrayList.
 */


public class PB233 {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nStudent Grade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Sort by Name");
            System.out.println("5. Sort by Grade");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    manager.addStudent();
                    break;
                case 2:
                    manager.removeStudent();
                    break;
                case 3:
                    manager.searchStudent();
                    break;
                case 4:
                    manager.sortByName();
                    break;
                case 5:
                    manager.sortByGrade();
                    break;
                case 6:
                    manager.displayAll();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);

        sc.close();
    }
}

class Students {
    private String name;
    private double grade;

    Students(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }

    public String toString() {
        return "Name: " + name + ", Grade: " + grade;
    }
}

class StudentManager {
    ArrayList<Students> students = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    void addStudent() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();

        students.add(new Students(name, grade));
        System.out.println("Student added successfully.");
    }

    void removeStudent() {
        System.out.print("Enter student name to remove: ");
        String name = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                System.out.println("Student removed.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    void searchStudent() {
        System.out.print("Enter student name to search: ");
        String name = sc.nextLine();

        boolean found = false;
        for (Students s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + s);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    void sortByName() {
        Collections.sort(students, Comparator.comparing(Students::getName));
        System.out.println("Students sorted by name.");
    }

    void sortByGrade() {
        Collections.sort(students, Comparator.comparing(Students::getGrade).reversed());
        System.out.println("Students sorted by grade (descending).");
    }

    void displayAll() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\nStudent List:");
            for (Students s : students) {
                System.out.println(s);
            }
        }
    }
}

