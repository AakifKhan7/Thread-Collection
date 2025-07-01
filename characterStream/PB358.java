package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/*
 * Write a program to replace all “word1” by “word2” to a file without using
temporary file and display the no. of replacement. 
 */

public class PB358 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("File.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("File.txt"));

            ArrayList<String> updatedLines = new ArrayList<>();

            String line = br.readLine();
            String word1 = "Hello";
            String word2 = "Hi";

            int totalReplacements = 0;
            while (line != null) {
                int countInLine = countOccurrences(line, word1);
                totalReplacements += countInLine;
                String updatedLine = line.replace(word1, word2);
                updatedLines.add(updatedLine);
                line = br.readLine();
            }

            for (String s : updatedLines) {
                bw.write(s);
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("Total replacements: " + totalReplacements);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static int countOccurrences(String line, String word) {
        return line.split(word, -1).length - 1;
    }
}
