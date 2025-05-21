package Thread_programs;

/* write a program that demonstrates the prodecer consumer concept in
detail.
 */

public class PB172 {
    public static void main(String[] args) {
        ProCon pc = new ProCon();
        Produce p = new Produce(pc);
        Consumer c = new Consumer(pc);


        p.start();
        c.start();
    }
}

class Produce extends Thread {
    ProCon pc;

    Produce(ProCon pc) {
        this.pc = pc;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            pc.produce(i);
        }
    }
}

class Consumer extends Thread {
    ProCon pc;

    Consumer(ProCon pc) {
        this.pc = pc;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            pc.consume();
        }
    }
}

class ProCon {
    boolean isReady = false;
    int data;

    synchronized void consume() {
        if(!isReady){
            try{
                System.out.println("Consumer wait ");
                wait();
            }catch(Exception e){

            }
        }

        System.out.println("consume " + data);
        isReady = false;
        notify();
    }

    synchronized void produce(int n){
        if(isReady){
            try{
                System.out.println("Producer wait ");
                wait();
            }catch(Exception e){

            }
        }

            data = n;
            System.out.println("Produce = " + data);
            isReady = true;
            notify();
        
    }
}