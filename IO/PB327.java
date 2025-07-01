package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a program to find the sum of all the number in Number.txt file and
print the result in console
 */

public class PB327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Number.txt"));

        int sum = 0;
        String line;
        while ((line = br.readLine()) != null) {
            sum += Integer.parseInt(line);
        }

        System.out.println("Sum of numbers in " + "Number.txt" + ": " + sum);
        br.close();
    }
}
