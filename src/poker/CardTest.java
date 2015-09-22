package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void test() {
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
	}

}
