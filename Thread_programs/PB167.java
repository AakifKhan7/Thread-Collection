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

        ProducerConsumer t1 = new ProducerConsumer(buffer, 1, 1);
        ProducerConsumer t2 = new ProducerConsumer(buffer, 2, 2);

        t1.start();
        t2.start();
    }
}

class Buffer{
    int data;
    boolean isEmpty = true;

    Buffer(){
        isEmpty = true;
    }

    public synchronized void put(int data){
            while (!isEmpty) {
                try{
                    wait();
                }catch(Exception e){}
            }
            this.data = data;
            isEmpty = false;
            System.out.println("Produced: " + data);
            notifyAll();
    }

    public synchronized int get(){
        try{
            while (isEmpty) {
                wait();
            }

            System.out.println("Consumed: " + data );
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
    int producerId, consumerId;

    public ProducerConsumer(Buffer buffer, int producerId, int consumerId){
        this.buffer = buffer;
        this.producerId = producerId;
        this.consumerId = consumerId;
    }

    public void run(){
        for (int i = 1; i <= 5; i++) {
            buffer.put(i * 100 + producerId * 10 + consumerId);
            System.out.println("Producer " + producerId + " produced: " + (i * 100 + producerId * 10 + consumerId));

            int consumedData = buffer.get();
            System.out.println("Consumer " + consumerId + " consumed: " + consumedData);

        }
    }
}
