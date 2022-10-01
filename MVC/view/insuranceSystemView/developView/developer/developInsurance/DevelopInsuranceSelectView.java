package view.insuranceSystemView.developView.developer.developInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import component.BasicLabel;
import component.SeparateLine;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class DevelopInsuranceSelectView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {CarInsurance, DiseaseInsurance, FireInsurance, InsuranceDesign, WatchInsuranceData}
		
	// Constructor
	public DevelopInsuranceSelectView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("개발 보험 선택"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1,1,1});
		selectBtnGroup.addGroupComponent(new SelectButton("자동차 보험", EActionCommands.CarInsurance.name(), actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("질병 보험", EActionCommands.DiseaseInsurance.name(), actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("화재 보험", EActionCommands.FireInsurance.name(), actionListener));
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
}
