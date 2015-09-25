package poker;

public class Logic {
	final static int MAX_HAND = 5;

	public static String checkHand(Card[] hand) {
		if(royalFlush(hand))
			return "Royal Flush";
		else if(straightFlush(hand))
			return "Straight Flush";
		else if(fourKind(hand))
			return "Four of a Kind";
		else if(fullHouse(hand))
			return "Full House";
		else if(flush(hand))
			return "Flush";
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

	private static boolean royalFlush(Card[] hand) {
		if(hand[0].getRank() == 10 && hand[1].getRank() == 11 && hand[2].getRank() == 12 && 
				hand[3].getRank() == 13 && hand[4].getRank() == 14 && hand[0].getSuit() == hand[1].getSuit() && 
				hand[1].getSuit() == hand[2].getSuit() && hand[2].getSuit() == hand[3].getSuit() && 
				hand[3].getSuit() == hand[4].getSuit())
			return true;
		return false;
	}

	private static boolean straightFlush(Card[] hand) {
		for(int x=1; x < MAX_HAND; x++){
			if(hand[0].getSuit() != hand[x].getSuit())
				return false;
		}
		for(int x=1; x< MAX_HAND; x++){
			if(hand[x-1].getRank() != hand[x].getRank()- 1)
				return false;
		}
		return true;
	}

	private static boolean fourKind(Card[] hand) {
		if(hand[0].getRank() == hand[1].getRank() && hand[0].getRank() == hand[2].getRank() && 
				hand[0].getRank() == hand[3].getRank())
			return true;
		if(hand[1].getRank() == hand[2].getRank() && hand[1].getRank() == hand[3].getRank() && 
				hand[1].getRank() == hand[4].getRank())
			return true;
		return false;
	}

	private static boolean fullHouse(Card[] hand) {
		if(hand[0].getRank() == hand[1].getRank() && hand[0].getRank() == hand[2].getRank() && 
				hand[3].getRank() == hand[4].getRank())
			return true;
		if(hand[0].getRank() == hand[1].getRank() && hand[2].getRank() == hand[3].getRank() && 
				hand[2].getRank() == hand[4].getRank())
			return true;
		return false;
	}

	private static boolean flush(Card[] hand) {
		for(int x=1; x < MAX_HAND; x++){
			if(hand[0].getSuit() != hand[x].getSuit())
				return false;
		}
		return true;
	}

	private static boolean straight(Card[] hand) {
		for(int x=1; x< MAX_HAND; x++){
			if(hand[x-1].getRank() != hand[x].getRank()- 1)
				return false;
		}
		return true;
	}

	private static boolean threeKind(Card[] hand) {
		if(hand[0].getRank() == hand[1].getRank() && hand[0].getRank() == hand[2].getRank())
			return true;
		if(hand[1].getRank() == hand[2].getRank() && hand[1].getRank() == hand[3].getRank())
			return true;
		if(hand[2].getRank() == hand[3].getRank() && hand[2].getRank() == hand[4].getRank())
			return true;
		return false;
	}

	private static boolean twoPair(Card[] hand) {
		int count = 0;
		for(int i=0;i<=MAX_HAND-1;i++){
			for(int j=i+1;j<=MAX_HAND-2;j++){
				if(hand[i].getRank() == hand[j].getRank()){
					count++;
				}      
			}   
		}
		if(count == 2)
			return true;
		return false;
	}

	private static boolean pair(Card[] hand) {
		for(int i=0;i<=MAX_HAND-1;i++){
			for(int j=0;j<=hand.length-2;j++){
				if(hand[j].getRank() == hand[j+1].getRank()){
					return true;
				}      
			}   
		}
		return false;
	}
}
