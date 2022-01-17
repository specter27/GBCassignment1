package assignment1;

import java.util.Random;

public class wordDB {


	
	private String[] wordList = 
		{"Edmundston","Kingston","Brockville","Markham",
				"Pickering","Peterborough","Abbotsford","Vaughan","Waterloo","Oshawa"};
	
	private int min = 0;
	private int max = wordList.length-1;
	
	
	public wordDB() {
		
	}
	
	public String wordGenerator() {
		Random rand = new Random();

		// nextInt as provided by Random is exclusive of the top value so you need to add 1 

		int randomNum = rand.nextInt((max - min) + 1) + min;
		return wordList[randomNum];
		
	}
	
	

}
