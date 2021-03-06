package poker;

import poker.Logic;

public class Player {
	private String name;
	private Card[] hand;
	private final int MAX_HAND = 5;
	private int rank;
	private int handValue;
	private int cardsValue;
	
	
	Player(String s){
		hand = null;
		name = s;
		rank = 0;
		handValue = -1;
		cardsValue = 0;
	}
	
	public String getName(){ return name; }
	public Card[] getHand() { return hand; }

	public int getHandValue() { return handValue; }
	public int getRank() { return rank; }
	public void addRank() { rank++; }
	public int getCardsValue() { return cardsValue;}
	
	public void setHand(Card[] h){
		hand = h;
		setCardsValue();
		setHandValue(Logic.checkHand(hand));
	}
	
	public void setHandValue(String s){
		if(s == "Royal Flush")
			handValue = 9;
		else if(s == "Straight Flush")
			handValue = 8;
		else if(s ==  "Four of a Kind")
			handValue = 7;
		else if(s ==  "Full House")
			handValue = 6;
		else if(s ==  "Flush")
			handValue = 5;
		else if(s ==  "Straight")
			handValue = 4;
		else if(s ==  "Three of a Kind")
			handValue = 3;
		else if(s ==  "Two Pair")
			handValue = 2;
		else if(s ==  "Pair")
			handValue = 1;
		else if(s ==  "High Card")
			handValue = 0;
		else
			handValue = -1;
	}
		
	public void sort() {
		Card temp = null;
		for(int i=0;i<=MAX_HAND-1;i++){
			for(int j=0;j<=hand.length-2;j++){
				if(hand[j].getRank() > hand[j+1].getRank()){
					temp = null;    
					temp = hand[j];
					hand[j] = hand[j+1];
					hand[j+1] = temp;
				}      
			}   
		}
	}
	

	public String printHand() {
		String s = name + ": ";
		for(int x=0; x< MAX_HAND;x++){
			s+= hand[x].print() + ",";
		}
		s = s.substring(0, s.length()-1);
		return s;
	}

	public void setCardsValue() {
		for(int i=0; i< MAX_HAND;i++){
			cardsValue += hand[i].getRank();
		}
	}

	public String printHandType() {
		String s = "Error";
		if(handValue == 9)
			s = "Royal Flush";
		else if(handValue == 8)
			s = "Straight Flush";
		else if(handValue == 7)
			s = "Four of a Kind";
		else if(handValue == 6)
			s =  "Full House";
		else if(handValue == 5)
			s =  "Flush";
		else if(handValue == 4)
			s = "Straight";
		else if(handValue == 3)
			s =  "Three of a Kind";
		else if(handValue == 2)
			s = "Two Pair";
		else if(handValue == 1)
			s = "Pair";
		else if(handValue == 0)
			s = "High Card";
		return s;
	}
}


