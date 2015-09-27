
import junit.framework.*;

public class TestCard extends TestCase {

	public TestCard(String testName) {
		super(testName);
	}
	
	// stores the rank and suit of a card from the string format "RankSuit"
	public void testStoreRankSuit() {
		Card cardTwoHearts = new Card();
		assertEquals(1, cardTwoHearts.storeRankSuit("TwoHearts"));
		assertEquals(0, cardTwoHearts.storeRankSuit("TwoThreeFour"));
		assertEquals(0, cardTwoHearts.storeRankSuit("One"));
		assertEquals(0, cardTwoHearts.storeRankSuit("BugHearts"));
		assertEquals(0, cardTwoHearts.storeRankSuit("TwoLife"));
		assertEquals(0, cardTwoHearts.storeRankSuit("01"));
		assertEquals(0, cardTwoHearts.storeRankSuit(""));
	}
}
