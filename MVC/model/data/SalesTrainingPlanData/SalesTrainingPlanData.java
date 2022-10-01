package model.data.SalesTrainingPlanData;

import java.time.LocalDateTime;
import java.util.Vector;

import model.aConstant.ETrainingTargetEmployee;
import data.ISData;

public class SalesTrainingPlanData extends ISData {
	
	// Attribute
	private String title, place, goal, content;
	private Vector<ETrainingTargetEmployee> target;
	private LocalDateTime date;
	
	// getter & setter
	public LocalDateTime getDate() {return date;}
	public void setDate(LocalDateTime localDateTime) {this.date = localDateTime;}
	public String getPlace() {return place;}
	public void setPlace(String place) {this.place = place;}
	public String getGoal() {return goal;}
	public void setGoal(String goal) {this.goal = goal;}
	public String getContent() {return content;}
	public void setContent(String content) {this.content = content;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public Vector<ETrainingTargetEmployee> getTarget() {return target;}
	public void setTarget(Vector<ETrainingTargetEmployee> target) {this.target = target;}
}
