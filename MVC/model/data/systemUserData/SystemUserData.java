package model.data.systemUserData;

import data.ISData;
import model.data.taskData.AbsTask;
import dataList.realDataList.ISDataList;

public class SystemUserData<TaskType extends AbsTask> extends ISData {

	// Attribute
	public String loginID, loginPW;
			
	// Component
	private ISDataList<TaskType> taskList;
	
	// Constructor
	public SystemUserData() {
		// Create Component
		this.taskList = new ISDataList<TaskType>();
	}
	
	// Any Time Use
	public void addTask(TaskType task) {this.taskList.add(task);}
	public void deleteTask(int iD) {this.taskList.delete(iD);}
	public TaskType searchTask(int iD) {return this.taskList.search(iD);}
		
	// Getter & Setter
	public ISDataList<TaskType> getTaskList() {return this.taskList;}
	public String getLoginID() {return this.loginID;}
	public void setLoginID(String loginID) {this.loginID = loginID;}
	public String getLoginPW() {return this.loginPW;}
	public void setLoginPW(String loginPW) {this.loginPW = loginPW;}
}
