package poker;

public class Deck {
	final int MAX_SIZE = 52;

	Card[] cards = new Card[MAX_SIZE];
	
	public Deck(){
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
			for(int rank = 1; rank <= 13; rank++){
				cards[counter] = new Card();
				cards[counter].suit = suit;
				cards[counter].rank = rank;
				++counter;
			}
		}
	}
	
}
