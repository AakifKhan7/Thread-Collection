package collection_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * Write a program that reads in a list of words from a file and stores them
in a HashMap, along with their frequency (i.e. how many times they
appear in the file). The program should then prompt the user for a word
and output the corresponding frequency, or a message indicating that the
word is not in the map.
 */

public class PB289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("collection_2\\PB287.java"));

        HashMap<String, Integer> f = new HashMap<>();

        String line = "";
        while ((line = br.readLine()) != null) {
            String words[] = line.split(" ");
            for(String w: words){
                if(f.get(w) == null){
                    f.put(w, 1);
                }else{
                    f.put(w, f.get(w) + 1);
                }
            }
        }

        
        for(Map.Entry e: f.entrySet()){
            System.out.println("Count for: "+e.getKey() +  "  is = "+ e.getValue());
        }

        br.close();
    }
}
