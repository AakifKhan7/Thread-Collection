package characterStream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Write a program to display the bytes of a file in reverse sequence. Provide
the name of the file as a command line argument. 
 */

public class PB360 {
    public static void main(String[] args)throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java ReverseFileBytes <filename>");
            return;
        }
        File file = new File(args[0]);
        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found or is not a regular file.");
            return;
        }
        
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        long fileSize = raf.length();

        for(long p = fileSize -1; p >= 0; p++){
            raf.seek(p);
            byte byteValue = raf.readByte();
            System.out.println(byteValue);
        }
        raf.close();
    }
}
