package control.developSystem.productPermitMan;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
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

public class ShowInsuranceForProductPermitSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {Permit, Ban}
		
	// Association
	private ISDataList<ProductPermitTask> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForProductPermitSystem(ISDataList<ProductPermitTask> isDataList, int taskIndex) {
		this.tasks=isDataList; this.taskIndex=taskIndex;
	}
	
	@Override
	public BasicPanel getPanel() {
		this.targetInsuranceID = this.tasks.search(this.taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("��ǰ �ΰ�"));
		view.addComponent(new SeparateLine(Color.black));
		
		view.addComponent(new OutputTextArea("�̸�", insuranceData.getName()));
		view.addComponent(new OutputTextArea("������", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			view.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		view.addComponent(new OutputTextArea("����", insuranceData.getContent()));
		view.addComponent(new OutputTextArea("���� ����", insuranceData.getInsuranceRateInfo()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new ActionButton("�հ�", EActionCommands.Permit.name(), this.actionListener));
		btnGroup.addGroupComponent(new ActionButton("���հ�", EActionCommands.Ban.name(), this.actionListener));
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
		case Permit : this.insuranceData.permitProduct(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
		return null;
	}
}
