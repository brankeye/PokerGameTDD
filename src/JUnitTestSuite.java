import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCard.class, TestDealer.class, TestDeck.class, TestGame.class, TestHand.class, TestPlayer.class,
		TestRound.class })
public class JUnitTestSuite {

}
