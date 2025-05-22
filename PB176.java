public class PB176 {
    public static void main(String[] args) {
        Receiver r = new Receiver();
        Caller caller1 = new Caller(r);
        Caller caller2 = new Caller(r);

        caller1.start();
        caller2.start();
    }
}

class Receiver{
    synchronized void Receiver(){
        System.out.println("Ringing By " + Thread.currentThread().getName());
    }
}

class Caller extends Thread{

    Receiver receiver;

    Caller(Receiver receiver){
        this.receiver = receiver;
    }

    public void run(){
        receiver.Receiver();
    }
}
