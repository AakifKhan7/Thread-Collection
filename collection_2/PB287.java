package collection_2;

import java.util.HashMap;
import java.util.Scanner;

// Write a program that reads in a list of names and corresponding phone
// numbers from the user, and stores them in a HashMap. The program
// should then prompt the user for a name and output the corresponding
// phone number, or a message indicating that the name is not in the map

public class PB287 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, String> user = new HashMap<>();

        String name;
        String number;
        while (true) {
            System.out.println("Enter Name");
            name = sc.nextLine();

            System.out.println("Enter Number");
            number = sc.nextLine();
            user.put(name, number);
            System.out.println("Do you want to add Data ? Enter Yes or No");
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("NO")) {
                break;
            }
        }

        System.out.println("Enter the name you want to search from phonebook ?");
        String searchName = sc.nextLine();
        String searchNumber = user.get(searchName);
        if (searchNumber != null) {
            System.out.println("Phone Number of " + searchName + " = " + searchNumber);
        } else {
            System.out.println("Name is not there in phonebook");
        }

        sc.close();
    }
}
