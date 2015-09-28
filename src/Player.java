import java.util.ArrayList;

public class Player {

	private String name;
	private Hand   playerHand;
	
	public Player(int id) {
		name = "player" + String.valueOf(id);
		playerHand = new Hand();
	}
	
	public String getHandName() { return playerHand.getHandName(); }

	public int giveHand(Hand flushHand) {
		if(playerHand.getHandScore() != -1) return 0; // player was already given a hand
		if(flushHand.getHandScore() == -1) return 0; // the hand is empty
		playerHand = flushHand;
		return 1;
	}

	public int getHandScore() {
		return playerHand.getHandScore();
	}

	public String getPlayerName() { return name; }
	public String getHandString() { return playerHand.getCardNameString(); }
	public ArrayList<Integer> getComparativeScoreList() { return playerHand.getComparativeScoreList(); }
}
