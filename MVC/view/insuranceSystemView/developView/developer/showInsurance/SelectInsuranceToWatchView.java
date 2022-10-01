package view.insuranceSystemView.developView.developer.showInsurance;

import java.awt.Color;
import java.awt.event.ActionListener;

import model.data.insuranceData.AbsInsuranceData;
import dataList.IntISDataList;
import component.BasicLabel;
import component.SeparateLine;
import component.TitledRadioButtonGroup;
import component.button.LinkButton;
import component.button.SelectButton;
import component.group.DynamicGroup;
import component.textArea.InputTextArea;
import view.insuranceSystemView.InsuranceSystemView;

public class SelectInsuranceToWatchView extends InsuranceSystemView {

	// Static
	public enum EActionCommands {InsuranceDesign, WatchInsuranceData}
		
	// Component
	private InputTextArea nameTTA, contentTTA, insuranceRateInfoTTA, lossPercentTTA;
	private TitledRadioButtonGroup diseaseTRBG;
		
	// Constructor
	public SelectInsuranceToWatchView(ActionListener actionListener, IntISDataList<AbsInsuranceData> insuranceList) {
		InsuranceSystemView view = new InsuranceSystemView();
		view.addComponent(new BasicLabel("���� ����"));
		view.addComponent(new SeparateLine(Color.black));
		
		DynamicGroup selectBtnGroup = new DynamicGroup();
		for(AbsInsuranceData insuranceData : insuranceList.getList()) {
			selectBtnGroup.addGroupComponent(new SelectButton(insuranceData.getName(), Integer.toString(insuranceData.getID()), actionListener));
		}
		view.addComponent(selectBtnGroup);
		
		view.addToLinkPanel(
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
