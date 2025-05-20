package Thread_programs;
/*
 * Write an application that read limit from user and executes two threads.
One thread displays total of first n even numbers & another thread
displays total of first n odd numbers. Create the threads by implementing
the Runnable interface
 */

import java.util.Scanner;

public class PB170 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        OddT o = new OddT(n);
        EvenT e = new EvenT(n);
        Thread ot = new Thread(o);
        Thread et = new Thread(e);
        ot.start();
        et.start();
    }
}

class OddT implements Runnable {
    int sum = 0, n;
    int count = 0;

    OddT(int n) {
        this.n = n;
    }

    public void run() {
        for (int i = 0; count < n; i++) {
            if (i % 2 != 0) {
                sum += i;
                count++;
            }
        }
        System.out.println(this.sum + " Odd");
    }
}

class EvenT implements Runnable{
    int sum = 0, n;
    int count = 0;

    EvenT(int n){
        this.n = n;
    }
    public void run(){
        for (int i = 0; count < n; i++) {
            if(i % 2 == 0){
                sum += i;
                count++;
            }
        }
        System.out.println(this.sum + " Even");
    }
}