package Thread_programs;
/*
 * Write an application that creates and starts three threads. Each thread is
 *  instantiated from the
same class. It executes a loop with 10 iterations. Each iteration displays
string "HELLO",
sleeps for 300 milliseconds. The application waits for all the threads to
complete & displays
the message "Good Bye..."
 */

class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(300);
            } catch (InterruptedException ie) {
                System.out.println(ie);
            }
        }
    }
}

class PB161 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("GOOD BY");
    }
}