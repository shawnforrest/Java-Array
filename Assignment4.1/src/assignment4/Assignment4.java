package assignment4;

/**
 * 
 * @author Shawn Forrest & Aderonke Adebayo
 * @since 2020-04-17
 * @version 4.0
 *
 * For assignment4 we have created Arrays of type Person and Medicine and other classes that
 * inherit directly and indirectly from the Classes and asked the user to input the size of 
 * the arrays.  The user input all the values into the arrays and after the program will output
 * the arrays.
 */

import java.util.Scanner;

public class Assignment4 {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);

        // Create a try-catch block to make sure the user enters a number for how many objects to create.
		int personNumber = 0;
		boolean valid = false;
		while (!valid) {
			System.out.println("How many Person objects would you like to create: ");
			try {
				//Array of person to store as many objects of base type Person as the user wants
				// personNumber variable will set the size of the array
				personNumber = Integer.parseInt(userInput.nextLine());
				valid = true;
			}catch (NumberFormatException nfe) {
				System.out.println("Please enter a number!");
			}
		}	
		/**
		 * Create an array called personBaseTypeArray with the size of personNumber from the
		 * user's input.
		 * Then create a for-loop to loop through the array asking for user input for as
		 * many objects the user wants to create.
		 */
        Person personBaseTypeArray[]=new Person[personNumber];
        
       
        
        for(int i=0;i<personNumber;i++)
        {
        	// Create a descending menu for the user to pick which object that they would
        	// like to create that inherits directly or indirectly with type Person object.
            System.out.println("Please choose which type of object you'd like to create.");
            System.out.println("1) Person\n2) Employee\n3) Doctor\n4) Nurse\n5) Patient");

            int choice = 0;
            valid = false;
            while (!valid) {
                System.out.print("Choice: ");
                // try-catch handling to make sure the user picks an Integer from the menu above.
                try {
                    choice = Integer.parseInt(userInput.nextLine());
                    valid = true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a number");
                }
                System.out.println("-------------------");
            }
            // switch statement depending on the user's input choice to execute the case or
            // default if the input is invalid.
            switch(choice) {
                case 1: // Person
                    Person p = new Person();
                    getPersonInformation(p, userInput);
                    System.out.println("-------------------");
                    personBaseTypeArray[i]=p;
                    break;
                case 2: // Employee
                    Employee e = new Employee();
                    getEmployeeInformation(e, userInput);
                    System.out.println("-------------------");
                    personBaseTypeArray[i]=e;
                    break;
                case 3: // Doctor
                    Doctor d = new Doctor();
                    getDoctorInformation(d, userInput);
                    System.out.println("-------------------");
                    personBaseTypeArray[i]=d;

                    break;
                case 4: // Nurse
                    Nurse n = new Nurse();
                    getNurseInformation(n, userInput);
                    System.out.println("-------------------");
                    personBaseTypeArray[i]=n;

                    break;
                case 5: // Patient
                    Patient pt = new Patient();
                    getPatientInformation(pt, userInput);
                    System.out.println("-------------------");
                    personBaseTypeArray[i]=pt;

                    break;
                default:
                    System.out.println("The input is not valid.");
            }
        }
        

        /**
         * Create an array of type Medicine object or objects that inherit directly or 
         * indirectly from type Medicine object.
         */
        
        // Create a try-catch block to make sure the user enter's a number for objects to create.
        int medNumber = 0;
        valid = false;
        while (!valid) {
        	System.out.println("How many Medicine objects would you like to create: ");
        	try {
        		// Create medNumber variable to ask the user how many objects they would like to create
        		medNumber = Integer.parseInt(userInput.nextLine());
        		valid = true;
        	}catch (NumberFormatException nfe) {
        		System.out.println("Please enter a number!");
        	}
        }
		
        // Array named medicineBaseArray with medNumber for the number of times to loop through the Array.
        Medicine medicineBaseArray []=new Medicine[medNumber];
        // Create a for-loop to loop through the array asking for user input.
        for(int i=0;i<medNumber;i++)
        {
            System.out.println("Please choose which type of object you'd like to create.");
            System.out.println("1) Medicine\n2) OTC Drug\n3) Controlled OTC Drug\n4) Prescription");

            int choice = 0;
            valid = false;
            while (!valid) {
                System.out.print("Choice: ");
                try {
                    choice = Integer.parseInt(userInput.nextLine());
                    valid = true;
                } catch (NumberFormatException nfe) {
                    System.out.println("Please enter a number");
                }
                System.out.println("-------------------");
            }

            switch(choice) {
                case 1: // Medicine
                    Medicine m = new Medicine();
                    getMedicineInformation(m, userInput);
                    System.out.println("-------------------");
                    medicineBaseArray[i]=m;
                    break;
                case 2: // OTC Drug
                    OTCDrug otc = new OTCDrug();
                    getOTCDrugInformation(otc, userInput);
                    System.out.println("-------------------");
                    medicineBaseArray[i]=otc;
                    break;
                case 3: // Controlled drug
                    Controlled cd = new Controlled();
                    getControlledInformation(cd, userInput);
                    System.out.println("-------------------");
                    medicineBaseArray[i]=cd;
                    break;
                case 4: // Prescription
                    Prescription pd = new Prescription();
                    getPrescriptionInformation(pd, userInput);
                    System.out.println("-------------------");
                    medicineBaseArray[i]=pd;
                    break;
                default:
                    System.out.println("The input is not valid.");
            }
        }
        
        /**
         * For-loop to print out all of the objects of type Person objects or inherited from
         * user's input.
         */
        System.out.println("Your Entered Data For Person Base Class\n\n");
        for(int i=0;i<personNumber;i++)
        {
            System.out.println(personBaseTypeArray[i]);
            System.out.println("-------------------");
        }
        /**
         * For-loop to print out all the objects created by the user for type Medicine or 
         * inherited directly or indirectly.
         */
        System.out.println("\n\nYour Entered DataFor Medicine Base Class :\n\n");
        for(int i=0;i<medNumber;i++)
        {
            System.out.println(medicineBaseArray[i]);
            System.out.println("-------------------");
        }

        userInput.close();
    }

    public static void getPrescriptionInformation(Prescription p, Scanner userInput) {
        getMedicineInformation(p, userInput);
        // Get the prescription ID
        System.out.print("7-digit ID of the prescription: ");
		p.setPrescriptionID(userInput.nextLine());
		// Get the prescriber ID but it has to have an MD or RN infront
		System.out.print("10-digit ID of the prescriber: ");
		p.setPrescriberID(userInput.nextLine());
        

        
        
    }

    public static void getControlledInformation(Controlled c, Scanner userInput) {
        getOTCDrugInformation(c, userInput);
        // Ask if patient needs to show ID to purchase drug.
        System.out.print("The patient needs to show an ID to purchase this drug (y-yes, n-no): ");
        char choice = userInput.nextLine().toLowerCase().charAt(0);
        if ( choice == 'y' )
            c.setRequiresID(true);
        else
            c.setRequiresID(false);
        // Ask if patient needs signature to purchase drug.
        System.out.print("The patient needs to sign to purchase this drug (y-yes, n-no): ");
        choice = userInput.nextLine().toLowerCase().charAt(0);
        if ( choice == 'y' )
            c.setRequiresSignature(true);
        else
            c.setRequiresSignature(false);
    }

    public static void getOTCDrugInformation(OTCDrug o, Scanner userInput) {
        getMedicineInformation(o, userInput);

        boolean valid = false;
        while (!valid) {
        	// Get the cost of the drug
            System.out.print("Enter the cost of the drug in dollars: ");
            try {
            	// Use a try-catch block to make sure the user puts a dollar amount.
                o.setCost(Double.parseDouble(userInput.nextLine()));
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        // Get the composition of the drug
        System.out.print("Enter the composition of the drug, 100 characters max: ");
        o.setComposition(userInput.nextLine());
    }

    public static void getMedicineInformation(Medicine m, Scanner userInput) {
        System.out.print("Enter the name of the medicine (2-25 characters): ");
        m.setName(userInput.nextLine());
        // Get the manufacturer of the drug
        System.out.print("Enter the manufacturer of the medicine (2-25 characters): ");
        m.setManufacturer(userInput.nextLine());
        // Get the expiration date of the drug
        System.out.print("Enter the expiration date using format YYYY-MM-DD: ");
        m.setExpirationDate(userInput.nextLine());

        boolean valid = false;
        while (!valid) {
        	// Get the quantity of the drug
            System.out.print("Enter the quantity of medicine in the container (1+): ");
            try {
                m.setQuantity(Integer.parseInt(userInput.nextLine()));
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        // Get the drug in milliliters, grams or capsules
        System.out.print("Enter the unit of the container (milliliters, grams, or capsules): ");
        m.setUnit(userInput.nextLine());
    }

    public static void getPatientInformation(Patient p, Scanner userInput) {
        getPersonInformation(p, userInput);
        // Get the name of the physician
        System.out.print("Enter the name of the primary physician: ");
        p.setPrimaryPhysician(userInput.nextLine());
        // Get notes on the patient
        System.out.print("Enter any notes about the patient, max 100 characters: ");
        p.setNotes(userInput.nextLine());
    }

    public static void getNurseInformation(Nurse n, Scanner userInput) {
        getEmployeeInformation(n, userInput);
        // Use the json file to look for the nurse's department
        System.out.print("Enter the nurse's department: ");
        n.setDepartment(userInput.nextLine());
        // Can the nurse prescribe medications y or n
        System.out.print("This nurse can prescribe medications (y-yes, n-no): ");
        char choice = userInput.nextLine().toLowerCase().charAt(0);
        if ( choice == 'y' )
            n.setCanPrescribe(true);
        else
            n.setCanPrescribe(false);
    }

    public static void getDoctorInformation(Doctor d, Scanner userInput) {
        // We leverage modularization
        // We do not call getPersonInformation because getEmployeeInformation will do that for us
        getEmployeeInformation(d, userInput);
        // Use the json file to look for the doctor's specialty
        System.out.print("Enter the doctor's specialty: ");
        d.setSpecialty(userInput.nextLine());
        // Can the doctor operate y or n
        System.out.print("This doctor can perform surgery (y-yes, n-no): ");
        char choice = userInput.nextLine().toLowerCase().charAt(0);
        if ( choice == 'y' )
            d.setCanOperate(true);
        else
            d.setCanOperate(false);
    }

    public static void getEmployeeInformation(Employee e, Scanner userInput) {
        // Modularization
        // We call the method that does it already
        getPersonInformation(e, userInput);

        // Get employee ID
        System.out.print("Enter the 10-digit employee ID: ");
        e.setEmployeeID(userInput.nextLine());

        // Get hire date
        System.out.print("Enter the hire date (YYYY-MM-DD): ");
        e.setHireDate(userInput.nextLine());
    }

    public static void getPersonInformation(Person p, Scanner userInput) {
        // Get first name
        System.out.print("Enter the first name (2-20 characters): ");
        p.setFirstName(userInput.nextLine());

        // Get last name
        System.out.print("Enter the last name (2-20 characters): ");
        p.setLastName(userInput.nextLine());

        // Get date of birth
        System.out.print("Enter the date of birth in the format YYYY-MM-DD: ");
        p.setDateOfBirth(userInput.nextLine());
    }

}

	
	