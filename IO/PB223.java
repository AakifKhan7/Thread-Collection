package IO;
/*
 * Write a program to check that whether the name given from command
line is file or not? If it is a file then print the size of file and if it is directory
then it should display the name of all files in it
 */

import java.io.File;

public class PB223 {
    public static void main(String[] args) {
        File f = new File(args[0]);

        if (f.isFile()) {
            System.out.println(f.length());
        } else if (f.isDirectory()) {
            File[] files = f.listFiles();
            
            for (File file : files) {
                System.out.println(file);
            }
        } else {
            System.out.println("The given path does not exist or is neither a file nor a directory.");
        }
    }
}
