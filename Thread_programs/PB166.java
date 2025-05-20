package Thread_programs;

/* 
 * Write a program to create two threads, one thread will print odd
numbers and second thread will print even numbers between 1 to 100
numbers

 */
public class PB166 {
    public static void main(String[] args) {
        Odd o = new Odd();
        Even e = new Even();
        o.start();
        e.start();
    }
}

class Odd extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                System.out.println(i + " Odd");
            }
        }
    }
}

class Even extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " Even");
            }
        }
    }
}