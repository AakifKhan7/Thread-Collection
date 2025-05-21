package collection_programs;

import java.util.ArrayList;

/*
 * Write a Java program to create a new array list, add some colors (string)
and print out the collection
 */

public class PB226 {
    public static void main(String[] args) {
        ArrayList<String> al1 = new ArrayList<>();
        al1.add("Red");
        al1.add("gree");
        al1.add("Orange");

        System.out.println(al1);
    }
}
