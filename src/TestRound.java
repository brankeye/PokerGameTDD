
import java.util.ArrayList;

import junit.framework.*;

public class TestRound extends TestCase {

	public TestRound(String testName) {
		super(testName);
	}
	
	public void testPromptNumberOfPlayers() {
		Round round1 = new Round();
		assertEquals(1, round1.promptNumberOfPlayers());
	}
	
	public void testPromptPlayerHands() {
		Round round1 = new Round();
		round1.promptNumberOfPlayers();
		assertEquals(1, round1.promptPlayerHands());
	}
	
	public void testCreatePlayers() {
		//Round round1 = new Round();
		//round1.promptNumberOfPlayers();
		//assertEquals(2, round1.createPlayers());
	}
	
	public void testGetPlayerName() {
		//Round round1 = new Round();
		//round1.promptNumberOfPlayers();
		//round1.createPlayers();
		//ArrayList<String> names = round1.getPlayerNames();
		//assertEquals("player0", names.get(0));
	}
}
