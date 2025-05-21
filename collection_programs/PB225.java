package collection_programs;

import java.util.ArrayList;
import java.util.Comparator;

/* 
 * Write a program in which create two ArrayList. Add odd numbers
between 1 to 10 in one arraylist and even numbers between 1 to 10 in
another arraylist. Now merge these two ArrayList and sort them in
descending order. At last print this sorted ArrayList.
 */

public class PB225 {
    public static void main(String[] args) {
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();

        for(int i = 1; i <= 10; i++){
            if(i % 2 == 0){
                al2.add(i);
            }else{
                al1.add(i);
            }
        }

        al1.sort(Comparator.reverseOrder());
        al2.sort(Comparator.reverseOrder());

        System.out.println("odd List " + al1);
        System.out.println("even list " + al2);
    }
}
