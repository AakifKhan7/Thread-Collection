package Thread_programs;

import java.nio.channels.Pipe.SourceChannel;
import java.util.Scanner;

/*
 * Problem Statement: Implement a Bank Account
Write a Java program to implement a bank account that allows multiple
threads to deposit and withdraw money from the same account. The
problem requires synchronization between the threads to prevent race
conditions and ensure that the balance is accurate.
To solve this problem, you can create a BankAccount class that has a
balance variable and synchronized methods for depositing and
withdrawing money. You can then create multiple threads that use the
deposit and withdraw methods to modify the account balance.

 */

public class PB178 {

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();

        WithDraw w1 = new WithDraw(acc, 10000);
        WithDraw w2 = new WithDraw(acc, 10000);
        Deposite d = new Deposite(acc, 5000);

        w1.start();
        w2.start();
        d.start();

    }

}

class BankAccount
{
    int total_balance=100000;
    synchronized void withdraw(int amount)
    {
        Thread t=Thread.currentThread();
       if(total_balance>=amount)
       {
            System.out.println();
            System.out.println(t.getName()+":: your Transiction is successful");
            total_balance=total_balance-amount;
            System.out.println("Available Balance="+total_balance);
            System.out.println();
       }
       else
       {    
            System.out.println();
            System.out.println("Sorrry "+t.getName()+":: your Transiction is Failed");
            System.out.println("Available Balance="+total_balance);
            System.out.println();

       }
    }
    synchronized void deposite(int amount)
    {
        System.out.println();
        Thread t=Thread.currentThread();
        System.out.println("Hey "+t.getName()+" total Amount of "+amount+" deposited in your Account" );
        total_balance=total_balance+amount;
        System.out.println("Available balance is="+total_balance);
        System.out.println();

    }

}
class WithDraw extends Thread
{
    BankAccount acc;
    int amount;
    public WithDraw(BankAccount acc, int amount) 
    {
        this.acc = acc;
        this.amount = amount;
    }
    public void run()
    {
        acc.withdraw(amount);
    }
}
class Deposite extends Thread
{
    BankAccount acc;
    int amount;
    public Deposite(BankAccount acc, int amount) 
    {
        this.acc = acc;
        this.amount = amount;
    }
    public void run()
    {
        acc.deposite(amount);
    }
}