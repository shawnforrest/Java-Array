package assignment4;

/**
 * 
 * @author Shawn Forrest & Aderonke Adebayo
 * @since 2020-04-17
 * @version 4.0
 * 
 */

import java.time.LocalDate;

public class Employee extends Person {
	// Default constructors
	public Employee() {
		super();
		employeeID = "----------";
		hireDate = "1000-01-01";
	}
	
	// I will modify the access to employeeID, since a child class has to modify the behavior of the setter
	protected String employeeID;
	private String hireDate;
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public boolean setEmployeeID(String employeeID) {
		if ( employeeID == null )
			return false;
		
		employeeID = employeeID.trim().replaceAll(" ", "");
		
		if ( !employeeID.matches("\\d{10}") ) // 1000000000 - 9999999999 for int types
			return false;
		
		this.employeeID = employeeID;
		return true;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public boolean setHireDate(String hireDate) {
		if ( hireDate == null )
			return false;
		
		hireDate = hireDate.trim().replaceAll(" ", "");
		
		if ( !hireDate.matches("\\d{4}-\\d{2}-\\d{2}") )
			return false;
		
		int year = Integer.parseInt(hireDate.split("-")[0]);
		int month = Integer.parseInt(hireDate.split("-")[1]);
		int day = Integer.parseInt(hireDate.split("-")[2]);
		
		LocalDate today = LocalDate.now();
		LocalDate hireday = LocalDate.of(year, month, day);
		
		if ( hireday.isAfter(today) )
			return false;
		
		this.hireDate = hireDate;
		return true;
	}
	
	public String toString() {
		String toReturn = super.toString();
		toReturn += "\nEmployee ID: " + getEmployeeID();
		toReturn += "\nHire date: " + getHireDate();
		return toReturn;
	}
}











