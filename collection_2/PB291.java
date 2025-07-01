package collection_2;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/* 
 * 
 * Write a Java program that implements a HashTable to store a dictionary
of words and their definitions. The program should prompt the user for a
word and output its definition. If the word is not found in the HashTable,
the program should ask the user if they would like to add the word and its
definition to the HashTable.
The program should use the following methods of the HashTable class:
put(K key, V value): Adds a key-value pair to the HashTable. In this
program, it should be used to add new words and their definitions.
get(Object key): Retrieves the value associated with the given key from
the HashTable. In this program, it should be used to retrieve the
definition of a word.
containsKey(Object key): Returns true if the HashTable contains a
mapping for the specified key. In this program, it should be used to check
if a word is already in the HashTable.
keySet(): Returns a Set of all keys in the HashTable. In this program, it
should be used to print out a list of all words in the dictionary.

*/

public class PB291 {
    public static void main(String[] args) {
        Hashtable<String, String> dictionary = new Hashtable<>();
        Scanner scanner = new Scanner(System.in);

        dictionary.put("apple", "A fruit that is typically red or green.");
        dictionary.put("banana", "A long, curved fruit with a yellow skin.");
        dictionary.put("cat", "A small domesticated carnivorous mammal.");

        while (true) {
            System.out.print("Enter a word to get its definition (or type 'exit' to quit): ");
            String inputWord = scanner.nextLine();

            if (inputWord.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
            if (dictionary.containsKey(inputWord)) {
                String definition = dictionary.get(inputWord);
                System.out.println("Definition: " + definition);
            }else {
                System.out.println("Word not found in the dictionary.");

                System.out.print("Would you like to add it? (yes/no): ");
                String addWord = scanner.nextLine();
                if (addWord.equalsIgnoreCase("yes")) {
                    System.out.print("Enter the definition of the word: ");
                    String definition = scanner.nextLine();
                    dictionary.put(inputWord, definition);
                    System.out.println("Word added to the dictionary.");
                } else {
                    System.out.println("Word was not added to the dictionary.");
                }
            }
        }

        Set<String> words = dictionary.keySet();
        System.out.println("Words in the dictionary:");
        for (String word : words) {
            System.out.println(word);
        }

        scanner.close();
    }
}
