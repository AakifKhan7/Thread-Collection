package Thread_programs;

/*
 * Write a multithreaded program to print all odd positive numbers in ascending order up to n, 
where n is a positive integer number given as a command line argument. 
Instantiate requited number of threads, where each thread except the last, 
examines next 50 numbers and the last thread examines remaining numbers up to n.
 */


public class PB169 {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage: java Main <number>");
            return;
        }

        int n = Integer.parseInt(args[0]);

        int numThreads = (n + 49) / 50;

        int start = 1;
        for (int i = 0; i < numThreads - 1; i++) {
            int end = start + 49; // Each thread examines next 50 numbers
            OddNumberPrinter thread = new OddNumberPrinter(start, end);
            thread.start();
            start = end + 1;
        }

        int end = n;
        OddNumberPrinter lastThread = new OddNumberPrinter(start, end);
        lastThread.start();
    }
}

class OddNumberPrinter extends Thread{
    int start;
    int end;

    OddNumberPrinter(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run(){
        for(int i = start; i <= end; i+=2){
            System.out.println(i);
        }
    }
}
