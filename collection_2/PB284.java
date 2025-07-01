package collection_2;

import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

// In my restaurant I used to manage it well as per the order. I never want to
// skip any order from the customer. So I prepare a rule: When I get the
// order I add it in the last of my cook queue. And when the order is ready I
// used to pick it up from the first of the cook queue.
// So, write a java program with class Restaurant. Create a queue cook
// which contains item names. Ask user weather he wants to Order or take
// food. If user press 1 then ask for the name of the item and it should be
// added in the cook queue.
// If user press 2 then The first item from the queue should be removed
// from the queue.
// If user press 3 then he can see the items of the queue. If user press 4 then
// he should move out from the Restaurant.

public class PB284 {
    public static void main(String[] args) {
        ArrayDeque<String> cook = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        int ch;
        do {
            System.out.println(
                    "Enter Your Choice 1 To What to Order? \n 2 for Serve the order \n 3. view Order  \n 4. Move out from restaurant");
            ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter Item to order: ");
                    String item = sc.nextLine();
                    cook.addLast(item);
                    System.out.println("Your order for item " + item + " has been placed...");
                    break;
                case 2:
                    if (!cook.isEmpty()) {
                        String servingItem = cook.pollFirst();
                        System.out.println("Serving item " + servingItem + " to customer....");
                    } else {
                        System.out.println("NO ORDER TO SERVE");
                    }
                    break;
                case 3:
                    if (!cook.isEmpty()) {
                        System.out.println("----- LIST OF ITEMS IN QUEUE TO BE COOKED ------");
                        int i = 1;
                        for (String s : cook) {
                            System.out.println("Item " + i + " = " + s);
                            i++;
                        }
                    } else {
                        System.out.println("NO ORDER TO VIEW IN QUEUE");
                    }
                    break;
                case 4:
                    System.out.println("THANK YOU... VISIT AGAIN");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (ch != 4);
    }
}
