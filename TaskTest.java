/*
 * Date 03/25/2023
 * Author; Joshua Lewis
 */

//Junit Imports
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Test Class Creation
class TaskTest {
	private String ID, name, description;
	private String IDLong, NameLong, DescriptionLong;
	
	//Set Up Test Before Each Execution
	@BeforeEach
	void setUp() {
		ID = "1234567890";
		name = "This is a name";
		description = "This is a description";
		IDLong = "01987654321";
		NameLong = "The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.\r\n";
		DescriptionLong =
				"The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
		}
  @Test
  //Test All
  void getAllTest() {
    Task task = new Task(ID, name, description);
    Assertions.assertEquals(ID, task.getTaskID());
  }

  @Test
  //Name Mutator Test
  void setNameTest() {
    Task task = new Task();
    task.setName(name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  //Description Mutator Test
  void setDescriptionTest() {
    Task task = new Task();
    task.setDescription(description);
    Assertions.assertEquals(description, task.getDescription());
    }

  @Test
  //Too Long Task ID Exception Test
  void TaskIDLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(IDLong, name, description));
    }

  @Test
  //Too Long Name Exception Test
  void NameLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(ID, NameLong, description));
    }

  @Test
  //Too Long Description Test
  void DescriptionLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(ID, name, DescriptionLong));
    }

  @Test
  //Null Task ID Exception Test
  void TaskIDNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(null, name, description));
  }

  @Test
  //Null Task Name Exception Test
  void TaskNameNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(ID, null, description));
  }

  @Test
  //Null Task Description Exception Test
  void TaskDescriptionNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(ID, name, null));
  }
}