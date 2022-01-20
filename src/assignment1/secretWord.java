package assignment1;

public class SecretWord {
	
	private String actualWord;
	
	
	public SecretWord() {
		// Set the initial value for the class attribute actualWord
		wordDB randomWord = new wordDB();
	    this.actualWord = randomWord.wordGenerator();
	  }
	
	

	public String getActualWord() {
		return actualWord;
	}
	
//	Returns true if letter is in the secret word, and false otherwise
	public boolean containsLetter(String gussedLetter) {
		return this.actualWord.contains(gussedLetter);	
	}
//	Returns true if there are still letters that need to be guessed.
	public boolean hasLettersRemaining(String currentWord) {
		return currentWord.contains("_");	
	}
	
//	Returns a string that represents the current state of the word
	public String toString(String gussedLetter ,String currentWord)  {
		StringBuffer sb = new StringBuffer(currentWord);
		for(int i=0;i<this.actualWord.length();i++) {
			if(this.actualWord.charAt(i) == gussedLetter.charAt(0)) {
				int k=i*2;
				sb.replace(k, k+1, gussedLetter);
			}
		}
		return sb.toString();	
	}


}
