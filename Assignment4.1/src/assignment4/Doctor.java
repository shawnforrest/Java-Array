package assignment4;

/**
 * 
 * @author Shawn Forrest & Aderonke Adebayo
 * @since 2020-04-17
 * @version 4.0
 * 
 */

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Doctor extends Employee {
	// Default constructors
	public Doctor() {
		super();
		specialty = "---";
		canOperate = false;
	}
	
	private String specialty;
	private boolean canOperate;
	
	// Override method to place an MD infront of employee ID
	public boolean setEmployeeID(String employeeID) {
		if ( employeeID == null )
			return false;
		
		employeeID = employeeID.trim().replaceAll(" ", "");
		
		if ( !employeeID.matches("MD\\d{8}") ) // MD followed by 8 integers
			return false;
		
		super.employeeID = employeeID;
		return true;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	// setSpecialty uses a json file to look for the doctors specialty
	public boolean setSpecialty(String specialty) {
		if ( specialty == null )
			return false;
		
		specialty = specialty.trim().replaceAll(" +", " ");
		
		try {
			// The JSON file should be in the 'src' folder of your project.
			JSONArray specialties = (JSONArray) (new JSONParser()).parse(new FileReader("src/specialties.json"));
			for ( Object spec : specialties ) {
				String specialtyName = (String)((JSONObject)spec).get("Specialty");
				if (specialty.equalsIgnoreCase(specialtyName)) {
					this.specialty = specialty;
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean canOperate() {
		return canOperate;
	}
	
	public void setCanOperate(boolean canOperate) {
		this.canOperate = canOperate;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nSpecialty: " + getSpecialty();
		toReturn += "\nThis doctor can" + (canOperate()?"":"not") + " perform surgery";
		return toReturn;
	}
}
