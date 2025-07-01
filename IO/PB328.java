package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*
 * Write a program to create a new file and write the number into it and
sort that file content into different file.
 */

public class PB328 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("File.txt"));
        bw.write("0\n79\n5\n60");
        bw.close();
        
        BufferedReader br = new BufferedReader(new FileReader("File.txt"));
        String line; ArrayList<Integer> numbers = new ArrayList<>();
        line = br.readLine();
        while (line != null) {
            numbers.add(Integer.parseInt(line));
            line = br.readLine();
        }

        Collections.sort(numbers);
        BufferedWriter bw1 = new BufferedWriter(new FileWriter("sorted.txt"));
        for(int num: numbers){
            bw1.write(String.valueOf(num));
            bw1.newLine();
        }
        bw1.close();
        br.close();
    }
}
