package Thread_programs;

import java.util.Scanner;
/*
 * Write a program to create two threads, one thread will check whether
given number is prime or not and second thread will print prime numbers
between 0 to 100

 */

public class PB163 {
    public static void main(String[] args) {
        MT1 t1 = new MT1();
        MT2 t2 = new MT2();
        t1.start();
        t2.start();
    }
}

class MT1 extends Thread{

    boolean primeCheck(int a){
        for (int i = 2; i < a; i++) {
            if(a % i == 0)
                return false;
        }
        return true;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number you want to check: ");
        int n = sc.nextInt();
        if(primeCheck(n)){
            System.out.println(n + " is prime number ");
        }else{
            System.out.println(n + " is not prime number");
        }
    }
}

class MT2 extends Thread{
    public void run() {
    for (int i = 2; i <= 100; i++) {
        boolean isPrime = true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            System.out.println(i);
        }
    }
}