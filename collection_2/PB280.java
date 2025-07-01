package collection_2;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// Sports tournament organizer:
// Write a program that simulates a sports tournament using a
// PriorityQueue. The program should allow the user to input team names
// and their win-loss records. The program should then prioritize teams
// based on their win-loss records and add them to the PriorityQueue. When
// it's time for the next match, the program should remove the two highest
// priority teams from the PriorityQueue and display their names.

public class PB280 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Team> pq = new PriorityQueue<>(Comparator.comparing(Team::getWinLossRatio).reversed()); 
        
        System.out.print("Enter the number of teams: ");
        int numTeams = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numTeams; i++) {
            System.out.print("Enter team name: ");
            String name = sc.nextLine();
            System.out.print("Enter number of wins: ");
            int wins = sc.nextInt();
            System.out.print("Enter number of losses: ");
            int losses = sc.nextInt();
            sc.nextLine();

            pq.add(new Team(name, wins, losses));
        }

        System.out.println("Next match:");
        if (!pq.isEmpty()) {
            Team team1 = pq.poll();
            Team team2 = pq.poll();
            System.out.println(team1 + " vs. " + team2);
        } else {
            System.out.println("Not enough teams to start the match.");
        }
    }
    
}

class Team{
    String name;
    int wins;
    int losses;

    Team(String name, int wins, int losses){
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    int getWinLossRatio(){
        return wins - losses;
    }

    @Override
    public String toString(){
        return name;
    }
}