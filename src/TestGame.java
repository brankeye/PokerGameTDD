
import junit.framework.*;

public class TestGame extends TestCase {

	public TestGame(String testName) {
		super(testName);
	}
	
	public void testPlayGame() {
		Game game = new Game();
		assertEquals(1, game.playGame());
	}
}
