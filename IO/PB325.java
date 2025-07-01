package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a program that reads file name from user, through command line
argument and displays/reads content of the text file on console. 
 */

public class PB325 {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Please provide the file name as a command line argument.");
            return;
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
