package Thread_programs;

/*Create PaymentThread class by extending Thread and Make a program to
count payments of 10 tickets each of 100 rs. Display total using main
thread.
 */

public class PB168{
    public static void main(String []args){
        PaymentThread pt = new PaymentThread();
        pt.start();
        try{
            pt.join();
        }catch(InterruptedException e){
            System.out.println(e);
        }

        System.out.println("Total Payment: ₹" + pt.getTotal());
    }

}

class PaymentThread extends Thread{
    int total = 0;

    public void run() {
        for (int i = 1; i <= 10; i++) {
            total += 100;
            System.out.println("Payment received for ticket " + i + ": ₹100");
        }
    }

    public int getTotal() {
        return total;
    }
}