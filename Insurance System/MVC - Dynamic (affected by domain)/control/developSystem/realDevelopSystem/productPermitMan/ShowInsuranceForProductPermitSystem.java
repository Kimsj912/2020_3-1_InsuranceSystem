package control.developSystem.realDevelopSystem.productPermitMan;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.insuranceData.AbsInsuranceData;
import model.data.taskData.realTaskData.ProductPermit;
import model.dataList.realDataList.ISDataList;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class ShowInsuranceForProductPermitSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {Permit, Ban}
		
	// Association
	private ISDataList<ProductPermit> tasks;
	private int taskIndex, targetInsuranceID;
	private AbsInsuranceData insuranceData;
	
	// Constructor
	public ShowInsuranceForProductPermitSystem(ISDataList<ProductPermit> isDataList, int taskIndex) {
		this.tasks=isDataList; this.taskIndex=taskIndex;
	}

	// Initialize
	// associate Action Lister to View
	
	@Override
	public Vector<JComponent> getViewInfo() {
		this.targetInsuranceID = this.tasks.search(taskIndex).getTargetInsuranceID();
		this.insuranceData = this.insuranceList.search(this.targetInsuranceID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("��ǰ �ΰ� �Ǵ� ���ּ���"));
		viewInfo.add(new TitledTextArea("�̸�", 1, this.insuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("����", 10, this.insuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("���� ����", 10, this.insuranceData.getInsuranceRateInfo(), false));
		viewInfo.add(new TitledTextArea("������", 1, Double.toString(this.insuranceData.getLossPercent()), false));
		viewInfo.add(new BasicButton("�հ�", EActionCommands.Permit.name(), this.actionListener));
		viewInfo.add(new BasicButton("���հ�", EActionCommands.Ban.name(), this.actionListener));
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case Permit : this.insuranceData.permitProduct(); break;
		case Ban : break;
		}
		this.tasks.delete(this.taskIndex);
		this.gotoBack();
		return null;
	}
}
