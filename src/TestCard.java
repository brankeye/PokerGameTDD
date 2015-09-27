
import junit.framework.*;

public class TestCard extends TestCase {

	public TestCard(String testName) {
		super(testName);
	}
	
	// stores the rank and suit of a card from the string format "RankSuit"
	public void testStoreRankSuit() {
		Card cardTwoHearts = new Card();
		assertEquals(1, cardTwoHearts.storeRankSuit("TwoHearts"));
		
		Card cardTwoThreeFour = new Card();
		assertEquals(0, cardTwoThreeFour.storeRankSuit("TwoThreeFour"));
		
		Card cardOne = new Card();
		assertEquals(0, cardOne.storeRankSuit("One"));
		
		Card cardBugHearts = new Card();
		assertEquals(0, cardBugHearts.storeRankSuit("BugHearts"));
		
		Card cardTwoLife = new Card();
		assertEquals(0, cardTwoLife.storeRankSuit("TwoLife"));
		
		Card card01 = new Card();
		assertEquals(0, card01.storeRankSuit("01"));
		
		Card cardEmpty = new Card();
		assertEquals(0, cardEmpty.storeRankSuit(""));
		
	}
	
	public void testGetRank() {
		Card cardTwoHearts = new Card();
		cardTwoHearts.storeRankSuit("TwoHearts");
		assertEquals("Two", cardTwoHearts.getRank());
	}
	
	public void testGetSuit() {
		Card cardTwoHearts = new Card();
		cardTwoHearts.storeRankSuit("TwoHearts");
		assertEquals("Hearts", cardTwoHearts.getSuit());
	}
	
	// the card score is an integer representation of the rank (2 Card is 1, Ace is 13)
	public void testGetCardScore() {
		Card cardTwoHearts = new Card();
		cardTwoHearts.storeRankSuit("TwoHearts");
		assertEquals(1, cardTwoHearts.getCardScore());
		
		Card cardThreeHearts = new Card();
		cardThreeHearts.storeRankSuit("ThreeHearts");
		assertEquals(2, cardThreeHearts.getCardScore());
	}
}
