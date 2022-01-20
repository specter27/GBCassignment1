package assignment1;

import java.util.Random;

public class wordDB {


	
	private String[] wordList = 
		{   "Edmundston","Kingston","Brockville","Markham","Richmond","Chestermere","Kamloops","Kelowna",
			"Pickering","Peterborough","Abbotsford","Vaughan","Waterloo","Oshawa","Quesnel","Vancouver",
			"Surrey","Campbellton","Fredericton","Mississauga","Windsor","Brampton","Huntingdon","Montreal",
			"Kirkland","Joliette","Fermont","Farnham","Forestville","Clermont","Chandler","Winnipeg","Kitchener",
			"Saskatoon","Regina","Saguenay","Toronto","Shelburne","Tillsonburg"
		};


	
	public String wordGenerator() {
		
		int min = 0;
		int max = wordList.length-1;
		Random rand = new Random();

		// nextInt as provided by Random is exclusive of the top value so you need to add 1 

		int randomNum = rand.nextInt((max - min) + 1) + min;
		return wordList[randomNum].toUpperCase();
		
	}
	
	

}
