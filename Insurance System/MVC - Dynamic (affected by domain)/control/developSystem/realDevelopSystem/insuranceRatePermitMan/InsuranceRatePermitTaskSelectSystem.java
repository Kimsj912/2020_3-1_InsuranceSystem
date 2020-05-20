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
		this.jake = this.insuranceRatePermitManList.getList().get(0);// ���ݸ� ó�� ���� �̾Ƽ� �Ѵ�!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("���� �����Ͻ� ������ ������ �ּ���"));
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
