package characterStream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/*
 * Write a program to read the content of a file into a character array and
write it into another file. Get names of the files from command line. 

 */

public class PB350 {
    public static void main(String[] args)throws Exception {
        if(args.length != 2){
            System.out.println("Usage: java FileCopy <source-file> <destination-file>");
            return;
        }

        String sourceFileName = args[0];
        String destinationFileName = args[1];

        FileReader fr = new FileReader(sourceFileName);
        int fileSize = (int) new File(sourceFileName).length();

        char[] content = new char[fileSize];
        fr.read(content);

        fr.close();

        FileWriter fw = new FileWriter(destinationFileName);
        fw.write(content);
        fw.close();

    }
}
