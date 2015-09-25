package poker;

import java.util.Scanner;

public class Game {
	private final int MAX_PLAYERS = 4;
	private int activePlayers;
	
	public Player[] players = new Player[MAX_PLAYERS];
	
	public int getPlayersNum(){ return activePlayers; };
	
	public void playersForRound() {
		activePlayers = 0;
		Scanner in = new Scanner(System.in);
		
		System.out.println("How many players for the round?(2-4)   ");
		activePlayers = in.nextInt();
		while(!(activePlayers > 1 && activePlayers < 5)){
			System.out.println("Must be 2-4 players.");
			System.out.println("How many players for the round?(2-4)   ");
			activePlayers = in.nextInt();
		}
		
		for(int x = 0; x< activePlayers;x++){
			String n = "Dumby";
			System.out.println("Please enter name of Player " + (x + 1) + ": ");
			n = in.next();
			players[x] = new Player(n);
		}
	}	
}
