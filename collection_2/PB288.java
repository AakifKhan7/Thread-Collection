package collection_2;

import java.util.HashMap;
import java.util.Scanner;

// Write a program that reads in a list of stock prices for a company and
// stores them in a HashMap, where the key is the date and the value is the
// price. The program should then compute the average price for the entire
// period and output it to the user.

public class PB288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, Double> stockPrice = new HashMap<>();

        System.out.println("Enter stock prices and dates");
        while (true) {
            System.out.print("Date (format: YYYY-MM-DD): ");
            String date = sc.nextLine();
            System.out.print("Price: ");

            double price = sc.nextDouble();
            sc.nextLine();

            stockPrice.put(date, price);

            System.out.println("DO YOU WANT TO CONTINUE ? YES OR NO");

            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }

        }

        double total = 0;
        for(Double d: stockPrice.values()){
            total += d;
        }
        double average = total / stockPrice.size();
        sc.close();
        System.out.println("Average stock price for the entire period: " + average);
    }
}
