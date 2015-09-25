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
		in.close();
	}	
	
	public static void main(String args[]){
		System.out.println("Welcome to Simple Poker");
	}
	
	public void compareHands() {
		for(int i=0;i<=4-1;i++){
			for(int j=0;j<=4-2;j++){
				if(players[j].getHandValue() > players[j+1].getHandValue()){
					players[j].addRank(); players[j].addRank();
				}
				else if(players[j].getHandValue() < players[j+1].getHandValue()){
					players[j+1].addRank(); players[j+1].addRank();
				}
				else if(players[j].getCardsValue() > players[j+1].getCardsValue()){
					players[j].addRank(); players[j].addRank();
				}
				else if(players[j].getCardsValue() < players[j+1].getCardsValue()){
					players[j+1].addRank(); players[j+1].addRank();
				}
				else{
					players[j+1].addRank(); players[j+1].addRank();
				}
			}
		}		
	}

	public void sortPlayers() {
		Player temp;
		for(int i=0;i<=activePlayers-1;i++){
			for(int j=0;j<=activePlayers-2;j++){
				if(players[j].getRank() < players[j+1].getRank()){
					temp = null;    
					temp = players[j];
					players[j] = players[j+1];
					players[j+1] = temp;
				}      
			}   
		}
	}

	public void printPlayers() {
		for(int i =0; i < activePlayers;i++){
			System.out.println(players[i].printHand() + "----" + players[i].printHandType());
		}
		
	}
}
