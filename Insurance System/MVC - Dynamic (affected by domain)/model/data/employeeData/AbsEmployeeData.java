package model.data.employeeData;

import model.data.systemUserData.SystemUserData;
import model.data.taskData.AbsTask;
import model.dataList.realDataList.ISDataList;

public abstract class AbsEmployeeData<TaskType extends AbsTask> extends SystemUserData {

	// Attributes
	private String name;
	
	// Working Variable
	private boolean workable;

	// Component
	private ISDataList<TaskType> taskList;
	
	// Constructor
	public AbsEmployeeData() {
		// Initialize Working Variable
		this.workable = true;
		
		// Create Component
		this.taskList = new ISDataList<TaskType>();
	}
	
	// Any Time Use
	public void addTask(TaskType task) {this.taskList.add(task);}
	public void deleteTask(int iD) {this.taskList.delete(iD);}
	public TaskType searchTask(int iD) {return this.taskList.search(iD);}
	
	// Getter & Setter
	public ISDataList<TaskType> getTaskList() {return this.taskList;}
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	public boolean isWorkable() {return this.workable;}
	public void setWorkable(boolean workable) {this.workable = workable;}
}
