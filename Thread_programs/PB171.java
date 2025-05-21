package Thread_programs;

/*
 * Write a program to create two thread one display alphabet from a to z
and other will display numbers from 1 to 100

 */

public class PB171 {
    public static void main(String[] args) {
        PrintAlphabet pt = new PrintAlphabet();
        DisplayNumber dn = new DisplayNumber();
        pt.start();
        dn.start();
    }
}

class PrintAlphabet extends Thread{
    public void run(){
        for (int i = 97; i < 123; i++) {
            System.out.println((char) i);
        }
    }
}

class DisplayNumber extends Thread{
    public void run(){
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}
