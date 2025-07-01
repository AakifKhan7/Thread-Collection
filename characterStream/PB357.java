package characterStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write an application that reads a file and counts the number of
occurrences of digit 5. Supply the file name as a command-line argument
 */

public class PB357 {
    public static void main(String[] args) throws IOException{
        if(args.length != 1){
            System.out.println("Usage: java PB357 <filename>");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String line = br.readLine();
        int count = 0;
        while (line != null) {
            char[] ch = line.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if(ch[i] == '5'){
                    count++;
                }
            }
            line = br.readLine();
        }
        br.close();
        System.out.println("Number of occurrences of digit 5 in the file: " + count);
    }
}
