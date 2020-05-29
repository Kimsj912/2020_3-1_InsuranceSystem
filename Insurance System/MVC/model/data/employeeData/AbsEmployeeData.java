package model.data.employeeData;

import model.data.systemUserData.SystemUserData;
import model.data.taskData.AbsTask;

public abstract class AbsEmployeeData<TaskType extends AbsTask> extends SystemUserData<TaskType>  {

	// Attributes
	private String name;
	
	// Working Variable
	private boolean workable;
	
	// Constructor
	public AbsEmployeeData() {
		// Initialize Working Variable
		this.workable = true;
	}
	
	// Getter & Setter
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	public boolean isWorkable() {return this.workable;}
	public void setWorkable(boolean workable) {this.workable = workable;}
}
