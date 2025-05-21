package collection_programs;

import java.util.Scanner;
import java.util.Stack;

/*
 * Problem Statement: Balanced Parentheses
Given a string containing only parentheses, determine if it is balanced. A
string is considered balanced if every opening parenthesis has a
corresponding closing parenthesis, and they are properly nested.
You need to implement a function that takes a string as input and returns
true if the string is balanced and false otherwise.
HINT: To solve this problem, you can use a stack to keep track of the
opening parentheses and pop them off the stack when a closing
parenthesis is encountered. If at any point the stack is empty when a
closing parenthesis is encountered or if the top of the stack doesn't match
the current closing parenthesis, then the string is not balanced.

 */

public class PB242 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter parentheses string: ");
        String input = sc.nextLine();

        boolean result = isBalanced(input);
        System.out.println("Is balanced? " + result);
    }

    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();

            }
        }

        return stack.isEmpty();
    }
}
