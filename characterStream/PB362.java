package characterStream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Write a java program which read numbers from number.txt file and store
even number to even.txt and odd number into odd.txt file. 
 */

public class PB362 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("number.txt"));
        BufferedWriter odd = new BufferedWriter(new FileWriter("odd.txt"));
        BufferedWriter even = new BufferedWriter(new FileWriter("even.txt"));

        String line = br.readLine();
        while (line != null) {
            int num = Integer.parseInt(line);
            if(num%2 == 0){
                even.write(num);
            }else{
                odd.write(num);
            }
        }

        br.close();
        odd.close();even.close();
    }
}
