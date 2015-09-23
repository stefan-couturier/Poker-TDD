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
		Card c1 = new Card();
		c1.suit = 'S';
		c1.rank = 1;
		assertEquals("AceSpades", c1.print());
		
		Card c2 = new Card();
		c2.suit = 'D';
		c2.rank = 1;
		assertEquals( 0, c2.compareTo(c1));
		
		Card c3 = new Card();
		c3.suit = 'D';
		c3.rank = 6;

		assertEquals( 1, c3.compareTo(c2));
		assertEquals( -1, c2.compareTo(c3));
	}
	
	public void testDeck(){
		Deck d1 = new Deck();
		assertNotNull(d1);
		assertEquals("AceClubs", d1.cards[0].print());
		assertEquals("KingClubs", d1.cards[12].print());
		assertEquals("ThreeDiamonds", d1.cards[15].print());
		assertEquals("KingHearts", d1.cards[51].print());
		
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
	}
	
	public void testPlayer(){
		Player p1 = new Player("Stefan");
		assertNotNull(p1);
		assertEquals(p1.getName(), "Stefan");
	}

}
