package Thread_programs;

/*
 * Write an application that executes two threads. One thread displays
"Good Morning" every
1000 milliseconds & another thread displays "Good Afternoon" every
3000 milliseconds for 10 times..
Create the threads by implementing the Runnable interface.

 */

public class PB165 {
    public static void main(String[] args) {
        MT3 t1 = new MT3();
        MT4 t2 = new MT4();
        Thread mt = new Thread(t1);
        Thread mt2 = new Thread(t2);
        mt.start();
        mt2.start();
    }
}


class MT3 implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Good morning");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
}

class MT4 implements Runnable{
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Good Afternoon");
            try{
                Thread.sleep(3000);

            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }
}