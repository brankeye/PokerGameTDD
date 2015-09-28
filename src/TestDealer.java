
import junit.framework.*;

public class TestDealer extends TestCase {

	public TestDealer(String testName) {
		super(testName);
	}
	
	public void testParsePlayerID() {
		Dealer dealer = new Dealer();
		StringBuilder playerID = new StringBuilder();
		dealer.parsePlayerID(playerID, "player0 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds");
		assertEquals("player0", playerID.toString());
	}
	
	public void testParseCards() {
		Dealer dealer = new Dealer();
		Hand hand1 = new Hand();
		dealer.parsePlayerCards(hand1, "player0 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds");
		assertEquals("Two of Hearts, Three of Hearts, King of Clubs, Queen of Clubs, Five of Diamonds.", hand1.getCardNameString());
	
		Hand hand2 = new Hand();
		int r = dealer.parsePlayerCards(hand2, "player0 TwoHearts"); // one too many cards
		assertEquals(0, r);
	}
}
