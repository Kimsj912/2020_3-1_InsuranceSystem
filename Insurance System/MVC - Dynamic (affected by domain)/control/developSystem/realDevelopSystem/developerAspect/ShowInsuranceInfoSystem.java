package control.developSystem.realDevelopSystem.developerAspect;

import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JComponent;
import javax.swing.JLabel;

import control.DynamicSystem;
import control.developSystem.DevelopSystem;
import model.data.insuranceData.AbsInsuranceData;
import view.component.TitledTextArea;

public class ShowInsuranceInfoSystem extends DevelopSystem {

	// Attribute
	private int insuranceID;
	
	// Constructor
	public ShowInsuranceInfoSystem(int insuranceID) {this.insuranceID=insuranceID;}

	@Override
	public Vector<JComponent> getViewInfo() {
		AbsInsuranceData insuranceData = this.insuranceDataList.search(this.insuranceID);
		Vector<JComponent> viewInfo = new Vector<JComponent>();
		viewInfo.add(new JLabel("요청하신 보험 정보 입니다."));
		viewInfo.add(new TitledTextArea("이름", 1, insuranceData.getName(), false));
		viewInfo.add(new TitledTextArea("설명", 10, insuranceData.getContent(), false));
		viewInfo.add(new TitledTextArea("요율 설명", 10, insuranceData.getInsuranceRateInfo(), false));
		viewInfo.add(new TitledTextArea("손해율", 1, Double.toString(insuranceData.getLossPercent()), false));
		viewInfo.add(new TitledTextArea("요율 검증 여부", 1, Boolean.toString(insuranceData.isInsuranceratePermit()), false));
		viewInfo.add(new TitledTextArea("상품 인가 여부", 1, Boolean.toString(insuranceData.isProductPermit()), false));
		return viewInfo;
	}
	
	// No Use
	@Override public DynamicSystem processEvent(ActionEvent e) {return null;}
}
