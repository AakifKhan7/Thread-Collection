package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Write a program to sort the one file numbers to another.for example one
file contain the unsorted number separated by line and write the another
filr with sorted number. 

 */

public class PB361 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java SortNumbersFromFile <inputFile><outputFile>");
            return;
        }

        String inputFile = args[0];
        String outputFile = args[1];

        ArrayList<Integer> numbers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    numbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }

            reader.close();

            Collections.sort(numbers);
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
            for(int num: numbers){
                bw.write(String.valueOf(num));
                bw.newLine();
            }
            bw.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
