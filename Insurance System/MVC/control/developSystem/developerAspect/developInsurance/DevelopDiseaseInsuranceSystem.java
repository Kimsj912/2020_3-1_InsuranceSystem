package control.developSystem.developerAspect.developInsurance;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData.EDisease;
import model.data.taskData.developTask.InsuranceRatePermitTask;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.TitledRadioButtonGroup;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class DevelopDiseaseInsuranceSystem extends DevelopSystem {

	// Static
	private enum EActionCommands {SaveInsuranceData, InsuranceDesign, WatchInsuranceData}
	
	// Component
	private InputTextArea nameTTA, contentTTA, insuranceRateInfoTTA, lossPercentTTA;
	private TitledRadioButtonGroup diseaseTRBG;
	private InsuranceSystemPanel view;
	
	@Override
	public BasicPanel getPanel() {
		this.view = new InsuranceSystemPanel();
		this.view.addComponent(new BasicLabel("���� ���� �Է�"));
		this.view.addComponent(new SeparateLine(Color.black, 1));
		
		this.nameTTA = new InputTextArea("�̸�", "", 1,100);
		this.lossPercentTTA = new InputTextArea("������", "���ڷ� �Է�", 1, 100);
		this.contentTTA = new InputTextArea("����", "���� ������ �Է��� �ּ���", 10, 100);
		this.insuranceRateInfoTTA = new InputTextArea("���� ����", "���� ������ �Է��� �ּ���", 10, 100);
		this.diseaseTRBG = new TitledRadioButtonGroup("���� ����", EDisease.class, false, 100);
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1, 1});
		selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.diseaseTRBG, this.contentTTA, this.insuranceRateInfoTTA);
		this.view.addComponent(selectBtnGroup);
		
		this.view.addComponent(new SelectButton("����", EActionCommands.SaveInsuranceData.name(), this.actionListener));
		
		view.addLinkBtn(
				new LinkButton("���� ����", EActionCommands.InsuranceDesign.name(), this.actionListener),
				new LinkButton("���� ���� Ȯ��", EActionCommands.WatchInsuranceData.name(), this.actionListener)
		);
		return this.view;
	}
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case SaveInsuranceData : if(!this.isLossRateNum()) {return null;}this.save(); this.gotoBack();
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
	private boolean isLossRateNum() {
		try {Double.parseDouble(this.lossPercentTTA.getContent());}
		catch(NumberFormatException exc) {JOptionPane.showMessageDialog(this.view, "�������� ���ڷ� �Է��� �ּ���"); return false;}
		return true;
	}
	private void save() {
		DiseaseInsuranceData data = new DiseaseInsuranceData();
		data.setName(this.nameTTA.getContent());
		data.setContent(this.contentTTA.getContent());
		data.setDisease(EDisease.valueOf(this.diseaseTRBG.getSelectedOptionNames().get(0)));
		data.setInsuranceRateInfo(this.insuranceRateInfoTTA.getContent());
		data.setLossPercent(Double.parseDouble(this.lossPercentTTA.getContent()));
		this.insuranceList.add(data);
		
		for(InsuranceRatePermitManData employee : this.insuranceRatePermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new InsuranceRatePermitTask(data.getID())); break;}
		}
	}
}
