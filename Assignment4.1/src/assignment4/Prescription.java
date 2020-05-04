package assignment4;

/**
 * 
 * @author Shawn Forrest & Aderonke Adebayo
 * @since 2020-04-17
 * @version 4.0
 */

public class Prescription extends Medicine {
	public Prescription() {
		super();
		prescriptionID = "Not known";
		prescriberID = "Not known";
	}
	
	private String prescriptionID;
	private String prescriberID;
	
	public String getPrescriptionID() {
		return prescriptionID;
	}
	
	public boolean setPrescriptionID(String prescriptionID) {
		if ( prescriptionID == null )
			return false;
		
		prescriptionID = prescriptionID.trim().replaceAll(" ", "");
		
		if ( !prescriptionID.matches("\\d{7}") )
			return false;
		
		this.prescriptionID = prescriptionID;
		return true;
	}
	
	public String getPrescriberID() {
		return prescriberID;
	}
	
	public boolean setPrescriberID(String prescriberID) {
		if ( prescriberID == null )
			return false;
		
		prescriberID = prescriberID.trim().replaceAll(" ", "");
		
		// Make sure the prescriber ID has an MD or RN in front of the 8 digit prescriber ID.
		if ( !prescriberID.matches("MD\\d{8}") )
			return false;
		
		if ( !prescriberID.matches("RN\\d{8}"))
			return false;
		
		this.prescriberID = prescriberID;
		return true;
		
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nPrescription ID: " + getPrescriptionID();
		toReturn += "\nID of the prescriber: " + getPrescriberID();
		return toReturn;
	}
}
