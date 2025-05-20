package Thread_programs;
// Write a program to create a child thread to print integer numbers 1 to 10

public class PB162 {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.start();
    }
}

class MyThread1 extends Thread{
    public void run(){
        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }
    }
}