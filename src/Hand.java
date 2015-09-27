
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private ArrayList<Card> listOfCards;
	private String          handName;
	private int             score;
	private static final int maxCards = 5;
	
	public Hand() {
		listOfCards = new ArrayList<Card>(0);
		handName = "";
		score = -1;
	}

	public int addCard(String rankSuit) {
		if(listOfCards.size() == maxCards) return 0; // five cards in hand, cannot add more
		
		Card givenCard = new Card();
		if (givenCard.storeRankSuit(rankSuit) == 0) return 0; // rank and suit incorrect, add card failed
		
		// check for duplicates in hand
		for(int i = 0; i < listOfCards.size(); ++i) {
			if( givenCard.getRank().equals(listOfCards.get(i).getRank()) &&
				givenCard.getSuit().equals(listOfCards.get(i).getSuit())) {
				return 0;
			}
		}
		
		listOfCards.add(givenCard);
		return 1;
	}
	
	public int isFlush() {
		String theSuit = listOfCards.get(0).getSuit();
		for(int i = 1; i < listOfCards.size(); ++i) {
			if(theSuit.equals(listOfCards.get(i).getSuit()) == false) {
				return 0;
			}
			theSuit = listOfCards.get(i).getSuit();
		}
		return 1;
	}
	
	public ArrayList<Integer> getSortedScoreList() {
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		for(int i = 0; i < listOfCards.size(); ++i) {
			scoreList.add(listOfCards.get(i).getCardScore());
		}
		Collections.sort(scoreList);
		return scoreList;
	}
	
	public int    getHandScore()   { return score; }
	public String getHandName()    { return handName; }
}
