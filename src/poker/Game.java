package poker;

import java.util.Scanner;

public class Game {
	private final int MAX_PLAYERS = 4;
	private int activePlayers;
	
	public Player[] players = new Player[MAX_PLAYERS];
	public static Deck deck = new Deck();
	
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
	
	public void compareHands() {
		for(int i=0;i < 4;i++){
			for(int j=i+1;j < 4;j++){
				if(players[i].getHandValue() > players[j].getHandValue()){
					players[i].addRank(); players[i].addRank();
				}
				else if(players[i].getHandValue() < players[j].getHandValue()){
					players[j].addRank(); players[j].addRank();
				}
				else if(players[i].getCardsValue() > players[j].getCardsValue()){
					players[i].addRank(); players[i].addRank();
				}
				else if(players[i].getCardsValue() < players[j].getCardsValue()){
					players[j].addRank(); players[j].addRank();
				}
				else{
					players[i].addRank(); players[j].addRank();
				}
			}
		}		
	}

	public void sortPlayers() {
		Player temp;
		for(int i=0;i<activePlayers;i++){
			for(int j=i+1;j<activePlayers;j++){
				if(players[i].getRank() < players[j].getRank()){
					temp = null;    
					temp = players[j];
					players[j] = players[i];
					players[i] = temp;
				}      
			}   
		}
	}

	public void printPlayers() {
		for(int i =0; i < activePlayers;i++){
			System.out.println(players[i].printHand() + "----" + players[i].printHandType());
		}
		
	}
	
	public static boolean keepPlaying(){
		Scanner in = new Scanner(System.in);
		System.out.println("Do you want to play another round(0=No, 1=Yes)?");
		int b  = in.nextInt();
		while(b < 0 && b > 1){
			System.out.println("Input must be 0 or 1");
			b  = in.nextInt();
		}
		if(b == 0)
			return false;
		else
			return true;
	}
	
	public static void main(String args[]){
		System.out.println("Welcome to Simple Poker");
		Game game = new Game();
		boolean play = true;
		while(play){
			game.playersForRound();
			deck.shuffle();
			for(int i=0; i< game.activePlayers;i++){
				game.players[i].setHand(deck.deal());
				game.players[i].sort();
			}
			//game.printPlayers();
			game.compareHands();
			game.sortPlayers();
			game.printPlayers();
			play = keepPlaying();
		}
	}
}
