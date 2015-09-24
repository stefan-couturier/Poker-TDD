package poker;

import java.util.Random;

public class Deck {
	final int MAX_SIZE = 52;
	final int MAX_HAND = 5;
	Random random = new Random();
	public int position;

	Card[] cards = new Card[MAX_SIZE];
	
	public Deck(){
		position = 0;
		int counter = 0;
		char suit = ' ';
		for(int s = 0; s < 4; s++){
			if(s == 0)
				suit = 'C';
			else if(s == 1)
				suit = 'D';
			else if(s == 2)
				suit = 'S';
			else if(s == 3)
				suit = 'H';
			for(int rank = 2; rank <= 14; rank++){
				cards[counter] = new Card(suit, rank);
				++counter;
			}
		}
	}

	public void shuffle() {
		position = 0;
		int num1, num2;
		for(int i=0; i < 1000; i++){
			num1 = random.nextInt(MAX_SIZE);
			num2 = random.nextInt(MAX_SIZE);
			Card temp = cards[num1];
			cards[num1] = cards[num2];
			cards[num2] = temp;
		}
	}
	
	public Card[] deal(){
		Card[] hand = new Card[MAX_HAND];
		for(int x =0; x<MAX_HAND;x++){
			hand[x] = cards[position];
			++position;
		}
		return hand;
	}

	public String print() {
		String s = "";
		for(int x=0; x< MAX_HAND;x++){
			s+= cards[x].print() + ",";
		}
		s = s.substring(0, s.length()-1);
		return s;
	}	
}
