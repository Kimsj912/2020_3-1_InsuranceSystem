package control.developSystem.developerAspect.developInsurance;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.showInsurance.SelecInsuranceToWatchSystem;
import model.data.employeeData.developEmployeeData.InsuranceRatePermitManData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData.EDisease;
import model.data.taskData.developTask.InsuranceRatePermitTask;
import view.insuranceSystemView.developView.developer.developInsurance.DevelopInsuranceView;
import view.panel.BasicPanel;

public class DevelopDiseaseInsuranceSystem extends DevelopSystem {

	// Component
	private DevelopInsuranceView view;
	
	@Override
	public BasicPanel getPanel() {this.view = new DevelopInsuranceView(this.actionListener, true); return this.view;}
	
	@Override
	public DynamicSystem processEvent(ActionEvent e) {
		switch (DevelopInsuranceView.EActionCommands.valueOf(e.getActionCommand())) {
		case SaveInsuranceData : if(!this.isLossRateNum()) {return null;}this.save(); this.gotoBack();
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
	private boolean isLossRateNum() {
		try {Double.parseDouble(this.view.getLossPercent());}
		catch(NumberFormatException exc) {JOptionPane.showMessageDialog(this.view, "손해율은 숫자로 입력해 주세요"); return false;}
		return true;
	}
	private void save() {
		DiseaseInsuranceData data = new DiseaseInsuranceData();
		data.setName(this.view.getName());
		data.setContent(this.view.getContent());
		data.setDisease(EDisease.valueOf(this.view.getDisease()));
		data.setInsuranceRateInfo(this.view.getInsuranceRateInfo());
		data.setLossPercent(Double.parseDouble(this.view.getLossPercent()));
		this.insuranceList.add(data);
		
		for(InsuranceRatePermitManData employee : this.insuranceRatePermitManList.getList()) {
			if(employee.isWorkable()) {employee.addTask(new InsuranceRatePermitTask(data.getID())); break;}
		}
	}
}
