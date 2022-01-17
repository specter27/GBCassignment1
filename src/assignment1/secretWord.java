package assignment1;

public class secretWord {
	
	private String actualWord;
	
	private wordDB randomWord = new wordDB();
	
	//constructor
	public secretWord() {
	    this.actualWord = randomWord.wordGenerator();  // Set the initial value for the class attribute actualWord
	  }
	
	public boolean containsLetter(String letter) {
		return true;	
	}

	public String getActualWord() {
		return actualWord;
	}


}
