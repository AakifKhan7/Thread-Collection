package collection_2;

import java.time.chrono.HijrahChronology;
import java.util.ArrayDeque;
import java.util.Scanner;

// Make the system as User interactive and give choices to user.
// Web browser history: Write a program that simulates a web browser
// history using an ArrayDeque. The program should allow the user to
// navigate back and forward through their history of visited web pages,
// similar to how a web browser works. The program should keep track of
// the URLs of visited web pages using an ArrayDeque, where each element
// in the deque represents a visited web page. When the user navigates to a
// new web page, you can push the URL onto the deque. When the user
// navigates back or forward, you can pop URLs off the front or back of the
// deque, respectively.

public class PB283 {
    public static void main(String[] args) {
        ArrayDeque<String> history = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. Visit a new web page");
            System.out.println("2. Navigate back");
            System.out.println("3. Navigate forward");
            System.out.println("4. Show history");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the URL to visit: ");
                    String url = sc.nextLine();
                    history.addLast(url);
                    System.out.println("Navigated to: " + url);
                    break;
                case 2:
                    if (history.isEmpty()) {
                        System.out.println("No history to navigate Back.");
                    } else {
                        String urlBack = history.pollLast();
                        System.out.println("Navigated Back to: " + urlBack);
                    }
                    break;
                case 3:
                    if (history.isEmpty()) {
                        System.out.println("No history to navigate forward.");
                    } else {
                        String urlForward = history.pollFirst();
                        System.out.println("Navigated forward to: " + urlForward);
                    }
                    break;
                case 4:
                    if(!history.isEmpty()){
                        int i = 0;
                        for(String s: history){
                            System.out.println(i++ + ". " + s);
                        }
                    }else{
                        System.out.println("No available history: ");
                    }
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
                    break;
            }
        }
    }
}
