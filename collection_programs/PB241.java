package collection_programs;

import java.util.Stack;

/*
 * Write a program that contains Stack of 3 items. First insert 3 items in
stack. Then do pop operation 2 times. and print the stack.

 */

public class PB241 {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.pop();
        System.out.println(s);
    }
}
