package control.developSystem.insuranceRatePermitMan;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import model.data.taskData.developTask.InsuranceRatePermitTask;
import model.data.taskData.developTask.ProductPermitTask;
import dataList.realDataList.ISDataList;
import view.aConstant.InsuranceSystemViewConstant;
import component.BasicLabel;
import component.SeparateLine;
import component.button.ActionButton;
import component.button.LinkButton;
import component.group.StaticGroup;
import component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;
import panel.BasicPanel;

public class ShowInsuranceForInsuranceRatePermitSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {Permit, Ban}
		
	// Association
	private ISDataList<InsuranceRatePermitTask> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForInsuranceRatePermitSystem(ISDataList<InsuranceRatePermitTask> tasks, int taskIndex) {
		this.tasks=tasks; this.taskIndex=taskIndex;
	}

	@Override
	public BasicPanel getPanel() {
		this.targetInsuranceID = this.tasks.search(this.taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("요율 검증"));
		view.addComponent(new SeparateLine(Color.black));
		
		view.addComponent(new OutputTextArea("이름", insuranceData.getName()));
		view.addComponent(new OutputTextArea("손해율", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			view.addComponent(new OutputTextArea("보상 질병", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		view.addComponent(new OutputTextArea("설명", insuranceData.getContent()));
		view.addComponent(new OutputTextArea("요율 설명", insuranceData.getInsuranceRateInfo()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new ActionButton("합격", EActionCommands.Permit.name(), this.actionListener));
		btnGroup.addGroupComponent(new ActionButton("불합격", EActionCommands.Ban.name(), this.actionListener));
		view.addComponent(btnGroup);
		
		view.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", this.actionListener),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", this.actionListener)
		);
		return view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Permit : this.insuranceData.permitInsuranceRate(); this.orderProductPermit(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
		return null;
	}
	
	private void orderProductPermit() {
		for(ProductPermitManData employee : this.productPermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new ProductPermitTask(this.targetInsuranceID)); break;}
		}
	}
}
