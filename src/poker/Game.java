package poker;

public class Game {

	public String checkHand(Card[] hand) {
		if(royalFlush(hand))
			return "Royal Flush";
		else if(straightFlush(hand))
			return "Straight Flush";
		else if(fourKind(hand))
			return "Four of a Kind";
		else if(fullHouse(hand))
			return "Full House";
		else if(flush(hand))
			return "Flash";
		else if(straight(hand))
			return "Straight";
		else if(threeKind(hand))
			return "Three of a Kind";
		else if(twoPair(hand))
			return "Two Pair";
		else if(pair(hand))
			return "Pair";
		else
			return "High Card";
	}

	private boolean royalFlush(Card[] hand) {
		if(hand[0].getRank() == 10 && hand[1].getRank() == 11 && hand[2].getRank() == 12 && 
				hand[3].getRank() == 13 && hand[4].getRank() == 14 && hand[0].getSuit() == hand[1].getSuit() && 
				hand[1].getSuit() == hand[2].getSuit() && hand[2].getSuit() == hand[3].getSuit() && 
				hand[3].getSuit() == hand[4].getSuit())
			return true;
		return false;
	}

	private boolean straightFlush(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean fourKind(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean fullHouse(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean flush(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean straight(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean threeKind(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean twoPair(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean pair(Card[] hand) {
		// TODO Auto-generated method stub
		return false;
	}
}
