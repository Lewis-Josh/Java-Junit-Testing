/*
 * Date: 03/25/2023
 * Author: Joshua Lewis
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskService {
	
	//Create Task Array List
	private final List<Task> tasksList = new ArrayList<>();
	
	//Generate UniqueID and Convert to String with Maximum Length 
	private String newUniqueID() {
		return UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	//Create New Task, Check for duplicates, and add to Tasks Array List if not duplicate
	public boolean addTask(String name, String description) throws Exception {
		Task task = new Task(newUniqueID(), name, description);
		int index = 0;
		while (index < tasksList.size()) {
			if (task.getTaskID().equals(tasksList.get(index).getTaskID())) {
				throw new Exception("The Task Already Exists!");
				}
			index++;
			}
		return tasksList.add(task);
		}
	
	//Search Tasks Array List by Task ID if not found throws Exception 
	private Task searchList(String ID)  throws Exception {
		int index = 0;
	    while (index < tasksList.size()) {
	    	if (ID.equals(tasksList.get(index).getTaskID())) {
	    		return tasksList.get(index);	
	    	}
	    	index++;
	    	}
	    throw new Exception("The Task does not exist!");
	    }
	
	//Delete Task using Task ID
	public void deleteTask(String ID) throws Exception {
		tasksList.remove(searchList(ID));
		}
	
	//Update Task Name using Task ID
	public void updateName(String ID, String name) throws Exception{
		searchList(ID).setName(name);
		}
	
	//Update Task Description using Task ID
	public void updateDescription(String ID, String desc) throws Exception {
	    searchList(ID).setDescription(desc);
	    }

	//List Accessor
	public List<Task> getTaskList() { 
		return tasksList; 
		}
}
