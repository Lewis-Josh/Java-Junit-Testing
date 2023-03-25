import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

  private String ID, name, description;
  private String NameLong, DescriptionLong;

  @BeforeEach
  void setUp() {
    ID = "1234567890";
    name = "This is a name";
    description = "This is a description";
    NameLong = "The task object shall have a required name String field that cannot be longer than 20 characters. The name field shall not be null.";
    DescriptionLong =
        "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
  }

  @Test
  void addTaskTest() throws Exception {
	  TaskService service = new TaskService();
	  service.addTask(name, description);
	  Assertions.assertNotNull(service.getTaskList().get(0).getTaskID());
	  Assertions.assertNotEquals("initial", service.getTaskList().get(0).getTaskID());
  }
  
  @Test
  void NameLongTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.addTask(NameLong, description));
  }

  @Test
  void DescriptionLongTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.addTask(name, DescriptionLong));
  }

  @Test
  void newTaskNameNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.addTask(null, description));
  }

  @Test
  void newTaskDescriptionNullTest() {
    TaskService service = new TaskService();
    assertThrows(IllegalArgumentException.class, () -> service.addTask(name, null));
  }

  @Test
  void deleteTaskTest() throws Exception {
    TaskService service = new TaskService();
    service.addTask(name, description);
    assertEquals(1, service.getTaskList().size());
    service.deleteTask(service.getTaskList().get(0).getTaskID());
    assertEquals(0, service.getTaskList().size());
  }

  @Test
  void updateDescriptionTest() throws Exception {
    TaskService service = new TaskService();
    service.addTask(name, description);
    service.updateDescription(service.getTaskList().get(0).getTaskID(),
                              description);
    assertEquals(description, service.getTaskList().get(0).getDescription());
  }
}