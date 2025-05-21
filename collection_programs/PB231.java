package collection_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Write a Java program to copy one array list into another. & sort the
second arraylist & search an element in a array list

 */

public class PB231 {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(1, 2, 3, 9, 8));

        ArrayList<Integer> al2 = new ArrayList<>();
        al2.addAll(al1);

        al2.sort(Comparator.naturalOrder());

        System.out.println("Original ArrayList: " + al1);
        System.out.println("Copied and Sorted ArrayList: " + al2);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element to search in al2: ");
        int key = sc.nextInt();

        if (al2.contains(key)) {
            System.out.println("Element found at index: " + al2.indexOf(key));
        } else {
            System.out.println("Element not found.");
        }

        sc.close();

    }
}
