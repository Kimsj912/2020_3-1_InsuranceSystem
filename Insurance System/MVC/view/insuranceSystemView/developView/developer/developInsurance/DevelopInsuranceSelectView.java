package view.insuranceSystemView.developView.developer.developInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import view.component.BasicLabel;
import view.component.SeparateLine;
import view.component.button.LinkButton;
import view.component.button.SelectButton;
import view.component.group.StaticGroup;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class DevelopInsuranceSelectView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {CarInsurance, DiseaseInsurance, FireInsurance, InsuranceDesign, WatchInsuranceData}
		
	// Constructor
	public DevelopInsuranceSelectView(ActionListener actionListener) {
		this.addComponent(new BasicLabel("���� ���� ����"));
		this.addComponent(new SeparateLine(Color.black));
		
		StaticGroup selectBtnGroup = new StaticGroup(new int[] {1,1,1});
		selectBtnGroup.addGroupComponent(new SelectButton("�ڵ��� ����", EActionCommands.CarInsurance.name(), actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("���� ����", EActionCommands.DiseaseInsurance.name(), actionListener));
		selectBtnGroup.addGroupComponent(new SelectButton("ȭ�� ����", EActionCommands.FireInsurance.name(), actionListener));
		this.addComponent(selectBtnGroup);
		
		this.addToLinkPanel(
				new LinkButton("���� ����", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("���� ���� Ȯ��", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
}
