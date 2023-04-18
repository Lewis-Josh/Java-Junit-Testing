import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactTest {
  protected String contactID, firstNameTest, lastNameTest, phoneNumberTest,
      addressTest;
  protected String ContactIDLong, FirstNameLong, LastNameLong,
      PhoneNumberLong, PhoneNumberShort, AddressLong;

  @BeforeEach
  void setUp() {
    contactID = "0123456789";
    firstNameTest = "James";
    lastNameTest = "Lucas";
    phoneNumberTest = "5553331234";
    addressTest = "101 Codeschool Ave";
    ContactIDLong = "109876543210";
    FirstNameLong = "Heingerdingerdoingen";
    LastNameLong = "Hangenflugendickenlagen";
    PhoneNumberLong = "012345678910";
    PhoneNumberShort = "1234567";
    AddressLong = "101 Codeschool Ave. Codeschool, NY 21021";
  }

  @Test
  void contactTest() {
    Contact contact = new Contact();
    assertAll("constructor",
              ()
                  -> assertNotNull(contact.getContactID()),
              ()
                  -> assertNotNull(contact.getFirstName()),
              ()
                  -> assertNotNull(contact.getLastName()),
              ()
                  -> assertNotNull(contact.getPhoneNumber()),
              () 
              	  -> assertNotNull(contact.getAddress()));
  }

  @Test
  void TheConstructorTest() {
    Contact contact = new Contact(contactID, firstNameTest, lastNameTest, phoneNumberTest, addressTest);
    assertAll("constructor all",
              ()
                  -> assertEquals(contactID, contact.getContactID()),
              ()
                  -> assertEquals(firstNameTest, contact.getFirstName()),
              ()
                  -> assertEquals(lastNameTest, contact.getLastName()),
              ()
                  -> assertEquals(phoneNumberTest, contact.getPhoneNumber()),
              () 
              	  -> assertEquals(addressTest, contact.getAddress()));
  }

  @Test
  void updateFirstNameTest() {
    Contact contact = new Contact();
    contact.updateFirstName(firstNameTest);
    assertAll(
        "first name",
        ()
            -> assertEquals(firstNameTest, contact.getFirstName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateFirstName(FirstNameLong)));
  }

  @Test
  void updateLastNameTest() {
    Contact contact = new Contact();
    contact.updatelastName(lastNameTest);
    assertAll(
        "last name",
        ()
            -> assertEquals(lastNameTest, contact.getLastName()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updatelastName(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updatelastName(LastNameLong)));
  }

  @Test
  void updatePhoneNumberTest() {
    Contact contact = new Contact();
    contact.updatePhoneNumber(phoneNumberTest);
    assertAll(
    	"phone number",
   			() 
    			-> assertEquals(phoneNumberTest, contact.getPhoneNumber()), 
    		() 
    			-> assertThrows(IllegalArgumentException.class,
    						() -> contact.updatePhoneNumber(null)),
            () 
            	-> assertThrows(IllegalArgumentException.class,
            				() -> contact.updatePhoneNumber(PhoneNumberLong)),
            () 
            	-> assertThrows(IllegalArgumentException.class,
            				() -> contact.updatePhoneNumber(PhoneNumberShort)),
            () 
            	-> assertThrows(IllegalArgumentException.class,
            				() -> contact.updatePhoneNumber(contactID)));
  }

  @Test
  void updateAddressTest() {
    Contact contact = new Contact();
    contact.updateAddress(addressTest);
    assertAll("Address",
              ()
                  -> assertEquals(addressTest, contact.getAddress()),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(null)),
              ()
                  -> assertThrows(IllegalArgumentException.class,
                                  () -> contact.updateAddress(AddressLong)));
  }

  @Test
  void updateContactIdTest() {
    Contact contact = new Contact();
    contact.updateContactId(contactID);
    assertAll(
        "contact ID",
        ()
            -> assertEquals(contactID, contact.getContactID()),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(null)),
        ()
            -> assertThrows(IllegalArgumentException.class,
                            () -> contact.updateContactId(ContactIDLong)));
  }
}
