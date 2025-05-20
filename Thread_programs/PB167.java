package Thread_programs;

import java.nio.channels.Pipe.SourceChannel;

/*
 * Write a complete multi-threaded program to meet following
requirements:
o Two threads of same type are to be instantiated in the method main.
o Each thread acts as a producer as well as a consumer.
o A shared buffer can store only one integer information along with the
source &
destination of the information at a time.
o The information produced is to be consumed by appropriate consumer.
o Both producers produce information for both consumers.
o Each thread produces 5 information. 

 */

public class PB167 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        ProducerConsumer t1 = new ProducerConsumer(buffer, "Thread-A", "Thread-B");
        ProducerConsumer t2 = new ProducerConsumer(buffer, "Thread-B", "Thread-A");

        t1.start();
        t2.start();
    }
}

class Buffer{
    int data;
    String source;
    String destination;
    boolean isEmpty = true;

    public synchronized void put(int data, String source,  String destination){
        try{
            while (!isEmpty) {
                wait();
            }
            this.data = data;
            this.source = source;
            this.destination = destination;

            isEmpty = false;
            System.out.println("Produced: " + data + " from " + source + " to " + destination);
            notifyAll();
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

    public synchronized int get(String consumerName){
        try{
            while (isEmpty || !consumerName.equals(destination)) {
                wait();
            }

            System.out.println("Consumed: " + data + " by " + consumerName + " (from " + source + ")");
            isEmpty = true;
            notifyAll();
            return data;
        }catch(InterruptedException ie){
            System.out.println(ie);
            return -1;
        }
    }
}

class ProducerConsumer extends Thread{
    Buffer buffer;
    String otherThreadName;

    public ProducerConsumer(Buffer buffer, String name, String otherThreadName){
        super(name);
        this.buffer = buffer;
        this.otherThreadName = otherThreadName;

    }

    public void run(){
        for (int i = 1; i <= 5; i++) {
            String dest = (Math.random() < 0.5) ? getName(): otherThreadName;
            buffer.put(i, getName(), dest);
            buffer.get(getName());
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
