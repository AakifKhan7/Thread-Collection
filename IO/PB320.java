package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Write a java program which read numbers from number.txt file and store
even number to even.txt and odd number into odd.txt file

 */

public class PB320 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("File.txt"));
        BufferedWriter evenWriter = new BufferedWriter(new FileWriter("even.txt"));
        BufferedWriter oddWriter = new BufferedWriter(new FileWriter("Odd.txt"));

        String line = br.readLine();
        while (line != null) {
            int n = Integer.parseInt(line);
            if (n % 2 == 0) {
                evenWriter.write(Integer.toString(n));
                evenWriter.newLine();
                line = br.readLine();
            } else {
                oddWriter.write(Integer.toString(n));
                oddWriter.newLine();
                line = br.readLine();
            }
        }

        System.out.println("Numbers sorted and saved successfully!");
        evenWriter.close();
        oddWriter.close();
        br.close();
    }
}
