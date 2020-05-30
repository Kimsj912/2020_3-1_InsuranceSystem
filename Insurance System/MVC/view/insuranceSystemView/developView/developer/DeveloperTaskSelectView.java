package view.insuranceSystemView.developView.developer;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class DeveloperTaskSelectView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {InsuranceDesign, WatchInsuranceData}
		
	// Constructor
	public DeveloperTaskSelectView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("업무 선택"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1,1});
		selectBtnGroup.addGroupComponent(new SelectButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener));
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
}
