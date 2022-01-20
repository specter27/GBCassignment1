package assignment1;

public class Level {

	private int levelNumber;
	private int chancesRemaining;
	private SecretWord secretword;
	private boolean debugOn;
	
	
	
	
	// stores the unmasked version of the secret word
	private String randomSecretWord;
	
	// stores the masked version of the secret word
	private StringBuffer randomSecretWordCurrentState;
	
	public Level(boolean debugOn,int levelNumber,int chancesRemaining,SecretWord secretword) {
		this.debugOn = debugOn;
		this.levelNumber = levelNumber;
		this.chancesRemaining = chancesRemaining;
		this.secretword =  secretword;
		
		this.randomSecretWord = secretword.getActualWord();
		this.randomSecretWordCurrentState = new StringBuffer(getSecretWordInitialState());
		
	}
	
	
	/*
	 * Returns a string that displays the current level number,
	 * the number of guesses remaining, and the current state of the word,
	 * in dashes (eg: L _ N D _ N). If the debugOn property = true, then the toString() 
	 * should also display the actual secret word, in plain text.
	    Example: debugOn = true, toString() outputs:
        Level 1, Chances Remaining: 4, Secret Word: L _ N D _ N, Actual Word: LONDON*/
	
	public String toString(boolean debugOrNot) {
		this.debugOn = debugOrNot;
		String re;
		if(debugOn) {
			re = "Level "+this.levelNumber+'\n'+"Chances Remaining: "+
					this.chancesRemaining+'\n'+"Secret Word: "+this.randomSecretWordCurrentState+'\n'+ "Actual Word: "+randomSecretWord;
		}else {
			re = "Level "+this.levelNumber+'\n'+"Chances Remaining: "+
					this.chancesRemaining+'\n'+"Secret Word: "+this.randomSecretWordCurrentState;
		}
		return re;
	}
	
	/*
	 *  If guessedLetter is in the secret word, update the state of the secret word and return true.
	 *  If guessedLetter is not in the secret word, reduce the number of chances remaining and return false.
	 **/
	
	public boolean checkGuess(String guessedLetter) {
		
		boolean guess=this.secretword.containsLetter(guessedLetter);
		
		if(guess) {
			
			// storing the randomSecretWordPreviousState as we are going to update it 
			String randomSecretWordPreviousState = this.randomSecretWordCurrentState.toString();
			
			// updating the #randomSecretWordCurrentState if the #guessedLetter is present in the  #randomSecretWord );
			this.randomSecretWordCurrentState.setLength(0);
			this.randomSecretWordCurrentState.append(this.secretword.toString(guessedLetter,randomSecretWordPreviousState ));
		}else {
			this.chancesRemaining = this.chancesRemaining-1;
		}
		
		return guess;
	}
	
	/*	
	 *  Returns true the player has guessed the secret word,
	 *  and false otherwise.
	 *  */
	public boolean isWordGuessed() {
		return !this.secretword.hasLettersRemaining(this.randomSecretWordCurrentState.toString());
	}
	
	public int getChancesRemaining() {
		return this.chancesRemaining;
	}
	
	//get the Initial state for the secret word private as this only used for internal processing of the Level Class
	private String getSecretWordInitialState() {
		
		StringBuffer secretWordInitialState = new StringBuffer();
		System.out.println("from Level (Class) getSecretWordInitialState()"
				+ " {Method} SECRET WORD GENERATED ="+this.randomSecretWord);
		
		for(int i=0;i<this.randomSecretWord.length();i++) {
			secretWordInitialState.append("_ ");
		}
		
		return secretWordInitialState.toString();
		
	}
	
	
	
	
	
}
