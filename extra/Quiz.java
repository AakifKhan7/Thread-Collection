package extra;

import java.util.*;

public class Quiz {

    public static void main(String[] args) {
        ArrayList<Participant> participants = new ArrayList<>();
        Stack<Character> correctAnswers = new Stack<>();

        Scanner sc = new Scanner(System.in);
        correctAnswers.push('A');
        correctAnswers.push('B');
        correctAnswers.push('A');
        correctAnswers.push('D');
        correctAnswers.push('C');

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter participant name: ");
            String name = sc.nextLine();

            System.out.print("Enter participant age: ");
            int age = sc.nextInt();
            sc.nextLine();

            String contactNumber;
            do{
                System.out.println("Contact number must be 10 digit and starts with 9 ");
                System.out.print("Enter contact number: ");
                contactNumber = sc.nextLine();
            }while(contactNumber.length() != 10 && contactNumber.startsWith("9"));
            
            participants.add(new Participant(name, age, contactNumber));


        }

        Collections.sort(participants, Comparator.comparing(Participant::getAge));

        ArrayList<Thread> threads = new ArrayList<>();

        for (Participant participant : participants) 
        {
            Thread thread = new Thread(participant);
            threads.add(thread);
            thread.start();
            try{
                thread.join();
            }catch(Exception e){

            }
        }

        for (Thread thread : threads) {
            try{thread.join();}catch(Exception e){}
        }

        int highScore = 0;
        String winner = "";

        System.out.println("Results ");

        for(Participant p: participants){
            int score = calculateScore(p.getAnswers(), correctAnswers);
            
            System.out.println("Participant: " + p.getName() + ", Age: " + p.getAge() + ", Contact Number: " + p.getContactNumber() + ", Score: " + score);
            if(score > highScore){
                highScore = score;
                winner = p.getName();
            }

            System.out.println("Winner: " + winner);
        }



    }

    static int calculateScore(ArrayList<Character> pAnswers, Stack<Character> correctAnswers){
        int score = 0;
        for (int i = 0; i < pAnswers.size(); i++) {
            if(pAnswers.get(i) == correctAnswers.get(i)){
                score++;
            }
        }
        return score;
    }
}

class Participant implements Runnable {
    String name;
    int age;
    String contactNumber;
    ArrayList<Character> answers;

    Participant(String name, int age, String contactNumber) {
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.answers = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getContactNumber() {
        return contactNumber;
    }

    ArrayList<Character> getAnswers() {
        return answers;
    }

    public void run() {
        System.out.println("Participant: " + name + ", Age: " + age + ", Contact Number: " + contactNumber);
        Scanner sc = new Scanner(System.in);

        synchronized (this) {
            System.out.println();
            System.out.println();
            System.out.println("Hello " + name + " Here are questions for Quiz");
            System.out.println("Q.1. National bird of INDIA..(A) Peacock (B) Sparrow (C) Duck (D) Owl ");
            System.out.println("Q.2  Independence year of INDIA..(A) 1955 (B) 1947 (C) 1999 (D) 1929 ");
            System.out.println("Q.3  Gandhi Jayanti is on......(A) 2nd Oct (B) 5th Oct (C) 9th Oct (D) 7th Oct ");
            System.out.println("Q.4  Count of states in INDIA..(A) 17 (B) 21 (C) 25 (D) 28 ");
            System.out.println("Q.5  how many continents are there in the world..(A) 5 (B) 6 (C) 7 (D) 8 ");

            for (int i = 0; i < 5; i++) {
                System.out.print("Enter your answer for Question " + i + ": ");
                char answer = sc.nextLine().charAt(0);
                answers.add(answer);
            }
        }
    }
}
