package collection_programs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Write a Java program to append the specified element to the end of a
linked list & Write a Java program to iterate through all elements in a
linked list.
 */

public class PB238 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1, 2, 3, 5, 6));

        System.out.print("Enter element you want to append");
        int n = sc.nextInt();

        ll.add(n);

        Iterator<Integer> it = ll.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }
}
