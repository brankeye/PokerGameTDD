
public class Card {

	private String rank;
	private String suit;
	private int    score;
	private static final String[] listOfRanks = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	private static final String[] listOfSuits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	
	public Card() {
		rank = "";
		suit = "";
		score = -1;
	}
	
	// parse rankSuit into separate rank and suit, then return success or failure
	public int storeRankSuit(String rankSuit) {
		if(!rank.equals("") || !suit.equals("")) return 0; // card already exists, cannot change its values
		
		String[] rs = rankSuit.split("(?=\\p{Upper})");
		
		// check that the number of capital delimiters found is only two
		if(rs.length != 2) {
			return 0;
		}
		
		// check for valid rank
		int validRank = 0;
		for(int i = 0; i < listOfRanks.length; ++i) {
			if(rs[0].equals(listOfRanks[i])) {
				validRank = 1;
				score = i + 1;
			}
		}
		if(validRank == 0) return 0;
		
		// check for valid suit
		int validSuit = 0;
		for(int i = 0; i < listOfSuits.length; ++i) {
			if(rs[1].equals(listOfSuits[i])) {
				validSuit = 1;
			}
		}
		if(validSuit == 0) return 0;
		
		rank = rs[0];
		suit = rs[1];
		
		return 1;
	}
	
	public String getRank()      { return rank; }
	public String getSuit()      { return suit; }
	public int    getCardScore() { return score; }
}
