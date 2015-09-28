
import java.util.ArrayList;
import java.util.Scanner;

public class Round {
	
	ArrayList<Player> playerList;
	private static Scanner scanner;
	private int numPlayers;
	private static int roundNum;
	
	public Round() {
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
    	
    	System.out.println("There are " + numPlayers + " players in this round.");
    	
    	return 1;
	}

	public int createPlayers(int nPlayers) {
		for(int i = 0; i < nPlayers; ++i) {
			playerList.add(new Player());
		}
		return playerList.size();
	}

}
