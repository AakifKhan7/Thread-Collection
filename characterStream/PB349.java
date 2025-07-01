package characterStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Write a JAVA program to read student.txt file and display the content.

public class PB349 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("Student.txt"));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}
