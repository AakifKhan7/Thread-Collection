package IO;
/*
 * Write a program that counts the no. of words in a text file. The file name
is passed as a command line argument. The program should check
whether the file exists or not. The words in the file are separated by white
space characters
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PB322 {
    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            String line = br.readLine();
            int wordCount = 0;

            while (line != null) {
                String[] words = line.split(" ");
                wordCount += words.length;
                line = br.readLine();
            }
            System.out.println("Number of words in the file: " + wordCount);
            br.close();
        } catch (FileNotFoundException f) {
            System.out.println(f);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
