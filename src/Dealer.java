import java.util.Arrays;

public class Dealer {

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
