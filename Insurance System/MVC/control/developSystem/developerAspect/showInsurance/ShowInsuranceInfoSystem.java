package control.developSystem.developerAspect.showInsurance;

import java.awt.Color;
import java.awt.event.ActionEvent;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import control.developSystem.developerAspect.developInsurance.DevelopeInsuranceSelectSystem;
import model.data.insuranceData.AbsInsuranceData;
import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData;
import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.textArea.OutputTextArea;
import view.insuranceSystemView.InsuranceSystemPanel;
import view.panel.BasicPanel;

public class ShowInsuranceInfoSystem extends DevelopSystem {

	private enum EActionCommands {InsuranceDesign, WatchInsuranceData}
	
	// Attribute
	private int insuranceID;
	
	// Constructor
	public ShowInsuranceInfoSystem(int insuranceID) {this.insuranceID=insuranceID;}

	@Override
	public BasicPanel getPanel() {
		AbsInsuranceData insuranceData = this.insuranceList.search(this.insuranceID);
		InsuranceSystemPanel view = new InsuranceSystemPanel();
		view.addComponent(new BasicLabel("보험 정보 확인"));
		view.addComponent(new SeparateLine(Color.black, 1));
		
		view.addComponent(new OutputTextArea("이름", insuranceData.getName()));
		view.addComponent(new OutputTextArea("손해율", Double.toString(insuranceData.getLossPercent())));
		if(insuranceData instanceof DiseaseInsuranceData) {
			view.addComponent(new OutputTextArea("보상 질병", ((DiseaseInsuranceData)insuranceData).getDisease().name()));
		}
		view.addComponent(new OutputTextArea("설명", insuranceData.getContent()));
		view.addComponent(new OutputTextArea("요율 설명", insuranceData.getInsuranceRateInfo()));
		view.addComponent(new OutputTextArea("요율 검증 여부", Boolean.toString(insuranceData.isInsuranceratePermit())));
		view.addComponent(new OutputTextArea("상품 인가 여부", Boolean.toString(insuranceData.isProductPermit())));
		
		view.addLinkBtn(
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), this.actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), this.actionListener)
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
