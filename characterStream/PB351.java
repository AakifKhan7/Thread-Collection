package characterStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a java program to search the file named the word entered as a
filename from command line; if it exists in the system then program
should print the content of a file on console. 

 */

public class PB351 {
    public static void main(String[] args)throws IOException {
        if(args.length != 1){
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        if(!file.exists()){
            System.out.println("File not found.");
            return;
        }

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
        br.close();
    }
}
