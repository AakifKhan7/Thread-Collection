package collection_programs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * Write a Java program to insert the specified element at the specified
position in the linked list.
 */

public class PB235 {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>(Arrays.asList(1,2, 4, 5));
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter index ");
        int i = sc.nextInt();

        System.out.print("Enter number you want to insert ");
        int num = sc.nextInt();

        ll.add(i, num);

        System.out.println(ll);
    }
}
