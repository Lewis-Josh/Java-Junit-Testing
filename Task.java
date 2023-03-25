/*
 * Date: 03/25/2023
 * Author: Joshua Lewis
 * 
 */

//Task Class Creation
public class Task {
	private String taskID;
	private String name;
	private String description;
	
	//Default Constructor
	Task() {
		taskID = "initial";
		name = "initial";
		description = "initial";
		}

	//Overloaded Parameter Constructor with input Validation
	Task(String taskID, String name, String desc) {
		
		//TaskID Input Validation and Mutator Call
		if (taskID == null || taskID.length() > 10) {
			throw new IllegalArgumentException(
					"Error: The task ID must not be null or longer than 10 characters");
			}
		else {
			setTaskID(taskID);
			}
		
		//Name Input Validation and Mutator Call
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException(
					"Task name is invalid. Name must be shorter than 20 characters and not empty.");
			}
		else {
			setName(name);
			}
		
		//Description Input Validation and Mutator Call
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException(
					"Task description is invalid. Task description must be shorter than 50 characters and not empty.");
			}
		else {
			setDescription(desc);
			}
	}
	
	//TaskID Accessor
	public final String getTaskID() {
		return taskID;
		}
	
	//Name Accessor
	public final String getName() {
		return name;
		}
	
	//Description Accessor
	public final String getDescription() {
		return description;
		}
	
	//TaskID Mutator
	private void setTaskID(String taskID) {
		this.taskID = taskID;
		}
	
	//Name Mutator
	protected void setName(String name) {
		this.name = name;
		}
	
	//Description Mutator
	protected void setDescription(String desc) {
		this.description = desc;
		}
}
