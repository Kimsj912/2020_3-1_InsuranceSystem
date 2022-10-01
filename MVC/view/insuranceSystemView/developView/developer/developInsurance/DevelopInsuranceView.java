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
		this.addComponent(new BasicLabel("보험 정보 입력"));
		this.addComponent(new SeparateLine(Color.black));
		
		this.nameTTA = new InputTextArea("이름", "", 1,100);
		this.lossPercentTTA = new InputTextArea("손해율", "숫자로 입력", 1, 100);
		this.contentTTA = new InputTextArea("설명", "보험 설명을 입력해 주세요", 10, 100);
		this.insuranceRateInfoTTA = new InputTextArea("요율 설명", "요율 설명을 입력해 주세요", 10, 100);
		if(isDisease) {
			this.diseaseTRBG = new TitledRadioButtonGroup("보상 질병", EDisease.class, false, 100);
			StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1, 1});
			selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.diseaseTRBG, this.contentTTA, this.insuranceRateInfoTTA);
			this.addComponent(selectBtnGroup);
		}else {
			StaticGroup selectBtnGroup = new StaticGroup(new int[] {2, 1, 1});
			selectBtnGroup.addGroupComponent(this.nameTTA, this.lossPercentTTA, this.contentTTA, this.insuranceRateInfoTTA);
			this.addComponent(selectBtnGroup);
		}
		
		this.addComponent(new ActionButton("저장", EActionCommands.SaveInsuranceData.name(), actionListener));
		
		this.addToLinkPanel (
				new LinkButton("보험 설계", EActionCommands.InsuranceDesign.name(), actionListener),
				new LinkButton("보험 정보 확인", EActionCommands.WatchInsuranceData.name(), actionListener)
		);
	}
	
	// Getter & Setter
	public String getName() {return this.nameTTA.getContent();}
	public String getContent() {return this.contentTTA.getContent();}
	public String getInsuranceRateInfo() {return this.insuranceRateInfoTTA.getContent();}
	public String getLossPercent() {return this.lossPercentTTA.getContent();}
	public String getDisease() {return this.diseaseTRBG.getSelectedOptionNames().get(0);}
}
