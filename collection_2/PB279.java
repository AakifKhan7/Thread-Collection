package collection_2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

// Write a Java program that takes a list of integers as input from the user
// and stores them in a PriorityQueue. The program should then remove and
// display the top three highest integers from the PriorityQueue.


public class PB279 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many number you want to enter: ");
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            pq.add(num);
        }

        if (n < 3) {
            System.out.println("Please enter at least 3 numbers.");
            return;
        }

        System.out.println("Top 3 highest numbers:");
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.poll());
        }
    }
}
