
import junit.framework.*;

public class TestRound extends TestCase {

	public TestRound(String testName) {
		super(testName);
	}
	
	public void testPromptNumberOfPlayers() {
		Round round1 = new Round();
		assertEquals(1, round1.promptNumberOfPlayers());
	}
}
