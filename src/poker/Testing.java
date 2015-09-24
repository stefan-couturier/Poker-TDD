package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test() {
		testCards();
		testDeck();
		testPlayer();
	}
	
	public void testCards(){
		//create card assign values
		Card c1 = new Card('S',14);
		assertEquals("AceSpades", c1.print());
		
		Card c2 = new Card('D', 14);
		assertEquals( 0, c2.compareTo(c1));
		
		Card c3 = new Card('D', 6);

		assertEquals( -1, c3.compareTo(c2));
		assertEquals( 1, c2.compareTo(c3));
	}
	
	public void testDeck(){
		//building deck and checking card values
		Deck d1 = new Deck();
		assertNotNull(d1);
		assertEquals("TwoClubs", d1.cards[0].print());
		assertEquals("KingClubs", d1.cards[11].print());
		assertEquals("ThreeDiamonds", d1.cards[14].print());
		assertEquals("KingHearts", d1.cards[50].print());
		
		//testing if shuffle works
		Deck d2 = new Deck();
		
		assertEquals(d1.cards[0].print(), d2.cards[0].print());
		assertEquals(d1.cards[10].print(), d2.cards[10].print());
		assertEquals(d1.cards[20].print(), d2.cards[20].print());
		assertEquals(d1.cards[43].print(), d2.cards[43].print());
		d2.shuffle();
		assertNotEquals(d1.cards[0].print(), d2.cards[0].print());
		assertNotEquals(d1.cards[10].print(), d2.cards[10].print());
		assertNotEquals(d1.cards[20].print(), d2.cards[20].print());
		assertNotEquals(d1.cards[43].print(), d2.cards[43].print());
		
		//checking if dealing works, make sure not to deal same cards
		Card[] hand1 = null;
		hand1 = d2.deal();
		for(int x=0;x<5;x++){
			assertNotNull(hand1[0]);
		}
		
		Card[] hand2 = null;
		hand2 = d2.deal();
		assertNotEquals(hand2[0].print(), hand1[0].print());
		assertNotEquals(hand2[1].print(), hand1[1].print());
		assertNotEquals(hand2[2].print(), hand1[2].print());
		assertNotEquals(hand2[3].print(), hand1[3].print());
		assertNotEquals(hand2[4].print(), hand1[4].print());
		
		//check printing out a hand
		String x1 = (d2.cards[0].print() + "," + d2.cards[1].print() + "," + d2.cards[2].print() + 
				"," + d2.cards[3].print() + "," + d2.cards[4].print());
		String x2 = d2.print();
		assertEquals(x1, x2);
		System.out.print(x1);
		System.out.print(x2);		
	}
	
	public void testPlayer(){
		Player p1 = new Player("Stefan");
		assertNotNull(p1);
		assertEquals(p1.getName(), "Stefan");
		
				//check ordering of hand
		Deck d1 = new Deck();
		d1.shuffle();
		p1.setHand(d1.deal());
		p1.sort();
		Card[] h1 = p1.getHand();
		assertTrue((h1[0].getRank() <= h1[1].getRank()) &&
				(h1[1].getRank() <= h1[2].getRank()) &&
				(h1[2].getRank() <= h1[3].getRank()) &&
				(h1[3].getRank() <= h1[4].getRank()));
		System.out.print("\n" + p1.printHand());
	}

}
