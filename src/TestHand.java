
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
	
	public void testIsStraightFlush() {
		Hand straightFlushHand = new Hand();
		// check for a straight flush
		straightFlushHand.addCard("TwoHearts");
		straightFlushHand.addCard("ThreeHearts");
		straightFlushHand.addCard("FourHearts");
		straightFlushHand.addCard("FiveHearts");
		straightFlushHand.addCard("SixHearts");
		assertEquals(1, straightFlushHand.isStraightFlush());
		
		Hand falseStraightFlushHand = new Hand();
		// check for a false straight flush
		falseStraightFlushHand.addCard("TwoHearts");
		falseStraightFlushHand.addCard("ThreeHearts");
		falseStraightFlushHand.addCard("FourHearts");
		falseStraightFlushHand.addCard("FiveHearts");
		falseStraightFlushHand.addCard("SevenHearts");
		assertEquals(0, falseStraightFlushHand.isStraightFlush());
		
		Hand falseStraightFlushHandTwo = new Hand();
		// check for a false straight flush
		falseStraightFlushHandTwo.addCard("TwoHearts");
		falseStraightFlushHandTwo.addCard("ThreeHearts");
		falseStraightFlushHandTwo.addCard("FourHearts");
		falseStraightFlushHandTwo.addCard("FiveHearts");
		falseStraightFlushHandTwo.addCard("SixClubs");
		assertEquals(0, falseStraightFlushHandTwo.isStraightFlush());
	}
	
	public void testIsFlush() {
		Hand flushHand = new Hand();
		// check for a flush
		flushHand.addCard("TwoHearts");
		flushHand.addCard("ThreeHearts");
		flushHand.addCard("KingHearts");
		flushHand.addCard("QueenHearts");
		flushHand.addCard("FourHearts");
		assertEquals(1, flushHand.isFlush());
		
		Hand falseFlushHand = new Hand();
		// check for a false flush
		falseFlushHand.addCard("TwoHearts");
		falseFlushHand.addCard("ThreeHearts");
		falseFlushHand.addCard("KingHearts");
		falseFlushHand.addCard("QueenHearts");
		falseFlushHand.addCard("FourSpades");
		assertEquals(0, falseFlushHand.isFlush());
	}
	
	public void testIsStraight() {
		Hand straightHand = new Hand();
		// check for a straight
		straightHand.addCard("TwoHearts");
		straightHand.addCard("ThreeHearts");
		straightHand.addCard("FourDiamonds");
		straightHand.addCard("FiveHearts");
		straightHand.addCard("SixSpades");
		assertEquals(1, straightHand.isStraight());
		
		Hand falseStraightHand = new Hand();
		// check for a false straight
		falseStraightHand.addCard("TwoHearts");
		falseStraightHand.addCard("ThreeHearts");
		falseStraightHand.addCard("FourDiamonds");
		falseStraightHand.addCard("FiveHearts");
		falseStraightHand.addCard("SevenSpades");
		assertEquals(0, falseStraightHand.isStraight());
	}
	
	public void testGetSortedScoreList() {
		Hand firstHand = new Hand();
		firstHand.addCard("TwoHearts");
		firstHand.addCard("ThreeHearts");
		firstHand.addCard("FourHearts");
		firstHand.addCard("FiveHearts");
		firstHand.addCard("SixHearts");
		ArrayList<Integer> scoreList = firstHand.getSortedScoreList();
		assertEquals(1, scoreList.get(0).intValue()); // 2 Card has score of 1
		assertEquals(2, scoreList.get(1).intValue()); // 3 Card has score of 2
		assertEquals(3, scoreList.get(2).intValue()); // 4 Card has score of 3
		assertEquals(4, scoreList.get(3).intValue()); // 5 Card has score of 4
		assertEquals(5, scoreList.get(4).intValue()); // 6 Card has score of 5
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
