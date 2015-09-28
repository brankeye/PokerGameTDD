import java.util.ArrayList;

public class Deck {

	ArrayList<Card> deckOfCards;
	
	public Deck() {
		deckOfCards = new ArrayList<Card>();
	}
	
	public int addCard(Card givenCard) {
		if(deckOfCards.size() >= 52) return 0;
		for(int i = 0; i < deckOfCards.size(); ++i) {
			if(deckOfCards.get(i).getRank().equals(givenCard.getRank()) &&
			   deckOfCards.get(i).getSuit().equals(givenCard.getSuit())) {
				return 0; // duplicate card
			}
		}
		
		deckOfCards.add(givenCard);
		
		return 1;
	}

	public int hasCard(Card givenCard) {
		for(int i = 0; i < deckOfCards.size(); ++i) {
			if(deckOfCards.get(i).getRank().equals(givenCard.getRank()) &&
			   deckOfCards.get(i).getSuit().equals(givenCard.getSuit())) {
				return 1; // card is in deck
			}
		}
		return 0;
	}

}
