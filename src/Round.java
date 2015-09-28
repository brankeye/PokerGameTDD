
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
		roundNum = 0;
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
}
