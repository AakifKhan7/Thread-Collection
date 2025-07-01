package IO;
/*
 * Read employee salary and calculate the income tax based on 10% of
income and store it in tax.txt file for five different employees.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PB321 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("tax.txt"));

        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter salary for Employee " + i + ": ");
            double salary = sc.nextDouble();

            double tax = calculateIncomeTax(salary);
            bw.write("Employee " + i + ": " + tax);
            bw.newLine();
        }
        bw.close();
        System.out.println("Income tax calculated and saved to tax.txt.");

        sc.close();
    }

    static double calculateIncomeTax(double salary){
        return salary * 0.10;
    }
}
