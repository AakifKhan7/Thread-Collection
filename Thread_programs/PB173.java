package Thread_programs;

/*Explain the concept of Syncronization by taking suitable example. */

public class PB173 {
    public static void main(String[] args) {
        PVR pvr = new PVR(5);
        BookingThread thread1 = new BookingThread(pvr, 3, "1");
        BookingThread thread2 = new BookingThread(pvr, 5, "1");

        thread1.start();
        thread2.start();
    }

}

class PVR {
    int total_seats;

    PVR(int total_seats) {
        this.total_seats = total_seats;
    }

    public synchronized void bookSeat(int seatsBook, String screen) {
        if (seatsBook <= total_seats) {
            System.out.println(
                    Thread.currentThread().getName() + " booking " + seatsBook + " seats for Screen " + screen);
            total_seats -= seatsBook;
            System.out.println("Seats booked successfully. Remaining seats for Screen " + screen + ": " + total_seats);
        } else {
            System.out.println("Sorry, " + Thread.currentThread().getName() + " cannot book " + seatsBook
                    + " seats for Screen " + screen + ". Not enough seats available.");
        }
    }
}

class BookingThread extends Thread{
    PVR pvr;
    int seatsToBook;
    String screen;

    
    public BookingThread(PVR pvr, int seatsToBook, String screen) {
        this.pvr = pvr;
        this.seatsToBook = seatsToBook;
        this.screen = screen;
    }

    public void run(){
        pvr.bookSeat(seatsToBook, screen);
    }
}