
import java.util.ArrayList;

import junit.framework.*;

public class TestDealer extends TestCase {

	public TestDealer(String testName) {
		super(testName);
	}
	
	public void testDealHand() {
		Dealer dealer = new Dealer();
		ArrayList<Player> newPlayerList = new ArrayList<Player>(0);
		newPlayerList.add(new Player(0));
		newPlayerList.add(new Player(1));
		int result = dealer.dealHand("player0 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds", newPlayerList);
		assertEquals(1, result);
		// dupes fail
		int result1 = dealer.dealHand("player1 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds", newPlayerList);
		assertEquals(0, result1);
		
		ArrayList<Player> newPlayerList2 = new ArrayList<Player>(0);
		newPlayerList2.add(new Player(0));
		newPlayerList2.add(new Player(1));
		int result2 = dealer.dealHand("player0 TwoHeartsssssss ThreeHearts KingClubs QueenClubs FiveDiamonds", newPlayerList2);
		assertEquals(0, result2);
		
		ArrayList<Player> newPlayerList3 = new ArrayList<Player>(0);
		newPlayerList3.add(new Player(0));
		newPlayerList3.add(new Player(1));
		int result3 = dealer.dealHand("player3 TwoHearts ThreeHearts KingClubs QueenClubs FiveDiamonds", newPlayerList3);
		
		assertEquals(0, result3);
		
		ArrayList<Player> newPlayerList4 = new ArrayList<Player>(0);
		newPlayerList4.add(new Player(0));
		newPlayerList4.add(new Player(1));
		int result4 = dealer.dealHand("player0 ThreeHearts KingClubs QueenClubs FiveDiamonds", newPlayerList4);
		assertEquals(0, result4);
	}
	
	public void testWithinDeck() {
		Dealer dealer = new Dealer();
		Hand hand = new Hand();
		hand.addCard("TwoHearts");
		hand.addCard("ThreeHearts");
		hand.addCard("FourHearts");
		hand.addCard("FiveHearts");
		hand.addCard("SixHearts");
		assertEquals(0, dealer.withinDeck(hand));
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
