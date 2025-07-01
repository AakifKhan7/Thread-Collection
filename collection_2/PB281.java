package collection_2;

import java.util.ArrayDeque;
import java.util.Scanner;

// Write a program that simulates a queue of customers at a coffee shop
// using an ArrayDeque. The program should allow the user to perform the
// following actions:
// Add a new customer to the back of the queue
// Serve the next customer in the queue (i.e. remove the customer from the
// front of the queue)
// View the current queue of customers
// The program should continue to prompt the user for actions until they
// choose to quit.

public class PB281 {
    public static void main(String[] args) {
        ArrayDeque<String> ad = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("\nMenu:");
            System.out.println("1. Add new customer to the back of the queue");
            System.out.println("2. Serve the next customer");
            System.out.println("3. View the current queue");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customer = sc.nextLine();
                    ad.addLast(customer);
                    System.out.println(customer + " has been added to the queue.");
                    break;
                case 2:
                    if (!ad.isEmpty()) {
                        String servedCustomer = ad.pollFirst();
                        System.out.println("Serving " + servedCustomer + ".");
                    } else {
                        System.out.println("Queue is empty. No customers to serve.");
                    }
                    break;
                case 3:
                    if(!ad.isEmpty()){
                        System.out.println("current customers of queue ");
                        for(String name: ad){
                            System.out.println(" - " + name);
                        }
                    }else {
                        System.out.println("Queue is empty. No customers in the queue.");
                    }
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

        }while (ch!=4);

    }
}
