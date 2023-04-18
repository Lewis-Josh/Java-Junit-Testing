//Import JUnit Testing
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Create Contact Service Test Class
public class ContactServiceTest {
	  protected String contactID, firstNameTest, lastNameTest, phoneNumberTest,
	      addressTest;
	  protected String ContactIDLong, FirstNameLong, LastNameLong,
	      PhoneNumberLong, PhoneNumberShort, AddressLong;

	  @BeforeEach
	  //Initialize Testing Variables
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
	  //Contact Service Test Method
	  void newContactTest() {
	    ContactService service = new ContactService();
	    service.addContact();
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(0).getContactID()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(0).getFirstName()),
	        ()
	            -> assertEquals("INITIAL",
	                            service.getContactList().get(0).getLastName()),
	        ()
	            -> assertEquals("1234445555",
	                            service.getContactList().get(0).getPhoneNumber()),
	        ()
	            -> assertEquals("INITIAL",

	    service.newContact(firstNameTest, lastNameTest, phoneNumberTest, addressTest);
	    assertAll(
	        "service",
	        ()
	            -> assertNotNull(service.getContactList().get(4).getContactID()),
	        ()
	            -> assertEquals(firstNameTest,
	                            service.getContactList().get(4).getFirstName()),
	        ()
	            -> assertEquals(lastNameTest,
	                            service.getContactList().get(4).getLastName()),
	        ()
	            -> assertEquals(phoneNumberTest,
	                            service.getContactList().get(4).getPhoneNumber()),
	        ()
	            -> assertEquals(addressTest,
	                            service.getContactList().get(4).getAddress()));
	  }

	  @Test
	  //Delete Contact Method
	  void deleteContactTest() {
	    ContactService service = new ContactService();
	    service.newContact();
	    assertThrows(Exception.class, () -> service.deleteContact(contactID));
	    assertAll(()
	                  -> service.deleteContact(
	                      service.getContactList().get(0).getContactID()));
	  }

	  @Test
	  //Update First Name Test with Throw Exception
	  void updateFirstNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.updateFirstName(service.getContactList().get(0).getContactID(), firstNameTest);
	    assertEquals(firstNameTest, service.getContactList().get(0).getFirstName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateFirstName(
	                         service.getContactList().get(0).getContactID(),
	                         FirstNameLong));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateFirstName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updateFirstName(contactID, firstNameTest));
	  }

	  @Test
	  //Update Last Name Test with Throw Exception
	  void updateLastNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.updateLastName(service.getContactList().get(0).getContactID(), lastNameTest);
	    assertEquals(lastNameTest, service.getContactList().get(0).getLastName());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateLastName(
	                         service.getContactList().get(0).getContactID(),
	                         LastNameLong));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateLastName(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updateLastName(contactID, lastNameTest));
	  }

	  @Test
	  //Update Phone Number Test with Throw Exception
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.updatePhoneNumber(service.getContactList().get(0).getContactID(), phoneNumberTest);
	    assertEquals(phoneNumberTest, service.getContactList().get(0).getPhoneNumber());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactID(),
	                         PhoneNumberLong));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactID(),
	                         PhoneNumberShort));
	    assertThrows(
	        IllegalArgumentException.class,
	        ()
	            -> service.updatePhoneNumber(
	                service.getContactList().get(0).getContactID(), contactID));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updatePhoneNumber(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updatePhoneNumber(contactID, lastNameTest));
	  }

	  @Test
	  //Update Address Test with Throw Exception
	  void updateAddressTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.updateAddress(service.getContactList().get(0).getContactID(), addressTest);
	    assertEquals(addressTest, service.getContactList().get(0).getAddress());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateAddress(
	                         service.getContactList().get(0).getContactID(),
	                         AddressLong));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.updateAddress(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.updateAddress(contactID, addressTest));
	  }
	}
