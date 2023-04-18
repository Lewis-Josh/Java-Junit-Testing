/*
 * Date: 04/07/2023
 * Author: Joshua Lewis
 */

//Create Contact Class
public class Contact {

	//initialize private variables
	private static final String initial = "initial";
	private static final String initialNum = "1234445555";
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	//Default Constructor
	Contact() {
	    contactID = initial;
	    firstName = initial;
	    lastName = initial;
	    phoneNumber = initialNum;
	    address = initialNum;
	  }

	//Overloaded Parameter Constructor with input Validation
	Contact(String contactID, String firstName, String lastName, String phoneNumber, String address) {

		//contactID Input Validation and Mutator Call
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Error: The Contact ID must not be null or longer than 10 characters.");
		}
		else {
			setContactID(contactID)
		}

		//First Name Validation and Mutator Call
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Error: The First Name must not be null or longer than 10 characters.");
		}
		else {
			setFirstName(firstName);
		}

		//Last Name Validation and Mutator Call
		if (lastName == null || lastName.length() > 10) {
			throw null IllegalArgumentException("Error: The First Name must not but null or longer than 10 characters.");
		}
		else {
			setlastName(lastName);
		}

		//Phone Number Validation and Mutator Call
		String pnum = "[0-9]+";
		if (phoneNumber == null || phoneNumber.length > 10 || !phoneNumber.matches(pnum)) {
			throw new IllegalArgumentException("Error: The Phone Number must not be null, longer than 10 characters and contain only numbers!");
		}
		else {
			setPhoneNumber(phoneNumber);
		}

		//Address Validation and Mutator Call
		if (address == null || address.length > 30) {
			throw new IllegalArgumentException("Error: The address must not be null or longer than 30 characters!");
		}
		else {
			setAddress(address);
		}
	}

	//Accessors
	public final String getContactID() { return contactID; }

	public final String getFirstName() { return firstName; }

	public final String getLastName() { return lastName; }

	public final String getPhoneNumber() { return phoneNumber; }

	public final String getAddress() { return address; }

	//Contact ID Mutator
	private void setContactId(String contactID) {
		this.contactID = contactID;
	}
	  
	//First Name Mutator
	public void setFirstName(String firstName) {
	  this.firstName = firstName;
	}

	//Last Name Mutator
	public void setLastName(String lastName) {
	  this.lastName = lastName;
	}

	//Phone Number Mutator
	public void setPhoneNumber(String phoneNumber) {
	  this.phoneNumber = phoneNumber;
	}

	//Address Mutator
	public void setAddress(String address) {
	  this.address = address;
	}
}
