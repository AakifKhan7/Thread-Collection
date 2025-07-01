package collection_2;

import java.util.HashSet;
import java.util.Scanner;

// Write a program that reads in a list of words from the user and stores
// them in a HashSet. The program should then prompt the user for a prefix
// and output all the words in the set that start with that prefix.


public class PB286 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashSet<String> words = new HashSet<>();

        while (true) {
            System.out.print("Enter Word ");
            String w = sc.nextLine();
            words.add(w);
            System.out.println("DO YOU WANT TO CONTINUE ? YES OR NO");
            
            String choice = sc.nextLine();
            if(choice.equalsIgnoreCase("NO")){
                break;
            }
        }  

        System.out.print("Enter prefix for the word that you want to search from HashSet ? ");
        String prefix = sc.next();
        for(String s: words){
            if(s.startsWith(prefix)){
                System.out.println("---> "+s );
            }
        }

        sc.close();
    }
}
