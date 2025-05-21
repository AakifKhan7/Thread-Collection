package collection_programs;

import java.util.LinkedList;

/*
 *  Write a Java program to clone an linked list to another linked list.
 */

public class PB237 {
    public static void main(String[] args) {
        LinkedList<Integer> ll1 = new LinkedList<>();
        ll1.add(10);
        ll1.add(20);
        ll1.add(30);
        LinkedList<Integer> ll2 = (LinkedList<Integer>) ll1.clone();

        System.out.println("Original LinkedList (ll1): " + ll1);
        System.out.println("Cloned LinkedList (ll2): " + ll2);
    }
}
