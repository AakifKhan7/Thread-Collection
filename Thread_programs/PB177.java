package Thread_programs;
/*
 * Implement a Prime Number Finder
Write a Java program to implement a prime number finder that checks if
a given number is prime or not in a separate thread. The program should
use the join() method to wait for all the threads to finish, and the isAlive()
method to check if a thread is still running.
To solve this problem, you can create a prime number finder thread that
implements the Runnable interface and checks if a given number is prime
or not. You can then create multiple instances of the prime number finder
thread and start them using separate threads. The main thread can use
the join() method to wait for all the threads to finish, and the isAlive()
method to check if a thread is still running.
 */

public class PB177 {
    public static void main(String[] args) {
        int[] numbers = {29, 15, 97, 44, 73};

        Thread[] threads = new Thread[numbers.length];

        for(int i = 0; i< numbers.length; i++){
            Runnable task = new PrimeNumberFinder(numbers[i]);
            threads[i] = new Thread(task, "Checker-" + numbers[i]);
            threads[i].start();
        }
        
        for (Thread t : threads) {
            System.out.println(t.getName() + " isAlive: " + t.isAlive());
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted: " + e);
            }
            System.out.println(t.getName() + " finished.");
        }

        System.out.println("All threads have finished.");
    }
}

class PrimeNumberFinder implements Runnable{
    int n;

    PrimeNumberFinder(int n){
        this.n = n;
    }
    public void run(){
        if (isPrime(n)) {
            System.out.println("Number " + n + " is PRIME (Thread: " + Thread.currentThread().getName() + ")");
        } else {
            System.out.println("Number " + n + " is NOT PRIME (Thread: " + Thread.currentThread().getName() + ")");
        }
    }

    boolean isPrime(int n){
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}