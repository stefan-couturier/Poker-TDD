package poker;

public class Player {
	private String name;
	Card[] hand;
	final int MAX_HAND = 5;
	
	Player(String s){
		hand = null;
		name = s;
	}
	
	public String getName(){ return name; }
	public void setHand(Card[] h) { hand = h; }
	public Card[] getHand() { return hand; }
	
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


