
import junit.framework.*;

public class TestDealer extends TestCase {

	public TestDealer(String testName) {
		super(testName);
	}
	
	public void testParsePlayerID() {
		Dealer dealer = new Dealer();
		String pid = dealer.parsePlayerID("player0 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds");
		assertEquals("player0", pid);
	}
	
	public void testParseCards() {
		Dealer dealer = new Dealer();
		Hand cards = dealer.parsePlayerCards("player0 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds");
		assertEquals("TwoHearts, ThreeHearts, KingClubs, QueenClubs, FiveDiamonds.", cards.getCardNameString());
	}
}
