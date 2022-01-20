package assignment1;

import java.util.*;

public class PreviousGameResult {
	
	private Date date;
	private int points;
	
	public PreviousGameResult(int points) {
		this.date = new Date();
		this.points = points;
	
	}
	
	
	public String toString() {
		return "Date="+ this.date+","+"Points="+this.points;
	}

}
