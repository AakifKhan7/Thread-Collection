package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * Write a Java program to copy content of file1.txt to file2.txt using Java file
handling
 */

public class PB356 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("File1.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("File2.txt"));

            String line = br.readLine();
            while (line != null) {
                bw.write(line);
                bw.newLine();
                line = br.readLine();
            }
            br.close();bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
