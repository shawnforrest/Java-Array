package assignment4;

/**
 * 
 * @author Shawn Forrest & Aderonke Adebayo
 * @since 2020-04-17
 * @version 4.0
 * 
 */

import java.text.DecimalFormat;

public class OTCDrug extends Medicine {
	public OTCDrug() {
		super();
		cost = -1;
		composition = "Not known";
	}
	
	private double cost;
	private String composition;
	
	public double getCost() {
		return cost;
	}
	
	public boolean setCost(double cost) {
		if ( cost < 0d )
			return false;
		
		this.cost = cost;
		return true;
	}
	
	public String getComposition() {
		return composition;
	}
	
	public boolean setComposition(String composition) {
		if ( composition == null )
			return false;
		
		composition = composition.trim().replaceAll(" +", " ");
		
		if ( composition.length() < 2 || composition.length() > 100 )
			return false;
		
		if ( !composition.matches("[A-Za-z\\'\\-\\ ]+"))
			return false;
		
		this.composition = composition;
		return true;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nCost: $" + new DecimalFormat("#.00").format(getCost());
		toReturn += "\nComposition: " + getComposition();
		return toReturn;
	}
}
