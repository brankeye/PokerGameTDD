import java.util.ArrayList;

public class Player {

	Hand playerHand;
	
	public Player() {
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

	public ArrayList<Integer> getComparativeScoreList() { return playerHand.getComparativeScoreList(); }
}
