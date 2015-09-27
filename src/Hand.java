
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
	
	public int isStraightFlush() {
		if(isFlush() == 1 && isStraight() == 1) return 1;
		return 0;
	}
	
	public int isFourKind() {
		// get the score of each card in a list
		ArrayList<Integer> scoreList = getSortedScoreList();
		int currentScore   = scoreList.get(0);
		int sameScoreCount = 0;
		for(int i = 1; i < scoreList.size(); ++i) {
			if(currentScore == scoreList.get(i)) {
				sameScoreCount++;
				if(sameScoreCount >= 3) {
					return 1;
				}
			} else {
				sameScoreCount = 0;
				if(i >= 2) {
					return 0;
				}
			}
			currentScore = scoreList.get(i);
		}
		return 0;
	}
	
	public int isFullHouse() {
		// get the score of each card in a list
		ArrayList<Integer> scoreList = getSortedScoreList();
		
		// check for aabbb
		if(scoreList.get(0) == scoreList.get(1) &&
		   scoreList.get(2) == scoreList.get(3) &&
		   scoreList.get(3) == scoreList.get(4)) {
			
		    return 1;
		}
		
		// check for aaabb
		if(scoreList.get(0) == scoreList.get(1) &&
		   scoreList.get(1) == scoreList.get(2) &&
		   scoreList.get(3) == scoreList.get(4)) {
			
		    return 1;
		}
		
		return 0;
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
	
	public int isStraight() {
		// get the score of each card in a list
		ArrayList<Integer> scoreList = getSortedScoreList();
		int currentScore = scoreList.get(0);
		for(int i = 1; i < scoreList.size(); ++i) {
			if(currentScore + 1 != scoreList.get(i)) {
				return 0;
			}
			currentScore = scoreList.get(i);
		}
		
		return 1;
	}
	
	public int isThreeKind() {
		// get the score of each card in a list
		ArrayList<Integer> scoreList = getSortedScoreList();
		int currentScore   = scoreList.get(0);
		int sameScoreCount = 0;
		for(int i = 1; i < scoreList.size(); ++i) {
			if(currentScore == scoreList.get(i)) {
				sameScoreCount++;
				if(sameScoreCount >= 2) {
					return 1;
				}
			} else {
				sameScoreCount = 0;
				if(i >= 3) {
					return 0;
				}
			}
			currentScore = scoreList.get(i);
		}
		return 0;
	}
	
	public int isTwoPair() {
		// get the score of each card in a list
		ArrayList<Integer> scoreList = getSortedScoreList();
		
		// check aabbc
		if(scoreList.get(0) == scoreList.get(1) && scoreList.get(2) == scoreList.get(3)) return 1;
		
		// check abbcc
		if(scoreList.get(1) == scoreList.get(2) && scoreList.get(3) == scoreList.get(4)) return 1;
		
		// check aabcc
		if(scoreList.get(0) == scoreList.get(1) && scoreList.get(3) == scoreList.get(4)) return 1;
		
		return 0;
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
