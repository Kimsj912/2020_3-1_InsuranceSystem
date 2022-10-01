package control.developSystem.insuranceRatePermitMan;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.developTask.InsuranceRatePermitTask;
import view.aConstant.InsuranceSystemViewConstant;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.DynamicGroup;
import component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;
import panel.BasicPanel;

public class InsuranceRatePermitTaskSelectSystem extends DevelopSystem {

	// Attribute
	private InsuranceRatePermitManData loginIRPM;
		
	// Constructor
	public InsuranceRatePermitTaskSelectSystem(InsuranceRatePermitManData loginIRPM) {this.loginIRPM=loginIRPM;}

	@Override
	public BasicPanel getPanel() {
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("보험 선택"));
		view.addComponent(new SeparateLine(Color.black));
		
		if(this.loginIRPM.getTaskList().getList().size()==0) {
			view.addComponent(new OutputTextArea("처리할 업무가 없습니다.", ""));
		}else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for(InsuranceRatePermitTask task : this.loginIRPM.getTaskList().getList()) {
				AbsInsuranceData insuranceData = this.insuranceList.search(task.getTargetInsuranceID());
				selectBtnGroup.addGroupComponent(new SelectButton(insuranceData.getName(), Integer.toString(task.getID()), this.actionListener));
			}
			view.addComponent(selectBtnGroup);
		}
		
		view.addToLinkPanel(
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookGreat, "", this.actionListener),
				new LinkButton(InsuranceSystemViewConstant.SomeThingLookNide, "", this.actionListener)
		);
		return view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		return new ShowInsuranceForInsuranceRatePermitSystem(this.loginIRPM.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
