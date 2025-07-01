package IO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

// Write a java program which read source file and destination file name and
// copy the content of source file to destination file using InputeStream
// class.


public class PB319 {
    public static void main(String[] args) {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter the source file name: ");
            String sourceFileName = reader.readLine();

            System.out.print("Enter the destination file name: ");
            String destinationFileName = reader.readLine();

            copyFile(sourceFileName, destinationFileName);

            System.out.println("File copied successfully.");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    static void copyFile(String sourceFileName, String destinationFileName) throws IOException{
        InputStream is = new FileInputStream(sourceFileName);
        OutputStream os = new FileOutputStream(destinationFileName);

        byte[] buffer  = new byte[1024];
        int byteRead;

        while ((byteRead = is.read(buffer)) != -1) {
            os.write(buffer, 0, byteRead);
        } 
        is.close();os.close();
    }
}
