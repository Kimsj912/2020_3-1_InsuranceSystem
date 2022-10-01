package model.data.activityPlanData;

import java.time.LocalDate;
import java.util.Vector;

import model.aConstant.ETargetCustomer;
import data.ISData;

public class ActivityPlanData extends ISData {
	
	// Attributes
	private String title;
	private LocalDate salesDuration;
	private int salesGoal;
	private String ActivityGoal;
	private int additionalJobOffer;
	private Vector<ETargetCustomer> salesTargetCustomer;
	
	// getter & setter
	public LocalDate getSalesDuration() {return salesDuration;}
	public void setSalesDuration(LocalDate localDate) {this.salesDuration = localDate;}
	public int getSalesGoal() {return salesGoal;}
	public void setSalesGoal(int salesGoal) {this.salesGoal = salesGoal;}	
	public String getActivityGoal() {return ActivityGoal;}
	public void setActivityGoal(String activityGoal) {ActivityGoal = activityGoal;}
	public int getAdditionalJobOffer() {return additionalJobOffer;}
	public void setAdditionalJobOffer(int additionalJobOffer) {this.additionalJobOffer = additionalJobOffer;}
	public Vector<ETargetCustomer> getSalesTargetCustomer() {return salesTargetCustomer;}
	public void setSalesTargetCustomer(Vector<ETargetCustomer> salesTargetCustomer) {this.salesTargetCustomer = salesTargetCustomer;}
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
}
