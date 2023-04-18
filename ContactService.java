/*
 * Date: 04/07/2023
 * Author: Joshua Lewis
 */

import java.util.ArrayList;
import java.util.List;

public class ContactService {
	
	//Create Contact List
	final private List<Contact> contactList = new ArrayList<>();

	//Add Contact if ConctactID is not in List
	public boolean addContact(string contactID, String firstname, String lastname, String phonenumber, String address) throws Exception {
		Contact contact = new Contact(contactID, firstname, lastname, phonenumber, address);
		int index = 0;
		while (index < contactList.size()) {
			if (contact.getContactID().equals(contactList.get(index).getcontactID())) {
				throw new Exception("The Contact Already Exists!");
			}
			index++;
		}
		return contactList.add(contact);
	}

	//Delete Contact by contactID
	public void deleteContact(String contactID) throws Exception {
		contactList.remove(searchForContact(contactID));
	  }

	//Update Contact FirstName by contactID
	public void updateFirstName(String contactID, String firstName) throws Exception {
		searchForContact(contactID).updateFirstName(firstName);
	}

	//Update Contact LastName by contactID
	public void updateLastName(String contactID, String lastName) throws Exception {
		searchForContact(contactID).updatelastName(lastName);
	}

	//Update Contact Phone Number by contactID
	public void updatePhoneNumber(String contactID, String phoneNumber) throws Exception {
		searchForContact(contactID).updatePhoneNumber(phoneNumber);
	}

	//Update Contact Address by contactID
	public void updateAddress(String contactID, String address) throws Exception {
		searchForContact(contactID).updateAddress(address);
	}

	//Return Contact List
	protected List<Contact> getContactList() { return contactList; }

	//Search Contact by contactID
	private Contact searchForContact(String contactID) throws Exception {
		int index = 0;
			while (index < contactList.size()) {
			  if (contactID.equals(contactList.get(index).getcontactID())) {
				return contactList.get(index);
			  }
			  index++;
			}
		throw new Exception("The Task does not exist!");
	}
}
