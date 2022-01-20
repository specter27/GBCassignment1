package assignment1;

import java.util.*;

public class gameMain {

	
	
	private static Scanner scanner = new Scanner(System.in);
	
	private static Level[] allLevels = new Level[3];
	private static ArrayList<PreviousGameResult> previousGameResultsList = new ArrayList<PreviousGameResult>();
	
	
	
	private static int gameMenu() {
		
		System.out.println(	"Enter 1: Start the game"+'\n'+
							"Enter 2: Checking result of Previous Games"+'\n'+
							"Enter 3: Exit the Game"
						  );
		String userInput = scanner.nextLine();
		//Regular Expression that will only except single digit +ve number from 1 to 3
		String regex = "[1-3]";
		
		
		//Validating the userResponse for wrong inputs
		while(userInput == null || userInput.trim().isEmpty() || !userInput.trim().matches(regex)) {
			System.out.println("***** Please Enter a Valid Input Option That Are Provided  *****");
			userInput = scanner.nextLine();
		}
	
		return Integer.parseInt(userInput);
		
	}
	
	private static boolean userResponseProcessing() {
		// Showing the Game Menu and taking userResponse
	    int userResponse = gameMenu();
		
		int chances = 7;
		int score = 0;
		boolean win = false;
		boolean exit = false;
		if(userResponse == 1) {

			for(int i=0;i<allLevels.length;i++) {
				
				//instantiating Level i
				allLevels[i] = new Level(false,(i+1),chances,new SecretWord());
				
				//Welcome message for the Level
					
				System.out.println("Welcome to Level "+(i+1)+'\n');
				if(i>0) {
					System.out.println("Current Score: "+ score+" point"+'\n');
				}
					
					
					
				
				//Starting Level i
				while( allLevels[i].getChancesRemaining()>0 ) {
					//checking if the secret word is guessed or not
					if(allLevels[i].isWordGuessed()) {
						break;
					}
					// Printing the Level i Start Information
					System.out.println(allLevels[i].toString(false));
					System.out.print("Guess a letter? ");
					
					String gussedLetter = scanner.nextLine().toUpperCase();
					System.out.println("You guessed "+gussedLetter.charAt(0));
					System.out.println(allLevels[i].checkGuess(gussedLetter) ?
							"CORRECT: "+ gussedLetter.charAt(0)+ " is in the word!"+'\n' :
								"WRONG: "+ gussedLetter.charAt(0)+ " is not in the word!"+'\n');
					
				}
				
				//Calculation the score after Level i
				score = score + allLevels[i].getChancesRemaining();
				
				//Checking weather the player has FAILED the Level i
				if( allLevels[i].getChancesRemaining()<=0 && allLevels[i].isWordGuessed() == false) {
					win = false;
					System.out.println("You LOSE at Level "+(i+1));
					break;
				}
				
				//Checking weather the player has PASSED all 3 Levels
				
				if( allLevels[i].getChancesRemaining()>0 && allLevels[i].isWordGuessed() && i == 2) {
					win = true;
				}
				
			}
			//Displaying the Game Results
			System.out.println(win ? "You WIN the Game" : "You LOSE the Game");
			System.out.println("Your Final Score: "+score+'\n');
			
			//Storing the Previous Game results in and ArrayList #previousGameResults
			previousGameResultsList.add(new PreviousGameResult(score));
			
			
			// Showing the Game Menu and taking user response
//			gameMenu();
		}
		else if(userResponse == 2) {
			if(previousGameResultsList.size() == 0) {
				System.out.println("YOU HAVEN'T PLAYED ANY GAMES YET!!");
			}
			for(PreviousGameResult currPreviousGameResult : previousGameResultsList) {
				System.out.println("GAME RESULT FOR:"+'\n'+currPreviousGameResult.toString());
			}
			
		}
		else if(userResponse == 3) {
			System.out.println("THANKS FOR PLAYING #GUESS THE WORD"+'\n'+"SEE YOU SOON :)");
			exit = true;
		}
		
		return exit;
		
	}
	
	public static void main(String[] args) {
		
		while(true) {
			boolean gameEnd = userResponseProcessing();
			if(gameEnd) {
				break;
			}
		}
		
	}

}
