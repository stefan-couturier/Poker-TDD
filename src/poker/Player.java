package poker;

public class Player {
	private String name;
	Card[] hand;
	
	Player(String s){
		hand = null;
		name = s;
	}
	
	public String getName(){ return name; }
	public void setHand(Card[] h) { hand = h; }
	public Card[] getHand() { return hand; }
	
	public void sort() {
		/*Card temp;
		for(int i=0;i<MAX_HAND-1;i++){
			temp= hand[i];
			if(temp.rank > hand[i+1].rank){
				hand[i] = hand[i+1];
				hand[i+i] = temp;
				i--;
			}
		}*/
	}

}
