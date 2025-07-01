package collection_2;

import java.util.HashSet;
import java.util.Scanner;

// Write a java program that reads in a list of integers from the user and
// stores them in a HashSet. The program should then compute the sum of
// all unique integers in the HashSet and output the result to the user. If the
// user enters the same integer multiple times, it should only be counted
// once in the sum.


public class PB285 {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("how many number you want to enter: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            hs.add(num);
        }

        int sum = 0;
        for(Integer i: hs){
            sum += i;
        }

        System.out.println("Sum is: " + sum);

        sc.close();
    }
}
