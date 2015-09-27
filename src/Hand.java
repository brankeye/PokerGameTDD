
import java.util.ArrayList;

public class Hand {
	
	private static final int maxCards = 5;
	private ArrayList<Card> listOfCards;
	
	public Hand() {
		listOfCards = new ArrayList<Card>(0);
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
}
