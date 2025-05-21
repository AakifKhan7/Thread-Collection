package collection_programs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/*
 * Write a Java program to remove duplicates from an ArrayList as per given
input and output. Take main class 'Exam'. Create ArrayList: [1, 2, 3, 4, 4, 5,
6, 7, 8, 9, 6, 9, 1, 1, 10] in main method then you need to implement
another method named 'removeDuplicate' that takes an ArrayList as an
argument , removes all duplicates and returns an ArrayList without
duplicates. At end print that Arraylist from main method. (No need to use
Scannner)
Output of your code should be:- [2, 3, 5, 7, 8, 10] 
 */

public class PB228 {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 9, 1, 1, 10));
        ArrayList<Integer> result = removeDuplicates(al1);

        System.out.println(result);
    }

    static ArrayList<Integer> removeDuplicates(ArrayList<Integer> al){
        ArrayList<Integer> result = new ArrayList<>();

        for(Integer item: al){
            if(Collections.frequency(al, item) == 1){
                result.add(item);
            }
        }
        return result;
    }
}

