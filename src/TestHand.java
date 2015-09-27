
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
	
	public void testCalculateHandScore() {
		Hand highCardHand = new Hand();
		highCardHand.addCard("TwoHearts");
		highCardHand.addCard("FourClubs");
		highCardHand.addCard("KingDiamonds");
		highCardHand.addCard("QueenSpades");
		highCardHand.addCard("AceHearts");
		assertEquals(1, highCardHand.calculateHandScore()); // high card hand score is 1
	}
	
	public void testIsRoyalFlush() {
		Hand royalFlushHand = new Hand();
		// check for a royal flush
		royalFlushHand.addCard("TenHearts");
		royalFlushHand.addCard("JackHearts");
		royalFlushHand.addCard("QueenHearts");
		royalFlushHand.addCard("KingHearts");
		royalFlushHand.addCard("AceHearts");
		assertEquals(1, royalFlushHand.isRoyalFlush());
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
	
	public void testIsFourKind() {
		Hand fourKindHand = new Hand();
		// check for a four kind aaaab
		fourKindHand.addCard("TwoHearts");
		fourKindHand.addCard("TwoDiamonds");
	    fourKindHand.addCard("TwoSpades");
		fourKindHand.addCard("TwoClubs");
		fourKindHand.addCard("SixHearts");
		assertEquals(1, fourKindHand.isFourKind());
		
		Hand otherFourKindHand = new Hand();
		// check for a four kind abbbb
		otherFourKindHand.addCard("TwoHearts");
		otherFourKindHand.addCard("FiveDiamonds");
		otherFourKindHand.addCard("FiveClubs");
	    otherFourKindHand.addCard("FiveSpades");
		otherFourKindHand.addCard("FiveHearts");
		assertEquals(1, otherFourKindHand.isFourKind());
	}
	
	public void testIsFullHouse() {
		Hand fullHouseHand = new Hand();
		// check for a full house
		fullHouseHand.addCard("TenHearts");
		fullHouseHand.addCard("TenDiamonds");
		fullHouseHand.addCard("TenSpades");
		fullHouseHand.addCard("TwoClubs");
		fullHouseHand.addCard("TwoHearts");
		assertEquals(1, fullHouseHand.isFullHouse());
		
		Hand otherFullHouseHand = new Hand();
		// check for a full house
		otherFullHouseHand.addCard("TenHearts");
		otherFullHouseHand.addCard("TenDiamonds");
		otherFullHouseHand.addCard("TwoSpades");
		otherFullHouseHand.addCard("TwoClubs");
		otherFullHouseHand.addCard("TwoHearts");
		assertEquals(1, otherFullHouseHand.isFullHouse());
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
	
	public void testIsThreeKind() {
		Hand threeKindHand = new Hand();
		// check for a three kind aaabc
		threeKindHand.addCard("TwoHearts");
		threeKindHand.addCard("TwoDiamonds");
	    threeKindHand.addCard("TwoSpades");
		threeKindHand.addCard("FiveClubs");
		threeKindHand.addCard("SixHearts");
		assertEquals(1, threeKindHand.isThreeKind());
		
		Hand otherThreeKindHand = new Hand();
		// check for a three kind abbbc
		otherThreeKindHand.addCard("TwoHearts");
		otherThreeKindHand.addCard("ThreeDiamonds");
	    otherThreeKindHand.addCard("ThreeSpades");
		otherThreeKindHand.addCard("ThreeClubs");
		otherThreeKindHand.addCard("SixHearts");
		assertEquals(1, otherThreeKindHand.isThreeKind());
		
		Hand otherThreeKindHand2 = new Hand();
		// check for a three kind abccc
		otherThreeKindHand2.addCard("TwoHearts");
		otherThreeKindHand2.addCard("ThreeDiamonds");
	    otherThreeKindHand2.addCard("FourSpades");
		otherThreeKindHand2.addCard("FourClubs");
		otherThreeKindHand2.addCard("FourHearts");
		assertEquals(1, otherThreeKindHand2.isThreeKind());
	}
	
	public void testIsTwoPair() {
		Hand twoPairHand = new Hand();
		// check for a two pair aabbc
		twoPairHand.addCard("TwoHearts");
		twoPairHand.addCard("TwoDiamonds");
		twoPairHand.addCard("ThreeSpades");
		twoPairHand.addCard("ThreeClubs");
		twoPairHand.addCard("SixHearts");
		assertEquals(1, twoPairHand.isTwoPair());
		
		Hand twoPairHand2 = new Hand();
		// check for a two pair abbcc
		twoPairHand2.addCard("TwoHearts");
		twoPairHand2.addCard("ThreeDiamonds");
		twoPairHand2.addCard("ThreeSpades");
		twoPairHand2.addCard("FourClubs");
		twoPairHand2.addCard("FourHearts");
		assertEquals(1, twoPairHand2.isTwoPair());
		
		Hand twoPairHand3 = new Hand();
		// check for a two pair aabcc
		twoPairHand3.addCard("TwoHearts");
		twoPairHand3.addCard("TwoDiamonds");
		twoPairHand3.addCard("ThreeSpades");
		twoPairHand3.addCard("FourClubs");
		twoPairHand3.addCard("FourHearts");
		assertEquals(1, twoPairHand3.isTwoPair());
	}
	
	public void testIsPair() {
		Hand pairHand = new Hand();
		// check for a two pair aabcd
		pairHand.addCard("TwoHearts");
		pairHand.addCard("TwoDiamonds");
		pairHand.addCard("ThreeSpades");
		pairHand.addCard("FourClubs");
		pairHand.addCard("EightHearts");
		assertEquals(1, pairHand.isPair());
		
		Hand pairHand2 = new Hand();
		// check for a two pair abbcd
		pairHand2.addCard("TwoHearts");
		pairHand2.addCard("ThreeDiamonds");
		pairHand2.addCard("ThreeSpades");
		pairHand2.addCard("FourClubs");
		pairHand2.addCard("EightHearts");
		assertEquals(1, pairHand2.isPair());
		
		Hand pairHand3 = new Hand();
		// check for a two pair abccd
		pairHand3.addCard("TwoHearts");
		pairHand3.addCard("ThreeDiamonds");
		pairHand3.addCard("FourSpades");
		pairHand3.addCard("FourClubs");
		pairHand3.addCard("EightHearts");
		assertEquals(1, pairHand3.isPair());
		
		Hand pairHand4 = new Hand();
		// check for a two pair abcdd
		pairHand4.addCard("TwoHearts");
		pairHand4.addCard("ThreeDiamonds");
		pairHand4.addCard("FourSpades");
		pairHand4.addCard("FiveClubs");
		pairHand4.addCard("FiveHearts");
		assertEquals(1, pairHand4.isPair());
	}
	
	public void testGetHighCardScore() {
		Hand highHand = new Hand();
		// check for highest card
		highHand.addCard("TwoHearts");
		highHand.addCard("ThreeDiamonds");
		highHand.addCard("FourSpades");
		highHand.addCard("SixClubs");
		highHand.addCard("KingHearts");
		assertEquals(12, highHand.getHighCardScore()); // 2-Ace == 1-13
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
	
	// to be used to compare against other hands of the same rank (ONLY compare against equivalent ranked hands!)
	public void testGetComparativeScoreList() {
		// empty hand should return an empty comparative list
		Hand firstHand = new Hand();
		ArrayList<Integer> fh_scoreList = firstHand.getComparativeScoreList();
		assertEquals(0, fh_scoreList.size()); // returns empty list for now
		
		// Comparative List of High Card hand
		Hand highCardHand = new Hand();
		highCardHand.addCard("TwoHearts");
		highCardHand.addCard("FourClubs");
		highCardHand.addCard("KingDiamonds");
		highCardHand.addCard("QueenSpades");
		highCardHand.addCard("AceHearts");
		highCardHand.calculateHandScore();
		// should return A, K, Q, Four, Two or (13, 12, 11, 3, 1)
		ArrayList<Integer> hc_scoreList = highCardHand.getComparativeScoreList();
		assertEquals(13, hc_scoreList.get(0).intValue());
		assertEquals(12, hc_scoreList.get(1).intValue());
		assertEquals(11, hc_scoreList.get(2).intValue());
		assertEquals(3, hc_scoreList.get(3).intValue());
		assertEquals(1, hc_scoreList.get(4).intValue());
		
		// Comparative List of Pair hand
		
		// check aabcd
		Hand pairHand = new Hand();
		pairHand.addCard("TwoHearts");
		pairHand.addCard("TwoClubs");
		pairHand.addCard("KingDiamonds");
		pairHand.addCard("TenSpades");
		pairHand.addCard("ThreeHearts");
		pairHand.calculateHandScore();
		// should return 2, K, 10, 3 or (1, 12, 9, 2)
		ArrayList<Integer> p_scoreList = pairHand.getComparativeScoreList();
		assertEquals(1, p_scoreList.get(0).intValue());
		assertEquals(12, p_scoreList.get(1).intValue());
		assertEquals(9, p_scoreList.get(2).intValue());
		assertEquals(2, p_scoreList.get(3).intValue());
		
		// check abbcd
		Hand pairHand2 = new Hand();
		pairHand2.addCard("ThreeHearts");
		pairHand2.addCard("ThreeClubs");
		pairHand2.addCard("KingDiamonds");
		pairHand2.addCard("TenSpades");
		pairHand2.addCard("TwoHearts");
		pairHand2.calculateHandScore();
		// should return 3, K, 10, 2 or (2, 12, 9, 1)
		ArrayList<Integer> p2_scoreList = pairHand2.getComparativeScoreList();
		assertEquals(2, p2_scoreList.get(0).intValue());
		assertEquals(12, p2_scoreList.get(1).intValue());
		assertEquals(9, p2_scoreList.get(2).intValue());
		assertEquals(1, p2_scoreList.get(3).intValue());
		
		// check abccd
		Hand pairHand3 = new Hand();
		pairHand3.addCard("TwoHearts");
		pairHand3.addCard("ThreeClubs");
		pairHand3.addCard("KingDiamonds");
		pairHand3.addCard("KingSpades");
		pairHand3.addCard("AceHearts");
		pairHand3.calculateHandScore();
		// should return K, A, 3, 2 or (12, 13, 2, 1)
		ArrayList<Integer> p3_scoreList = pairHand3.getComparativeScoreList();
		assertEquals(12, p3_scoreList.get(0).intValue());
		assertEquals(13, p3_scoreList.get(1).intValue());
		assertEquals(2, p3_scoreList.get(2).intValue());
		assertEquals(1, p3_scoreList.get(3).intValue());
		
		// check abcdd
		Hand pairHand4 = new Hand();
		pairHand4.addCard("TwoHearts");
		pairHand4.addCard("ThreeClubs");
		pairHand4.addCard("FourDiamonds");
		pairHand4.addCard("AceSpades");
		pairHand4.addCard("AceHearts");
		pairHand4.calculateHandScore();
		// should return A, 4, 3, 2 or (13, 3, 2, 1)
		ArrayList<Integer> p4_scoreList = pairHand4.getComparativeScoreList();
		assertEquals(13, p4_scoreList.get(0).intValue());
		assertEquals(3, p4_scoreList.get(1).intValue());
		assertEquals(2, p4_scoreList.get(2).intValue());
		assertEquals(1, p4_scoreList.get(3).intValue());
		
		// Comparative List of Two Pair hand
		
		// check aabbc
		Hand twoPairHand = new Hand();
		twoPairHand.addCard("TwoHearts");
		twoPairHand.addCard("TwoClubs");
		twoPairHand.addCard("ThreeDiamonds");
		twoPairHand.addCard("ThreeSpades");
		twoPairHand.addCard("FourHearts");
		twoPairHand.calculateHandScore();
		// should return 3, 2, 4 or (2, 1, 3)
		ArrayList<Integer> tp_scoreList = twoPairHand.getComparativeScoreList();
		assertEquals(2, tp_scoreList.get(0).intValue());
		assertEquals(1, tp_scoreList.get(1).intValue());
		assertEquals(3, tp_scoreList.get(2).intValue());
		
		// check abbcc
		Hand twoPairHand2 = new Hand();
		twoPairHand2.addCard("ThreeHearts");
		twoPairHand2.addCard("ThreeClubs");
		twoPairHand2.addCard("FourDiamonds");
		twoPairHand2.addCard("FourSpades");
		twoPairHand2.addCard("TwoHearts");
		twoPairHand2.calculateHandScore();
		// should return 4, 3, 2 or (3, 2, 1)
		ArrayList<Integer> tp2_scoreList = twoPairHand2.getComparativeScoreList();
		assertEquals(3, tp2_scoreList.get(0).intValue());
		assertEquals(2, tp2_scoreList.get(1).intValue());
		assertEquals(1, tp2_scoreList.get(2).intValue());

		// check aabcc
		Hand twoPairHand3 = new Hand();
		twoPairHand3.addCard("TwoHearts");
		twoPairHand3.addCard("TwoClubs");
		twoPairHand3.addCard("KingDiamonds");
		twoPairHand3.addCard("KingSpades");
		twoPairHand3.addCard("FourHearts");
		twoPairHand3.calculateHandScore();
		// should return K, 2, 4 or (12, 1, 3)
		ArrayList<Integer> tp3_scoreList = twoPairHand3.getComparativeScoreList();
		assertEquals(12, tp3_scoreList.get(0).intValue());
		assertEquals(1, tp3_scoreList.get(1).intValue());
		assertEquals(3, tp3_scoreList.get(2).intValue());
		
		// Comparative List of Three Kind hand
		
		// check aaabc
		Hand threeKindHand = new Hand();
		threeKindHand.addCard("TwoHearts");
		threeKindHand.addCard("TwoClubs");
		threeKindHand.addCard("TwoDiamonds");
		threeKindHand.addCard("ThreeSpades");
		threeKindHand.addCard("FourHearts");
		threeKindHand.calculateHandScore();
		// should return 2, 4, 3 or (1, 3, 2)
		ArrayList<Integer> tk_scoreList = threeKindHand.getComparativeScoreList();
		assertEquals(1, tk_scoreList.get(0).intValue());
		assertEquals(3, tk_scoreList.get(1).intValue());
		assertEquals(2, tk_scoreList.get(2).intValue());
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
