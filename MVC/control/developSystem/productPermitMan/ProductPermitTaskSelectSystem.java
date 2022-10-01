package control.developSystem.productPermitMan;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.developTask.ProductPermitTask;
import view.aConstant.InsuranceSystemViewConstant;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.DynamicGroup;
import component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;
import panel.BasicPanel;

public class ProductPermitTaskSelectSystem extends DevelopSystem {

	// Attribute
	private ProductPermitManData loginPPM;
		
	// Constructor
	public ProductPermitTaskSelectSystem(ProductPermitManData user) {this.loginPPM=user;}

	@Override
	public BasicPanel getPanel() {
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("보험 선택"));
		view.addComponent(new SeparateLine(Color.black));
		
		if(this.loginPPM.getTaskList().getList().size()==0) {
			view.addComponent(new OutputTextArea("처리할 업무가 없습니다.", ""));
		}else {
			DynamicGroup selectBtnGroup = new DynamicGroup();
			for(ProductPermitTask task : this.loginPPM.getTaskList().getList()) {
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
		return new ShowInsuranceForProductPermitSystem(this.loginPPM.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
