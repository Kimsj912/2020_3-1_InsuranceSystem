package control.developSystem.realDevelopSystem.productPermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.ProductPermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.realTaskData.ProductPermit;
import view.component.BasicButton;

public class ProductPermitTaskSelectSystem extends DevelopSystem {

	// My Friend
	private ProductPermitManData jake;
		
	@Override
	public Vector<JComponent> getViewInfo() {
		this.jake = this.productPermitManList.getList().get(0);// ���ݸ� ó�� ���� �̾Ƽ� �Ѵ�!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("�ΰ��Ͻ� ������ ������ �ּ���"));
		for(ProductPermit task : this.jake.getTaskList().getList()) {
			AbsInsuranceData insuranceData = this.insuranceDataList.search(task.getTargetInsuranceID());
			viewInfo.add(new BasicButton(insuranceData.getName(), Integer.toString(task.getID()), this.actionListener));
		}
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		return new ShowInsuranceForProductPermitSystem(this.jake.getTaskList(), Integer.parseInt(e.getActionCommand()));
	}
}
