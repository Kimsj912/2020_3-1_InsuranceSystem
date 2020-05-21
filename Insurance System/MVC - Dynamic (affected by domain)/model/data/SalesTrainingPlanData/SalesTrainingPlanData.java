package model.data.SalesTrainingPlanData;

import java.time.LocalDateTime;

import model.data.ISData;

public class SalesTrainingPlanData extends ISData {
	
	
	private String title;
	private String target;
	private LocalDateTime date;
	private String place;
	private String goal;
	private String content;
	
	
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
	public String getTarget() {return target;}
	public void setTarget(String target) {this.target = target;}
}
