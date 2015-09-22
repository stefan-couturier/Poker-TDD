package poker;

public class Card {
	public int rank;
	public String suit;
	
	public String print(){
		String value = "";
		
		if(rank == 1)
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
		return value;
	}
}
