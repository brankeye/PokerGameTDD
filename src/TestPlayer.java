
import junit.framework.*;

public class TestPlayer extends TestCase {
	
	public TestPlayer(String testName) {
		super(testName);
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
		assertEquals("", player1.getHandName());
	}
}
