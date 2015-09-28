
import java.util.ArrayList;
import java.util.Scanner;

public class Round {
	
	Dealer dealer;
	ArrayList<Player> playerList;
	private static Scanner scanner;
	private int numPlayers;
	private static int roundNum;
	
	public Round() {
		dealer = new Dealer();
		playerList = new ArrayList<Player>(0);
		scanner = new Scanner(System.in);
		numPlayers = 0;
		roundNum = 1;
	}
	
	public int playRound() {
		System.out.println("Now playing Round " + roundNum++);
		if(promptNumberOfPlayers() == 0) return 0; 
		if(promptPlayerHands() == 0) return 0;
		if(determineWinner() == 0) return 0;
		
		String userInput = "";
		System.out.println("Would you like to play again? (y/n): ");
		do {
			while(!scanner.hasNextLine()) {
				scanner.next();
				System.out.println("Incorrect input, only (y/n).");
			}
			userInput = scanner.nextLine();
		} while(!userInput.equals("y") && !userInput.equals("n"));
		
		if(userInput.equals("y")) return 1;
		
		return 0;
	}

	public int promptNumberOfPlayers() {
		// get the number of players in this round
    	do {
    		System.out.println("How many players? (2-4): ");
    		while(!scanner.hasNextInt()) {
    			System.out.println("Incorrect input, only integers allowed.");
    			scanner.next();
    		}
    		numPlayers = scanner.nextInt(); //scanner.nextLine(); // blank nextLine to capture newline character leftover
    		
    		if(numPlayers < 2 || numPlayers > 4) {
    			System.out.println("Only 2 to 4 players is allowed.");
    		}
    		
    	} while(numPlayers < 2 || numPlayers > 4);
    	scanner.nextLine(); // blank nextLine to capture newline character leftover
    	
    	createPlayers();
    	System.out.println("There are " + numPlayers + " players in this round.");
    	System.out.println("Here are the player IDs:");
    	for(int k = 0; k < playerList.size(); ++k) {
    		System.out.println(playerList.get(k).getPlayerName());
    	}
    	
    	return 1;
	}
	
	public int promptPlayerHands() {
		// request player hands
    	int handsDealt = 0;
    	String userInput = "";
    	System.out.println("Enter a player's cards by the format 'PlayerID RankSuit RankSuit RankSuit RankSuit RankSuit'");
    	do {
    		while(!scanner.hasNextLine()) {
    			scanner.next();
    		}
    		userInput = scanner.nextLine();
    		if(dealer.dealHand(userInput, playerList) == 1) {
    			System.out.println("Cards dealt successfully.");
    			handsDealt++;
    		} else {
    			System.out.println("Invalid input.");
    		}
    	} while(handsDealt < numPlayers);
    	return 1;
	}

	private int createPlayers() {
		for(int i = 0; i < numPlayers; ++i) {
			playerList.add(new Player(i));
		}
		return playerList.size();
	}
	
	public ArrayList<String> getPlayerNames() {
		ArrayList<String> names = new ArrayList<String>(0);
		for(int i = 0; i < numPlayers; ++i) {
			names.add(playerList.get(i).getPlayerName());
		}
		return names;
	}

	public int determineWinner() {
		System.out.println("THE LEADERBOARD");
		int[] winList = new int[playerList.size()];
		
		for(int i = 0; i < playerList.size(); ++i) {
			winList[i] = 1; // current players rank in leaderboards
			for(int k = 0; k < playerList.size(); ++k) {
				if(k != i) {
					if(playerList.get(i).getHandScore() < playerList.get(k).getHandScore()) {
						winList[i]++;
					} else if(playerList.get(i).getHandScore() == playerList.get(k).getHandScore()) {
						ArrayList<Integer> cList_A = playerList.get(i).getComparativeScoreList();
						ArrayList<Integer> cList_B = playerList.get(k).getComparativeScoreList();
						for(int j = 0; j < cList_A.size(); ++j) {
							if(cList_A.get(j).intValue() < cList_B.get(j).intValue()) {
								winList[i]++;
								break;
							}
							//if(j == cList_A.size() - 1) winList[i]--; 
						}
					}
				}
			}
		}
	
		for(int i = 0; i < playerList.size(); ++i) {
			System.out.println("Ranked " + winList[i] + ": " + playerList.get(i).getPlayerName() + " with a " + playerList.get(i).getHandName());
		}
		
		return 1;
	}
}
