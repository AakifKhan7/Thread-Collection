package collection_programs;

import java.util.Scanner;
import java.util.Stack;

/*
 * Write a Java program to sort a stack of Student objects by their GPA. You
need to implement a function that takes a stack of Student objects as
input and returns a new stack with the Students sorted in descending
order of their GPA.
To solve this problem, you can create a Student class with attributes such
as name, id, and GPA. You can then create a stack of Student objects and
implement a function to sort the stack by their GPA.

 */

public class PB243 {
    Scanner sc = new Scanner(System.in);
    Stack<Student> s = new Stack<>();

    public static void main(String[] args) {
        PB243 obj = new PB243();

        // Adding some students for testing
        obj.s.push(new Student("Amit", 101, 8.9));
        obj.s.push(new Student("Nina", 102, 9.2));
        obj.s.push(new Student("Zara", 103, 7.5));
        obj.s.push(new Student("Raj", 104, 9.0));

        Stack<Student> sorted = obj.sortByGPA(obj.s);

        System.out.println("Students sorted by GPA (High to Low):");
        while (!sorted.isEmpty()) {
            Student st = sorted.pop();
            System.out.println(st.name + " (ID: " + st.id + ", GPA: " + st.GPA + ")");
        }
    }

    Stack<Student> sortByGPA(Stack<Student> inpStack) {
        Stack<Student> sortedStack = new Stack<>();

        while (!inpStack.isEmpty()) {
            Student temp = inpStack.pop();

            while (!sortedStack.isEmpty() && sortedStack.peek().getGPA() < temp.getGPA()) {
                inpStack.push(sortedStack.pop());
            }

            sortedStack.push(temp);
        }

        return sortedStack;
    }

}

class Student {
    String name;
    int id;
    double GPA;

    Student(String name, int id, double GPA) {
        this.name = name;
        this.id = id;
        this.GPA = GPA;
    }

    double getGPA() {
        return GPA;
    }
}
