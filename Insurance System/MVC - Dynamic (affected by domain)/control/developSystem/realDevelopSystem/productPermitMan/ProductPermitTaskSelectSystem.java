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
		this.jake = this.productPermitManList.getList().get(0);// 지금만 처음 직원 뽑아서 한다!!
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("인가하실 보험을 선택해 주세요"));
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
