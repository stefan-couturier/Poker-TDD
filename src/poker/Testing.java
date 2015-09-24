package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testing {

	@Test
	public void test() {
		testCards();
		testDeck();
		testPlayer();
		testGameLogic();
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
	
	public void testGameLogic(){

		Card[] c = new Card[5];
		c[0] = new Card('H', 10);
		c[1] = new Card('H', 11);
		c[2] = new Card('H', 12);
		c[3] = new Card('H', 13);
		c[4] = new Card('H', 14);
		Game g1 = new Game();
		String r1 = g1.checkHand(c);
		assertEquals(r1, "Royal Flush");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 10);
		c[1].setCard('H', 9);
		c[2].setCard('H', 8);
		c[3].setCard('H', 7);
		c[4].setCard('H', 6);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Straight Flush");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 6);
		c[1].setCard('D', 6);
		c[2].setCard('C', 6);
		c[3].setCard('S', 6);
		c[4].setCard('H', 7);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Four of a Kind");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 6);
		c[1].setCard('D', 6);
		c[2].setCard('C', 6);
		c[3].setCard('S', 7);
		c[4].setCard('H', 7);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Full House");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 4);
		c[1].setCard('H', 6);
		c[2].setCard('H', 7);
		c[3].setCard('H', 10);
		c[4].setCard('H', 14);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Flush");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 6);
		c[1].setCard('D', 7);
		c[2].setCard('C', 8);
		c[3].setCard('S', 9);
		c[4].setCard('H', 10);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Straight");	
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 6);
		c[1].setCard('D', 6);
		c[2].setCard('C', 6);
		c[3].setCard('S', 7);
		c[4].setCard('H', 10);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Three of a Kind");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 2);
		c[1].setCard('D', 2);
		c[2].setCard('C', 6);
		c[3].setCard('S', 6);
		c[4].setCard('H', 9);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Two Pair");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 2);
		c[1].setCard('D', 2);
		c[2].setCard('C', 4);
		c[3].setCard('S', 7);
		c[4].setCard('H', 9);
		r1 = g1.checkHand(c);
		assertEquals(r1, "Pair");
		System.out.print("\n" + r1);
		
		c[0].setCard('H', 2);
		c[1].setCard('D', 3);
		c[2].setCard('C', 4);
		c[3].setCard('S', 7);
		c[4].setCard('H', 9);
		r1 = g1.checkHand(c);
		assertEquals(r1, "High Card");
		System.out.print("\n" + r1);
	}
}
