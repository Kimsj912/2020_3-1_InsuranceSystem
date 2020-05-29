package control.developSystem.insuranceRatePermitMan;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.developTask.InsuranceRatePermitTask;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.DynamicGroup;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class InsuranceRatePermitTaskSelectSystem extends DevelopSystem {

	// Attribute
	private InsuranceRatePermitManData loginIRPM;
		
	// Constructor
	public InsuranceRatePermitTaskSelectSystem(InsuranceRatePermitManData loginIRPM) {this.loginIRPM=loginIRPM;}

	@Override
	public BasicPanel getPanel() {
		InsuranceSystemPanel view = new InsuranceSystemPanel();
		view.addComponent(new BasicLabel("보험 선택"));
		view.addComponent(new SeparateLine(Color.black, 1));
		
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
		view.addLinkBtn(
				new LinkButton("그럴듯한 링크", "", this.actionListener),
				new LinkButton("오 멋져", "", this.actionListener)
		);
		return view;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		if(e.getActionCommand().equals("")) {return null;}
		return new ShowInsuranceForInsuranceRatePermitSystem(this.loginIRPM.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
