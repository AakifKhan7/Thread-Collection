package collection_programs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;

/*
 * Write a Java program to get the first and last occurrence of the specified
elements in a linked list. 

 */

public class PB236 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 3, 5, 1, 9));
        System.out.println(ll.indexOf(1));
        System.out.println(ll.lastIndexOf(1));
    }
}
