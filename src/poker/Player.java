package poker;

public class Player {
	private String name;
	private Card[] hand;
	private final int MAX_HAND = 5;
	private int rank;
	private int handValue;
	
	Player(String s){
		hand = null;
		name = s;
		rank = 0;
		handValue = -1;
	}
	
	public String getName(){ return name; }
	public void setHand(Card[] h) { hand = h; }
	public Card[] getHand() { return hand; }

	public int getHandValue() { return handValue; }
	public int getRank() { return rank; }
	public void addRank() { rank++; }
	
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
		String s = "";
		for(int x=0; x< MAX_HAND;x++){
			s+= hand[x].print() + ",";
		}
		s = s.substring(0, s.length()-1);
		return s;
	}
}


