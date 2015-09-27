
import java.util.ArrayList;

import junit.framework.*;

public class TestPlayer extends TestCase {
	
	public TestPlayer(String testName) {
		super(testName);
	}
	
	public void testGivePlayerHand() {
		Player player1 = new Player();
		Hand flushHand = new Hand();
		assertEquals(0, player1.giveHand(flushHand));
		// check for a flush
		flushHand.addCard("TwoHearts");
		flushHand.addCard("ThreeHearts");
		flushHand.addCard("KingHearts");
		flushHand.addCard("QueenHearts");
		flushHand.addCard("FourHearts");
		assertEquals(1, player1.giveHand(flushHand));
	}
	
	public void testGetPlayerHandName() {
		Player player1 = new Player();
		Hand flushHand = new Hand();
		// check for a flush
		flushHand.addCard("TwoHearts");
		flushHand.addCard("ThreeHearts");
		flushHand.addCard("KingHearts");
		flushHand.addCard("QueenHearts");
		flushHand.addCard("FourHearts");
		player1.giveHand(flushHand);
		assertEquals("Flush", player1.getHandName());
	}
	
	public void testGetPlayerScore() {
		Player player1 = new Player();
		Hand flushHand = new Hand();
		// check for a flush
		flushHand.addCard("TwoHearts");
		flushHand.addCard("ThreeHearts");
		flushHand.addCard("KingHearts");
		flushHand.addCard("QueenHearts");
		flushHand.addCard("FourHearts");
		player1.giveHand(flushHand);
		assertEquals(6, player1.getHandScore());
	}
	
	public void testGetPlayerComparativeScoreList() {
		Player player1 = new Player();
		Hand flushHand = new Hand();
		// check for a flush
		flushHand.addCard("TwoHearts");
		flushHand.addCard("ThreeHearts");
		flushHand.addCard("KingHearts");
		flushHand.addCard("QueenHearts");
		flushHand.addCard("FourHearts");
		player1.giveHand(flushHand);
		ArrayList<Integer> csList = player1.getComparativeScoreList();
		assertEquals(12, csList.get(0).intValue());
		assertEquals(11, csList.get(1).intValue());
		assertEquals(3, csList.get(2).intValue());
		assertEquals(2, csList.get(3).intValue());
		assertEquals(1, csList.get(4).intValue());
	}
}
