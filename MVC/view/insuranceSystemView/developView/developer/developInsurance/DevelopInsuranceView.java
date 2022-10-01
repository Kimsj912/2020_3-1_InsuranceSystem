package view.insuranceSystemView.developView.developer.developInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.insuranceData.realInsuranceData.DiseaseInsuranceData.EDisease;
import component.BasicLabel;
import component.SeparateLine;
import component.TitledRadioButtonGroup;
import component.button.ActionButton;
import component.button.LinkButton;
import component.group.StaticGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

@SuppressWarnings("serial")
public class DevelopInsuranceView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {SaveInsuranceData, InsuranceDesign, WatchInsuranceData}
		
	// Component
	private InputTextArea nameTTA, contentTTA, insuranceRateInfoTTA, lossPercentTTA;
	private TitledRadioButtonGroup diseaseTRBG;
		
	// Constructor
	public DevelopInsuranceView(ActionListener actionListener, boolean isDisease) {
		this.addComponent(new BasicLabel("���� ���� �Է�"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.nameTTA = new InputTextArea("�̸�", "", 1,100);
		this.lossPercentTTA = new InputTextArea("������", "���ڷ� �Է�", 1, 100);
		this.contentTTA = new InputTextArea("����", "���� ������ �Է��� �ּ���", 10, 100);
		this.insuranceRateInfoTTA = new InputTextArea("���� ����", "���� ������ �Է��� �ּ���", 10, 100);
		if(isDisease) {
			this.diseaseTRBG = new TitledRadioButtonGroup("���� ����", EDisease.class, false, 100);
			StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1, 1});
			selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.diseaseTRBG, this.contentTTA, this.insuranceRateInfoTTA);
			this.addComponent(selectBtnGroup);
		}else {
			StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1});
			selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.contentTTA, this.insuranceRateInfoTTA);
			this.addComponent(selectBtnGroup);
		}
		
		this.addComponent(new ActionButton("����", EActionCommands.SaveInsuranceData.name(), actionListener));
		
		this.addToLinkPanel (
				new LinkButton("���� ����", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("���� ���� Ȯ��", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
	
	// Getter & Setter
	public String getName() {return this.nameTTA.getContent();}
	public String getContent() {return this.contentTTA.getContent();}
	public String getInsuranceRateInfo() {return this.insuranceRateInfoTTA.getContent();}
	public String getLossPercent() {return this.lossPercentTTA.getContent();}
	public String getDisease() {return this.diseaseTRBG.getSelectedOptionNames().get(0);}
}
