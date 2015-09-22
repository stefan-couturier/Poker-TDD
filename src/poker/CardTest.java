package poker;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void test() {
		Card c = new Card();
		c.suit = 'S';
		c.rank = 1;
		assertEquals("AceSpades", c.print());
		
		Card d = new Card();
		c.suit = 'D';
		c.rank = 1;
		assertEquals( 0, d.compareTo(c));
		
		Card e = new Card();
		c.suit = 'D';
		c.rank = 6;

		assertEquals( -1, e.compareTo(d));
		assertEquals( 1, d.compareTo(e));
	}

}
