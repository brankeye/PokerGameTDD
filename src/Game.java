
public class Game {

	public int playGame() {
		int result = 0;
		do {
			Round newRound = new Round();
			result = newRound.playRound();
		} while(result == 1);

		return 0;
	}

}
