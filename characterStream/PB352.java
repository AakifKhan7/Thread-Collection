package characterStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Write a java program that read employee details and store into emp.txt
text file using file handling.

 */

public class PB352 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of employees: ");
        int numEmployees = sc.nextInt();
        sc.nextLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter("emp.txt"));

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter employee name: ");
            String name = sc.nextLine();

            System.out.println("Enter employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter employee designation: ");
            String designation = sc.nextLine();

            System.out.println("Enter employee salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            bw.write("Name: " + name + "\n");
            bw.write("ID: " + id + "\n");
            bw.write("Designation: " + designation + "\n");
            bw.write("Salary: " + salary + "\n");
        }

        bw.close();sc.close();
    }
}
