
import java.util.ArrayList;

import junit.framework.*;

public class TestHand extends TestCase {

	public TestHand(String testName) {
		super(testName);
	}
	
	public void testAddCard() {
		Hand firstHand = new Hand();
		assertEquals(1, firstHand.addCard("TwoHearts"));
		assertEquals(1, firstHand.addCard("TwoSpades"));
		assertEquals(0, firstHand.addCard("TwoHearts")); // no duplicates
		assertEquals(0, firstHand.addCard("AceOfSpades")); // doesn't accept incorrect cards
		
		assertEquals(1, firstHand.addCard("TwoClubs"));
		assertEquals(1, firstHand.addCard("TwoDiamonds"));
		assertEquals(1, firstHand.addCard("ThreeClubs"));
		assertEquals(0, firstHand.addCard("TwoClubs")); // adding more than 5 cards fails
	}
	
	public void testGetSortedScoreList() {
		Hand firstHand = new Hand();
		firstHand.addCard("TwoHearts");
		firstHand.addCard("ThreeHearts");
		firstHand.addCard("FourHearts");
		firstHand.addCard("FiveHearts");
		firstHand.addCard("SixHearts");
		ArrayList<Integer> scoreList = firstHand.getSortedScoreList();
		assertEquals(1, scoreList.get(0)); // 2 Card has score of 1
		assertEquals(2, scoreList.get(1)); // 3 Card has score of 2
		assertEquals(3, scoreList.get(2)); // 4 Card has score of 3
		assertEquals(4, scoreList.get(3)); // 5 Card has score of 4
		assertEquals(5, scoreList.get(4)); // 6 Card has score of 5
	}
	
	public void testGetHandScore() {
		Hand firstHand = new Hand();
		assertEquals(-1, firstHand.getHandScore()); // score is initialized to -1 at start
	}
	
	public void testGetHandName() {
		Hand firstHand = new Hand();
		assertEquals("", firstHand.getHandName()); // hand name empty for now
	}
}
