
import junit.framework.*;

public class TestDeck extends TestCase {
	
	public TestDeck(String testName) {
		super(testName);
	}
	
	public void testAddCard() {
		Deck firstDeck = new Deck();
		Card card1 = new Card();
		card1.storeRankSuit("TwoHearts");
		assertEquals(1, firstDeck.addCard(card1));
		
		Card card2 = new Card();
		card2.storeRankSuit("TwoHearts");
		assertEquals(0, firstDeck.addCard(card2));
	}
	
	public void testCheckCard() {
		Deck firstDeck = new Deck();
		Card card1 = new Card();
		card1.storeRankSuit("TwoHearts");
		assertEquals(1, firstDeck.addCard(card1));
		
		Card card2 = new Card();
		card2.storeRankSuit("TwoHearts");
		assertEquals(1, firstDeck.hasCard(card2));
		
		Card card3 = new Card();
		card3.storeRankSuit("ThreeHearts");
		assertEquals(0, firstDeck.hasCard(card3));
	}
}
