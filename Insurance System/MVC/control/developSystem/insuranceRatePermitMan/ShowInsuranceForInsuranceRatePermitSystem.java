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
import model.dataList.realDataList.ISDataList;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

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
		
		InsuranceSystemPanel view = new InsuranceSystemPanel();
		view.addComponent(new BasicLabel("���� ����"));
		view.addComponent(new SeparateLine(Color.black, 1));
		
		view.addComponent(new OutputTextArea("�̸�", insuranceData.getName()));
		view.addComponent(new OutputTextArea("������", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			view.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		view.addComponent(new OutputTextArea("����", insuranceData.getContent()));
		view.addComponent(new OutputTextArea("���� ����", insuranceData.getInsuranceRateInfo()));
		
		StaticGroup btnGroup = new StaticGroup(new int[] {2});
		btnGroup.addGroupComponent(new SelectButton("�հ�", EActionCommands.Permit.name(), this.actionListener));
		btnGroup.addGroupComponent(new SelectButton("���հ�", EActionCommands.Ban.name(), this.actionListener));
		view.addComponent(btnGroup);
		
		view.addLinkBtn(
				new LinkButton("�׷����� ��ũ", "", this.actionListener),
				new LinkButton("�� ����", "", this.actionListener)
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
