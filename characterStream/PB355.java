package characterStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * Write a java program to search the file named the word entered as a
filename from commandline: If it existsin the system the program should
print the contemts of the file on console

 */

public class PB355 {
    public static void main(String[] args) throws IOException{
        if(args.length != 1){
            System.out.println("Usage: java PB355 <filename>");
            return;
        }

        String file = args[0];
        File f = new File(file);
        if(f.exists()){
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();
        }else{
            System.out.println("File not found");
        }
    }
}
