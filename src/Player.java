
public class Player {

	Hand playerHand;
	
	public Player() {
		playerHand = new Hand();
	}
	
	public String getHandName() { return playerHand.getHandName(); }
}
