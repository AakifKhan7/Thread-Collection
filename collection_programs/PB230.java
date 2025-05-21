package collection_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*Merge two sorted ArrayLists
Write a Java program to merge two sorted ArrayLists into a single sorted
ArrayList. You need to implement a function that takes two sorted
ArrayLists as input and returns a single sorted ArrayList containing all the
elements. */

public class PB230 {
    public static void main(String[] args) {
        ArrayList al1 = new ArrayList<>(Arrays.asList(2,  4, 5));
        ArrayList al2 = new ArrayList<>(Arrays.asList( 3, 6, 8));

        ArrayList merged = merge(al1, al2);

        System.out.println(merged);
    }

    static ArrayList merge(ArrayList al1, ArrayList al2){

        ArrayList merged = new ArrayList<>();

        merged.addAll(al1);
        merged.addAll(al2);

        merged.sort(Comparator.naturalOrder());

        return merged;
    }
}
