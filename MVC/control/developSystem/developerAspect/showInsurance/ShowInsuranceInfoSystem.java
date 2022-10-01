package control.developSystem.developerAspect.showInsurance;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectSystem;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemView;
import panel.BasicPanel;

public class ShowInsuranceInfoSystem extends DevelopSystem {

	private enum EActionCommands {InsuranceDesign, WatchInsuranceData}
	
	// Attribute
	private int insuranceID;
	
	// Constructor
	public ShowInsuranceInfoSystem(int insuranceID) {this.insuranceID=insuranceID;}

	@Override
	public BasicPanel getPanel() {
		AbsInsuranceData insuranceData = this.insuranceList.search(this.insuranceID);
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("���� ���� Ȯ��"));
		view.addComponent(new SeparateLine(Color.black));
		
		view.addComponent(new OutputTextArea("�̸�", insuranceData.getName()));
		view.addComponent(new OutputTextArea("������", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			view.addComponent(new OutputTextArea("���� ����", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		view.addComponent(new OutputTextArea("����", insuranceData.getContent()));
		view.addComponent(new OutputTextArea("���� ����", insuranceData.getInsuranceRateInfo()));
		view.addComponent(new OutputTextArea("���� ���� ����", Boolean.toString(insuranceData.isInsuranceratePermit())));
		view.addComponent(new OutputTextArea("��ǰ �ΰ� ����", Boolean.toString(insuranceData.isProductPermit())));
		
		view.addToLinkPanel(
				new LinkButton("���� ����", EActionCommands.InsuranceDesign.name(), this.actionListener),
				new LinkButton("���� ���� Ȯ��", EActionCommands.WatchInsuranceData.name(), this.actionListener)
		);
		return view;
	}
	
	@Override 
	public DynamicSystem processEvent(ActionEvent e) {
		switch (EActionCommands.valueOf(e.getActionCommand())) {
		case InsuranceDesign : return new DevelopeInsuranceSelectSystem();
		case WatchInsuranceData : return new SelecInsuranceToWatchSystem();
		}
		return null;
	}
}
