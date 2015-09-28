
import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	
	private ArrayList<Card> listOfCards;
	private ArrayList<Integer> comparativeScoreList;
	private String          handName;
	private int             score;
	private static final int maxCards = 5;
	private enum Hands {
	    highCard ("High Card"),
	    pair ("Pair"),
	    twoPair ("Two Pair"),
	    threeKind ("Three of a Kind"),
	    straight ("Straight"),
	    flush ("Flush"),
	    fullHouse ("Full House"),
	    fourKind ("Four of a Kind"),
	    straightFlush ("Straight Flush"),
	    royalFlush ("Royal Flush");

	    private final String name;       

	    private Hands(String s) {
	        name = s;
	    }

	    public boolean equalsName(String otherName) {
	        return (otherName == null) ? false : name.equals(otherName);
	    }

	    public String toString() {
	       return this.name;
	    }
	}
	
	public Hand() {
		listOfCards = new ArrayList<Card>(0);
		comparativeScoreList = new ArrayList<Integer>(0);
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
		if(listOfCards.size() == 5) {
			calculateHandScore();
		}
		return 1;
	}
	
	/* Poker Hand Scoring
	 * 10 - Royal Flush
	 * 9  - Straight Flush
	 * 8  - Four Kind
	 * 7  - Full House
	 * 6  - Flush
	 * 5  - Straight
	 * 4  - Three Kind
	 * 3  - Two Pair
	 * 2  - Pair
	 * 1  - High Card
	 */
	public int calculateHandScore() {
		if(score != -1) { return score; }
		if(isRoyalFlush() == 1) {
			handName = Hands.royalFlush.toString();
			score = 10;
		} else if(isStraightFlush() == 1) {
			handName = Hands.straightFlush.toString();
			score = 9;
		} else if(isFourKind() == 1) {
			handName = Hands.fourKind.toString();
			score = 8;
		} else if(isFullHouse() == 1) {
			handName = Hands.fullHouse.toString();
			score = 7;
		} else if(isFlush() == 1) {
			handName = Hands.flush.toString();
			score = 6;
		} else if(isStraight() == 1) {
			handName = Hands.straight.toString();
			score = 5;
		} else if(isThreeKind() == 1) {
			handName = Hands.threeKind.toString();
			score = 4;
		} else if(isTwoPair() == 1) {
			handName = Hands.twoPair.toString();
			score = 3;
		} else if(isPair() == 1) {
			handName = Hands.pair.toString();
			score = 2;
		} else {
			handName = Hands.highCard.toString();
			score = 1;
			comparativeScoreList = getReverseScoreList();
		}
		return score;
	}
	
	public int isRoyalFlush() {
		if(isStraight() == 1 && isFlush() == 1 && getHighCardScore() == 13) return 1;
		return 0;
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
					comparativeScoreList.add(currentScore);
					for(int k = scoreList.size() - 1; k >= 0; --k) {
						if(scoreList.get(k) != currentScore) {
							comparativeScoreList.add(scoreList.get(k));
						}
					}
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
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(0));
		    return 1;
		}
		
		// check for aaabb
		if(scoreList.get(0) == scoreList.get(1) &&
		   scoreList.get(1) == scoreList.get(2) &&
		   scoreList.get(3) == scoreList.get(4)) {
			comparativeScoreList.add(scoreList.get(0));
			comparativeScoreList.add(scoreList.get(4));
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
		comparativeScoreList = getReverseScoreList();
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
		comparativeScoreList = getReverseScoreList();
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
					comparativeScoreList.add(currentScore);
					for(int k = scoreList.size() - 1; k >= 0; --k) {
						if(scoreList.get(k) != currentScore) {
							comparativeScoreList.add(scoreList.get(k));
						}
					}
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
		if(scoreList.get(0) == scoreList.get(1) && scoreList.get(2) == scoreList.get(3)) {
			comparativeScoreList.add(scoreList.get(2));
			comparativeScoreList.add(scoreList.get(0));
			comparativeScoreList.add(scoreList.get(4));
			return 1;
		}
		
		// check abbcc
		if(scoreList.get(1) == scoreList.get(2) && scoreList.get(3) == scoreList.get(4)) {
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(2));
			comparativeScoreList.add(scoreList.get(0));
			return 1;
		}
		
		// check aabcc
		if(scoreList.get(0) == scoreList.get(1) && scoreList.get(3) == scoreList.get(4)) {
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(0));
			comparativeScoreList.add(scoreList.get(2));
			return 1;
		}
		
		return 0;
	}
	
	public int isPair() {
		// get the score of each card in a list
		ArrayList<Integer> scoreList = getSortedScoreList();
		
		// check aabcd
		if(scoreList.get(0) == scoreList.get(1)) {
			comparativeScoreList.add(scoreList.get(0));
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(3));
			comparativeScoreList.add(scoreList.get(2));
			return 1;
		}
		
		// check abbcd
		if(scoreList.get(1) == scoreList.get(2)) {
			comparativeScoreList.add(scoreList.get(2));
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(3));
			comparativeScoreList.add(scoreList.get(0));
			return 1;
		}
		
		// check abccd
		if(scoreList.get(2) == scoreList.get(3)) {
			comparativeScoreList.add(scoreList.get(2));
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(1));
			comparativeScoreList.add(scoreList.get(0));
			return 1;
		}
		
		// check abcdd
		if(scoreList.get(3) == scoreList.get(4)) {
			comparativeScoreList.add(scoreList.get(4));
			comparativeScoreList.add(scoreList.get(2));
			comparativeScoreList.add(scoreList.get(1));
			comparativeScoreList.add(scoreList.get(0));
			return 1;
		}
		
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
	
	public ArrayList<Integer> getReverseScoreList() {
		ArrayList<Integer> scoreList = new ArrayList<Integer>();
		for(int i = 0; i < listOfCards.size(); ++i) {
			scoreList.add(listOfCards.get(i).getCardScore());
		}
		Collections.sort(scoreList);
		Collections.reverse(scoreList);
		return scoreList;
	}
	
	public ArrayList<Integer> getComparativeScoreList() { return comparativeScoreList; }
	
	public int getHighCardScore() {
		ArrayList<Integer> scoreList = getSortedScoreList();
		return scoreList.get(scoreList.size() - 1);
	}
	public int    getHandScore()   { return score; }
	public String getHandName()    { return handName; }
	
	public String getCardNameString() {
		String cardNames = "";
		for(int i = 0; i < listOfCards.size(); ++i) {
			cardNames += listOfCards.get(i).getRank() + " of " + listOfCards.get(i).getSuit();
			if(i < listOfCards.size() - 1) {
				cardNames += ", ";
			}
		}
		cardNames += ".";
		return cardNames;
	}

	public int getCardList(ArrayList<Card> cardList) {
		
		return 1;
	}
}
