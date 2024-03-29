import java.util.ArrayList;
import java.util.Arrays;

public class Dealer {
	
	Deck deck;
	
	public Dealer() {
		deck = new Deck();
	}

	public int dealHand(String data, ArrayList<Player> playerList) {
		// parse hand to be dealt
		StringBuilder player_id = new StringBuilder(); 
		if(parsePlayerID(player_id, data) == 0) return 0;
		
		Hand   player_hand = new Hand();
		if(parsePlayerCards(player_hand, data) == 0) return 0;
		
		if(withinDeck(player_hand) == 1) return 0;
		
		// then deal the player the cards
		for(int i = 0; i < playerList.size(); ++i) {
			if(playerList.get(i).getPlayerName().compareTo(player_id.toString()) == 0) {
				if(playerList.get(i).giveHand(player_hand) == 0) return 0;
				for(int k = 0; k < player_hand.getCardList().size(); ++k) {
					deck.addCard(player_hand.getCardList().get(k));
				}
				return 1;
			}
		}
		return 0; // 0 fail, 1 success
	}
	
	public int withinDeck(Hand hand) {
		ArrayList<Card> cList = hand.getCardList();
		for(int i = 0; i < cList.size(); ++i) {
			if(withinDeck(cList.get(i)) == 1) return 1; 
		}
		
		return 0;
	}
	
	public int withinDeck(Card givenCard) {
		if(deck.hasCard(givenCard) == 1) return 1;
		return 0;
	}
	
	public int parsePlayerID(StringBuilder name, String data) {
		String delims = "[ ]+";
		String[] parsed = data.split(delims);
		if(parsed.length != 6) return 0;
		name.append(parsed[0]);
		return 1;
	}

	public int parsePlayerCards(Hand newHand, String data) {
		String delims = "[ ]+";
		String[] parsed = data.split(delims);
		if(parsed.length != 6) return 0;
		String[] cards = Arrays.copyOfRange(parsed, 1, 6);
		
		for(int i = 0; i < cards.length; ++i) {
			newHand.addCard(cards[i]);
		}
		return 1;
	}
}
