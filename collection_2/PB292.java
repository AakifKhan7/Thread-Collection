package collection_2;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/*
 * Write a Java program that creates a HashTable to store information about
books in a library. The HashTable should use the book titles as keys and
store information about each book, such as the author, publisher, and
year of publication. The program should provide the following
functionality:
Add a book: The program should prompt the user for a book title, author,
publisher, and year of publication, and add the book to the HashTable.
Remove a book: The program should prompt the user for a book title and
remove the corresponding entry from the HashTable.
Search for a book: The program should prompt the user for a book title
and output the corresponding information stored in the HashTable, such
as the author, publisher, and year of publication. If the book title is not
found in the HashTable, the program should o
List all books: The program should list all books in the HashTable, along
with their corresponding information.To accomplish these tasks, you can
use the following HashTable methods: put(key, value): Inserts a key-value
pair into the HashTable.
remove(key): Removes a key-value pair from the HashTable.
get(key): Returns the value corresponding to a given key in the
HashTable.
containsKey(key): Returns true if the HashTable contains a given key.
keySet(): Returns a Set of all the keys in the HashTable.

 */

public class PB292 {
    static Hashtable<String, Book> library = new Hashtable<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. List all books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    list();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice,, please try again");
                    break;
            }
        }

    }

    static void addBook() {
        System.out.print("Enter book title: ");
        String title = sc.nextLine();
        System.out.print("Enter author: ");
        String author = sc.nextLine();
        System.out.print("Enter publisher: ");
        String publisher = sc.nextLine();
        System.out.print("Enter year of publication: ");
        int year = sc.nextInt();

        library.put(title, new Book(title, author, publisher, year));
    }

    static void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = sc.nextLine();

        if (library.containsKey(title)) {
            library.remove(title);
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    static void searchBook(){
        System.out.print("Enter book title to search: ");
        String title = sc.nextLine();

        if(library.containsKey(title)){
            Book book = library.get(title);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("Publisher: " + book.publisher);
            System.out.println("Year of Publication: " + book.year);
        }else{
            System.out.println("Book not found in the library.");
        }

    }

    static void list(){
        if(library.isEmpty()){
            System.out.println("The library is empty: ");
            return;
        }

        System.out.println("Listing all books");
        Set<String> titles = library.keySet();

        for(String s: titles){
            Book book = library.get(s);
            System.out.println("Title: " + book.title);
                System.out.println("Author: " + book.author);
                System.out.println("Publisher: " + book.publisher);
                System.out.println("Year of Publication: " + book.year);
                System.out.println("--------------------------");
        }
    }
}

class Book {
    String title;
    String author;
    String publisher;
    int year;

    public Book(String title, String author, String publisher, int year) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
    }

}