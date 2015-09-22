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
	}

}
