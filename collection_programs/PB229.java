package collection_programs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
 * Remove Duplicates from an ArrayList
Write a Java program to remove duplicates from an ArrayList. You need
to implement a function that takes an ArrayList as input and returns an
ArrayList with duplicates removed.
 */

public class PB229 {
    public static void main(String[] args) {
        ArrayList al1 = new ArrayList();
        al1.add("apple");
        al1.add("banana");
        al1.add("apple");
        al1.add("orange");
        al1.add("banana");
        ArrayList result = removeDuplicate(al1);

        System.out.println(result);
    }

    static ArrayList removeDuplicate(ArrayList al) {

        ArrayList result = new ArrayList<>();
        for (Object o : al) {
            if (Collections.frequency(result, o) < 1) {
                result.add(o);
            }
        }

        return result;
    }
}
