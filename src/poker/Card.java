package poker;

public class Card {
	final int MAX_HAND = 5;
	private int rank;
	private char suit;

	public Card(char s, int r){
		suit = s;
		rank = r;
	}
	public char getSuit(){ return suit; }
	public int getRank() { return rank; }
	public void setCard(char s, int r) { suit = s; rank = r;}

	public String print(){
		String value = "";
		
		if(rank == 14)
			value = "Ace";
		else if(rank == 2)
			value = "Two";
		else if(rank == 3)
			value = "Three";	
		else if(rank == 4)
			value = "Four";
		else if(rank == 5)
			value = "Five";	
		else if(rank == 6)
			value = "Six";
		else if(rank == 7)
			value = "Seven";	
		else if(rank == 8)
			value = "Eight";
		else if(rank == 9)
			value = "Nine";	
		else if(rank == 10)
			value = "Ten";
		else if(rank == 11)
			value = "Jack";	
		else if(rank == 12)
			value = "Queen";
		else if(rank == 13)
			value = "King";
		else
			value = "ValueError";
		if(suit == 'H')
			value += "Hearts";
		else if(suit == 'D')
			value += "Diamonds";
		else if(suit == 'S')
			value += "Spades";
		else if(suit == 'C')
			value += "Clubs";
		else
			value += "";
		return value;
	}

	public int compareTo(Card c) {
		if(rank == c.rank)
			return 0;
		else if(rank > c.rank)
			return 1;
		else if(rank < c.rank)
			return -1;
		
		return 999;
	}
}
