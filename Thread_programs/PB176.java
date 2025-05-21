package Thread_programs;

/*
 * Make caller thread by extending thread class which calls synchronized
receiver method available in receiver class. Make two threads of Caller
and display message "Ringing" and thread name according to thread.
Thread name must be Caller1 and Caller2. 

 */

public class PB176 {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();

        Caller t1 = new Caller(receiver, "Caller 1");
        Caller t2 = new Caller(receiver, "Caller 2");

        t1.start();
        t2.start();
    }
}

class Caller extends Thread{

    Receiver receiver;

    Caller(Receiver receiver, String name){
        super(name);
        this.receiver = receiver;
    }

    public void run(){ 
        receiver.receiver();
    }
}

class Receiver{
    synchronized void receiver(){
        System.out.println("Ringing by "+ Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}