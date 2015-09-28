
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
}
