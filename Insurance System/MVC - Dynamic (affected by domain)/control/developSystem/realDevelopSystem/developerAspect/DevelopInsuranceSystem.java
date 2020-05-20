package control.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.CarAccidentInsuranceData;
import model.data.taskData.realTaskData.InsuranceRatePermit;
import view.component.BasicButton;
import view.component.TitledTextArea;

public class DevelopInsuranceSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {SaveInsuranceData}
	
	// Component
	private TitledTextArea nameTTA;
	private TitledTextArea contentTTA;
	private TitledTextArea insuranceRateInfoTTA;
	private TitledTextArea lossPercentTTA;
	
	@Override
	public Vector<JComponent> getViewInfo() {
		this.nameTTA = new TitledTextArea("�̸�", 1, "", true);
		this.contentTTA = new TitledTextArea("����", 10, "", true);
		this.insuranceRateInfoTTA = new TitledTextArea("���� ����", 10, "", true);
		this.lossPercentTTA = new TitledTextArea("������", 1, "", true);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("���� ������ �Է��� �ּ���"));
		viewInfo.add(this.nameTTA);
		viewInfo.add(this.contentTTA);
		viewInfo.add(this.insuranceRateInfoTTA);
		viewInfo.add(this.lossPercentTTA);
		viewInfo.add(new BasicButton("����", EActionCommands.SaveInsuranceData.name(), this.actionListener));
		return viewInfo;
	}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		try {Double.parseDouble(this.lossPercentTTA.getContent());}
		catch(NumberFormatException exc) {JOptionPane.showMessageDialog(this.panel, "�������� ���ڷ� �Է����࿬"); return null;}
		
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveInsuranceData : this.save(); this.gotoBack();
		}
		return null;
	}
	private void save() {
		AbsInsuranceData data = new CarAccidentInsuranceData();
		data.setName(this.nameTTA.getContent());
		data.setContent(this.contentTTA.getContent());
		data.setInsuranceRateInfo(this.insuranceRateInfoTTA.getContent());
		data.setLossPercent(Double.parseDouble(this.lossPercentTTA.getContent()));
		this.insuranceList.add(data);
		
		for(InsuranceRatePermitManData employee : this.insuranceRatePermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new InsuranceRatePermit(data.getID()));}
		}
	}
}
