
public class Card {

	private String rank;
	private String suit;
	
	// parse rankSuit into separate rank and suit, then return success or failure
	public int storeRankSuit(String rankSuit) {
		String[] rs = rankSuit.split("(?=\\p{Upper})");
		
		rank = rs[0];
		suit = rs[1];
		
		return 1;
	}
}
