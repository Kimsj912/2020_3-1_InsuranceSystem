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
