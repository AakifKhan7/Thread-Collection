package collection_programs;
/*
 * I have an Induction machine manufacturing company. My Manager wants
to analyze some data of the induction machines of our manufacturing
unit.
What I have: List of machine's price. Note: each price is in Double.
Write a java program that contains list of various machine's price. & do
the following tasks.
Task 1 - Create a list of 5 machine's price.
[10000.0,55000.0,80000.0,25000.0,55000.0]
Task 2 - Find the maximum price from the list.
Task 3 - sort the list.
 */

import java.util.Collections;
import java.util.LinkedList;

public class PB240 {
    public static void main(String[] args) {
        LinkedList<Double> prices = new LinkedList<>();
        prices.add(10000.0);
        prices.add(55000.0);
        prices.add(80000.0);
        prices.add(25000.0);
        prices.add(55000.0);

        System.out.println("Original machine prices: " + prices);

        double maxPrice = Collections.max(prices);
        System.out.println("Maximum machine price: " + maxPrice);

        Collections.sort(prices);
        System.out.println("Sorted machine prices: " + prices);
    }
}
