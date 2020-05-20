package control.developSystem.realDevelopSystem.insuranceRatePermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.realTaskData.InsuranceRatePermit;
import view.component.BasicButton;

public class InsuranceRatePermitTaskSelectSystem extends DevelopSystem {

	// My Friend
	private InsuranceRatePermitManData jake;
		
	@Override
	public Vector<JComponent> getViewInfo() {
		this.jake = this.insuranceRatePermitManList.getList().get(0);// 지금만 처음 직원 뽑아서 한다!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("요율 검증하실 보험을 선택해 주세요"));
		for(InsuranceRatePermit task : this.jake.getTaskList().getList()) {
			AbsInsuranceData insuranceData = this.insuranceList.search(task.getTargetInsuranceID());
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(task.getID()), this.actionListener));
		}
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new ShowInsuranceForInsuranceRatePermitSystem(this.jake.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
