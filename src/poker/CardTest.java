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
		
		Deck d = new Deck();
		assertNotNull(d);
		assertEquals("AceClubs", d.cards[0].print());
		assertEquals("KingClubs", d.cards[12].print());
		assertEquals("ThreeDiamonds", d.cards[15].print());
		assertEquals("KingHearts", d.cards[51].print());
	}

}
